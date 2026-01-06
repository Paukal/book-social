package com.project.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/*@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}*/

@SpringBootApplication
public class GatewayApplication {

    //Uncomment for local dev without k8:
    //String uri_books = "http://localhost:8081";
    //String uri_authors = "http://localhost:8082";
    String uri_books = "http://book-service:8081";
    String uri_authors = "http://author-service:8082";

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/books")
                        .filters(f -> f
                                .prefixPath("/v1/book-info")
                                .addResponseHeader("X-TestHeader", "foobar")
                        )
                        .uri(uri_books)
                )
                .route(r -> r
                        .path("/book")
                        .filters(f -> f
                                .prefixPath("/v1/book-info")
                                .addResponseHeader("X-TestHeader", "foobar")
                        )
                        .uri(uri_books)
                )
                .route(r -> r
                        .path("/authors")
                        .filters(f -> f
                                .prefixPath("/v1/author-info")
                                .addResponseHeader("X-TestHeader", "foobar")
                        )
                        .uri(uri_authors)
                )
                .route(r -> r
                        .path("/author")
                        .filters(f -> f
                                .prefixPath("/v1/author-info")
                                .addResponseHeader("X-TestHeader", "foobar")
                        )
                        .uri(uri_authors)
                )
                .build();
    }
}