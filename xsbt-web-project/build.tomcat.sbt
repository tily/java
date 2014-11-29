name := "hello-servlet"

scalaVersion := "2.10.0"

seq(webSettings :_*)

// WARファイル名から、バージョンの表記を省くための設定
artifactName in packageWar := {
  (scalaVersion: ScalaVersion, module: ModuleID, artifact: Artifact) =>
    artifact.name + "." + artifact.extension
}

libraryDependencies ++= Seq(
  "org.apache.tomcat.embed" % "tomcat-embed-core"         % "7.0.22" % "container",
  "org.apache.tomcat.embed" % "tomcat-embed-logging-juli" % "7.0.22" % "container",
  "org.apache.tomcat.embed" % "tomcat-embed-jasper"       % "7.0.22" % "container"
)
