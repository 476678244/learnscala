package org.zonghan.cue

import java.io.{File, FileWriter}

object CueFileGenerator extends App {

  val dir: String = "/Users/wuzonghan/Music/Julia.Fischer.&amp;.Martin.Helmchen.-.[Schubert.Complete.Works.for.Violin.&amp;.Piano.(CD.1)].专辑.(Flac)"

  val performer: String = "Julia.Fischer.&.Martin.Helmchen"

  val album: String = "Schubert.Complete.Works.for.Violin.&.Piano.(CD.1)"

  val musicType: String = ".flac"

  val cueFilePath = s"${dir}/cue.cue"

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
          Math.min(rawTitle.indexOf("."), {
              if (rawTitle.indexOf("-") > 0)
                rawTitle.indexOf("-") + 1
              else if (rawTitle.indexOf("_") > 0)
                rawTitle.indexOf("_") + 1
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
