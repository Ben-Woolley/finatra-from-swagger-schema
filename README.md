# Swagger Finatra Proof-of-concept
Attempting to:
* Generate model classes from Swagger Documentation
* Use the model classes in the web & service
* Use the Swagger definitions to power a swagger UI

The intention is to keep the API and the docs in sync, but reduce repetition and boilerplate.

## Next Steps
* Update finatra-swagger to accept an OpenAPI 3.1 instead of/as well as a Swagger
  * OR have DocsController accept a JSON of the spec, bypassing deserialization (how to handle yaml?)
* A more complex OpenAPI specification, using Optionals, sum types, and maps with non-string keys
  * The third requires OAS 3.1 for patternProperties
* Non-direct mapping to objects such as Currency, LocalDate
