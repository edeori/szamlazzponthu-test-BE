package test.szamlazz.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = "test.szamlazz.hu")
@ConfigurationPropertiesScan
public class SzamlazzponthuApplication {
    public static void main(String[] args) {
        SpringApplication.run(SzamlazzponthuApplication.class, args);
    }
}