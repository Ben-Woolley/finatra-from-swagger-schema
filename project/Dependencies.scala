import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8"
  lazy val finatra = "com.twitter" %% "finatra-http" % "20.1.0"
  lazy val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"

  lazy val swaggerUi = "org.webjars" % "swagger-ui" % "3.25.0"
  lazy val swaggerUiVersion = swaggerUi.revision

  lazy val swaggerCore = "io.swagger" % "swagger-core" % "1.6.0" excludeAll ExclusionRule(organization = "com.fasterxml.jackson.core")

//  lazy val swaggerParser = "io.swagger.parser.v3" % "swagger-parser" % "2.0.18"
  lazy val swaggerParser = "io.swagger" % "swagger-parser" % "1.0.50" exclude("io.swagger", "swagger-core")
  lazy val jackson = "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.10.3"
}
