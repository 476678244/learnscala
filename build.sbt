name := "learn_scala"
 
version := "0.1"
 
scalaVersion := "2.9.2"
 
//seq(cucumberSettings : _*)

unmanagedBase <<= baseDirectory { base => base / "manageLib" }

unmanagedJars in Compile <<= baseDirectory map { base => (base ** "*.jar").classpath }

//unmanagedJars in Compile <++= baseDirectory map { base =>
//    val baseDirectories = (base / "libA") +++ (base / "b" / "lib") +++ (base / "libC")
//    val customJars = (baseDirectories ** "*.jar") +++ (base / "d" / "my.jar")
//    customJars.classpath
//}

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.6.1" % "test"
)
