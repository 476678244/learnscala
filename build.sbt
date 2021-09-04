name := "learnscala"

version := "1.0"
//jdk -> 1.8
scalaVersion := "2.12.5"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % Test

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.12"

libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.4.0"