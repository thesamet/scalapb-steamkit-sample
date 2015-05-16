import sbt.Keys._

import com.trueaccord.scalapb.{ScalaPbPlugin => PB}

lazy val pipo = project.in(file("."))
  .settings(moduleName := "pipo")
  .settings(buildSettings: _*)
  .settings(PB.protobufSettings: _*)
  .settings(
    sourceDirectories in PB.protobufConfig ++= Seq(
      file("Resources/Protobufs/dota_s2/client")
    ),
     PB.includePaths in PB.protobufConfig ++= Seq(
      file("Resources/Protobufs"),
      file("Resources/Protobufs/dota_s2/client")
    )
  )

lazy val buildSettings = Seq(
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.11.6",
  organization := "com.github.baccata",
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-language:implicitConversions",
    "-language:higherKinds",
    "-language:existentials",
    "-language:postfixOps"
  ),
  scalacOptions in Test ++= Seq("-Yrangepos"),
  resolvers ++= Seq(
    Resolver.sonatypeRepo("snapshots"),
    Resolver.sonatypeRepo("releases")
  )
)





