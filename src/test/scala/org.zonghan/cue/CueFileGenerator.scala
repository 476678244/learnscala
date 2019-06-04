package org.zonghan.cue

import java.io.{File, FileWriter}

object CueFileGenerator extends App {

  val dir: String = "/Users/wuzonghan/Music/Converted by MediaHuman/BIZET L'ARLESIENNE SUITE NO.1 & 2, CARMEN SUITE"

  val performer: String = "BIZET"

  val album: String = "L'ARLESIENNE SUITE NO.1 & 2, CARMEN SUITE"

  val musicType: String = ".dsf"

  val cueFilePath = s"${dir}/cue.cue"

  val cueFile = new File(cueFilePath)
  if (cueFile.exists())
    cueFile.delete()
  cueFile.createNewFile()

  val fw = new FileWriter(cueFilePath)
  try {
    new GlobalDataGenerator(performer, album).generate(fw)
    new File(dir).listFiles().sortBy(f=> {
      f.getName
    }).zipWithIndex.foreach(data => {
      val (f, i) = data
      if (f.isFile && f.getName.endsWith(musicType)) {
        val rawTitle = f.getName.replace(musicType, "")
        val startSub = Math.max(
          Math.max(rawTitle.indexOf("."), {
              if (rawTitle.lastIndexOf("-") > 0)
                rawTitle.lastIndexOf("-") + 1
              else
                0
            }
          ),
          0
        )
        val trackTitle = rawTitle.substring(startSub).trim
        new TrackItemDataGenerator(performer, trackTitle, f.getName, (i+1).toString).generate(fw)
      }
    })
  } finally {
    fw.close()
  }

}
