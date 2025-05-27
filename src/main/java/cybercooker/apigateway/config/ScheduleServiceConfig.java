package cybercooker.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleServiceConfig {

    @Bean
    public RouteLocator scheduleRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("schedule-service", p -> p
                        .path("/api/schedule/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri("http://localhost:8081"))
                .build();
    }
}