package dk.greet

import com.coxautodev.graphql.tools.GraphQLQueryResolver

class GreetingQueryResolverService implements GraphQLQueryResolver {

    static lazyInit = false

    String greeting(String name) {
        "Greetings ${name}!"
    }

}
