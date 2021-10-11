package dk.greet

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
class GraphqlEndpointIntegrationSpec extends Specification {

    RestBuilder restBuilder = new RestBuilder()

    def "graphql endpoint should produce answer to query"() {
        when:
        RestResponse response = restBuilder.post("${baseUrl}/graphql") {
            contentType('application/graphql')
            json('{ greeting(name: "Puneet") }')
        }

        then:
        response.text == '{"data":{"greeting":"Greetings Puneet!"}}'
    }

    String getBaseUrl() {
        "http://localhost:$serverPort"
    }

}
