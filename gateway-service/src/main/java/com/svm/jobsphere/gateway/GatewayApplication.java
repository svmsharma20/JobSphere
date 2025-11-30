package com.svm.jobsphere.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

//    @Bean
//    public RouterFunction<ServerResponse> customRoutes() {
//        return route("executor")
//                // Predicate: Match requests starting with /api/products/
//                .route(path("/executor/**"), http())
//
//                // Destination URI: Use lb:// for Eureka-managed load balancing
//                .before(uri("lb://executor"))
//
//                // Filter: Rewrite the path before forwarding
////                .filter(rewritePath("/api/(?<remaining>.*)", "/${remaining}"))
//                .build();
//
////                .and(route("order-route")
////                        .route(path("/api/orders/**"), http())
////                        .before(uri("lb://ORDER-SERVICE"))
////                        .filter(rewritePath("/api/(?<remaining>.*)", "/${remaining}"))
////                        .build()
////                );
//    }

//    private static RouterFunction<ServerResponse> http() {
//        return GatewayRouterFunctions.route(ServerResponse::ok);
//    }
}
