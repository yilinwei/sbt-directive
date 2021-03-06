lazy val publishSettings = Seq(
  name := "multi-module",
  scalaVersion := "2.11.8",
  organization := "com.ithaca",
  version := "0.0.1-SNAPSHOT"
)

lazy val kernel = (project in file("kernel")).settings(
  publishSettings,
  directiveSettings,
  preprocessors += preprocess.skip("strip")
)

lazy val core = (project in file("core"))
  .settings(publishSettings,
    moduleName := "core"
  ).dependsOn(kernel)

lazy val root = (project in file("."))
  .aggregate(core, kernel)
