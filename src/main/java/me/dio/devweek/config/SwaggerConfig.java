package me.dio.devweek.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server server = new Server();
        server.setUrl("https://www.walter.br/escola");
        server.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("wevl@walter.br");
        contact.setName("Walter");
        contact.setUrl("https://www.walter.br");

        License mitLicense = new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Gestão Escolar")
                .version("1.0")
                .contact(contact)
                .description("API backend do sistema de gestãioo escolar.")
                .termsOfService("https://www.walter.br")
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }}
