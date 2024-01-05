package springmsa.springmsa_api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

    //@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(r -> r.path("/user/**")
                        .filters(f -> f.addRequestHeader("userServiceReq", "userServiceHeaderReq")
                                .addResponseHeader("userServiceRes", "userServiceHeaderRes"))
                        .uri("http://localhost:8081"))
                .build();
    }
}
