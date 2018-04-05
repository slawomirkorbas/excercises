package game.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("game.controller")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
