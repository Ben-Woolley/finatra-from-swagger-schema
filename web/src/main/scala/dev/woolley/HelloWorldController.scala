package dev.woolley

import dev.woolley.model._
import com.twitter.finatra.http.Controller

class HelloWorldController extends Controller {

  post("/serve") { serviceRequest: ServiceRequest =>
    println("Hello " + serviceRequest.name + " with id " + serviceRequest.id)
    ServiceResponse(serviceRequest.id)
  }
}
