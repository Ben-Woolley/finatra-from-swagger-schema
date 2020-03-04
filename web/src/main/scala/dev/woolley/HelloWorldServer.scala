package dev.woolley

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{CommonFilters, LoggingMDCFilter, TraceIdMDCFilter}
import com.twitter.finatra.http.routing.HttpRouter
import io.swagger.models.Swagger
import io.swagger.parser.Swagger20Parser

import scala.io.Source

object HelloWorldServerMain extends HelloWorldServer

class HelloWorldServer extends HttpServer {

    private val swagger = new Swagger20Parser().parse(Source.fromInputStream(getClass.getResourceAsStream("/service.yaml")).getLines().mkString("\n"))

    private val docsController = new DocsController(swagger = swagger, endpoint = "/docs")

    override def configureHttp(router: HttpRouter): Unit = {
        router
                .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
                .add[HelloWorldController]
          .add(docsController)
    }
}