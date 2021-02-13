package br.com.cameltx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringTxtCamelApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringTxtCamelApplication.class, args);
    }
}
