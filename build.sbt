lazy val publishSettings = Seq(
  name := "sbt-directive",
  scalaVersion := "2.10.6",
  licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html")),
  organization := "com.ithaca",
  version := "0.0.1-SNAPSHOT"
)

lazy val commonSettings = Seq(
  resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  )
)

lazy val macroSettings = Seq(
  scalaVersion := "2.10.6",
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % "2.10.6",
    "org.scalamacros" %% "quasiquotes" % "2.1.0"
  )    
)

lazy val macros = (project in file("macros"))
  .settings(commonSettings)
  .settings(macroSettings)

lazy val root = (project in file("."))
  .settings(sbtPlugin := true)
  .settings(commonSettings: _*)
  .settings(publishSettings: _*)
  .dependsOn(macros)

