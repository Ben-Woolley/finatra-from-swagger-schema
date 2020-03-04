import Dependencies._

ThisBuild / scalaVersion     := "2.12.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "dev.woolley"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "finatra-from-swagger-schema",
    libraryDependencies += scalaTest % Test
  ).aggregate(api, web)

lazy val api = (project in file("api"))
  .settings(
    name := "api",
    swaggerCodeGenPackage := "dev.woolley.model",
    swaggerGenerateJsonRW := false,
    swaggerGenerateClient := false,
    swaggerGenerateServer := false,
    swaggerModelFilesSplitting := "oneFilePerModel",
    libraryDependencies += scalaTest % Test,
    Compile / unmanagedResourceDirectories += baseDirectory.value / "src" / "main" / "swagger",
  ).enablePlugins(SwaggerCodegenPlugin)

lazy val web = (project in file("web"))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    name := "web",
    buildInfoKeys := Seq[BuildInfoKey](BuildInfoKey("swaggerUiVersion", swaggerUiVersion)),
    buildInfoPackage := "dev.woolley.buildinfo",
    libraryDependencies ++= Seq(
      finatra,
      jackson,
      swaggerCore,
      swaggerParser,
      swaggerUi,
      logback,
      scalaTest % Test)
  ).dependsOn(api)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
