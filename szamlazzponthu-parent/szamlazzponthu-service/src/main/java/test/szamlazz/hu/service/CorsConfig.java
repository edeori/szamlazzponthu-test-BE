package test.szamlazz.hu.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    @Value("${app.cors.allowed-origins:}")
    private String allowedOriginsProp;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                List<String> allowedOrigins = StringUtils.hasText(allowedOriginsProp)
                        ? Arrays.stream(allowedOriginsProp.split("\\s*,\\s*")).toList()
                        : List.of();

                var mapping = registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);

                if (!allowedOrigins.isEmpty()) {
                    mapping.allowedOrigins(allowedOrigins.toArray(String[]::new));
                } else {
                    // NINCS globális wildcard
                }
            }
        };
    }
}
