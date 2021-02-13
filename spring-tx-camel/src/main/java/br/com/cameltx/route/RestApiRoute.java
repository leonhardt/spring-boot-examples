package br.com.cameltx.route;

import br.com.cameltx.dto.TransactionCreateRequest;
import br.com.cameltx.service.TransactionService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class RestApiRoute extends RouteBuilder {

    @Autowired
    private Environment env;

    @Override
    public void configure() {
        restConfiguration()
                .component("servlet")
                .contextPath("/api").apiContextPath("/api-doc")
                .apiProperty("api.title", "Camel REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
                .port(env.getProperty("server.port", "8080"))
                .bindingMode(RestBindingMode.json);

        rest("/transactions").description("Transactions REST service")
                .consumes("application/json")
                .post("/").description("Post transactions example")
                .type(TransactionCreateRequest.class)
                .route().routeId("transactions-api")
                .bean(TransactionService.class, "save")
                .endRest();
    }

}
