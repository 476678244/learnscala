package org.zonghan.cue

import java.io.{File, FileWriter}

object CueFileGenerator extends App {

  val dir: String = "/Users/wuzonghan/Music/张靓颖"

  val performer: String = "张靓颖"

  val album: String = "华语乐坛十大流行天后-张靓颖"

  val musicType: String = ".wav"

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
        new TrackItemDataGenerator(performer, f.getName.replace(musicType, ""), f.getName, (i+1).toString).generate(fw)
      }
    })
  } finally {
    fw.close()
  }

}
