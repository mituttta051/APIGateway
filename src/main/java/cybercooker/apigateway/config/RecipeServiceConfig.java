package cybercooker.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeServiceConfig {

    @Bean
    public RouteLocator recipeRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("recipe-service", p -> p
                        .path("/api/recipe/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri("http://localhost:8080"))
                .build();
    }
}