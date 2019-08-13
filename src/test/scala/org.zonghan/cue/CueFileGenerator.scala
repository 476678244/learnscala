package org.zonghan.cue

import java.io.{File, FileWriter}

object CueFileGenerator extends App {

  val dir: String = "/Users/wuzonghan/Music/周传雄合集(25CD).flac/周传雄 - 1997.我的心太乱[百代].flac"

  val performer: String = "周传雄"

  val album: String = "我的心太乱"

  val musicType: String = ".flac"

  val cueFilePath = s"${dir}/cue.cue"

  val skipStr = s"_FR725SACD_2ch256"

  val cueFile = new File(cueFilePath)
  if (cueFile.exists())
    cueFile.delete()
  cueFile.createNewFile()

  val fw = new FileWriter(cueFilePath)
  try {
    new GlobalDataGenerator(performer, album).generate(fw)
    new File(dir).listFiles().filter(f => {
      !f.getName.startsWith(".")
    }).sortBy(f=> {
      f.getName
    }).zipWithIndex.foreach(data => {
      val (f, i) = data
      if (f.isFile && f.getName.endsWith(musicType)) {
        val rawTitle = f.getName.replace(musicType, "")
        val startSub = Math.max(
          if (rawTitle.indexOf(".") > 0)
            rawTitle.indexOf(".")
          else {
            Math.max(rawTitle.indexOf("."), {
              if (rawTitle.indexOf("-") > 0)
                rawTitle.indexOf("-") + 1
              else if (rawTitle.indexOf("_") > 0)
                rawTitle.indexOf("_") + 1
              else
                0
            }
            )
          },
          0
        )
        val trackTitle = rawTitle.substring(startSub).trim.replace(skipStr, "")
        new TrackItemDataGenerator(performer, trackTitle, f.getName, (i+1).toString).generate(fw)
      }
    })
  } finally {
    fw.close()
  }

}
