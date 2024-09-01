package br.com.oficina.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

  @Value("${oficina.openapi.dev-url}")
  private String devUrl;

//  @Value("${bezkoder.openapi.prod-url}")
//  private String prodUrl;

  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("URL do servidor");

//    Server prodServer = new Server();
//    prodServer.setUrl(prodUrl);
//    prodServer.setDescription("Server URL in Production environment");

    Contact contact = new Contact();
//    contact.setEmail("bezkoder@gmail.com");
//    contact.setName("BezKoder");
//    contact.setUrl("https://www.bezkoder.com");

//    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

    Info info = new Info()
        .title("API Oficina")
        .version("1.0")
        .contact(contact)
        .description("API de Gerenciamento");
//        .license(mitLicense);

    return new OpenAPI().info(info).servers(List.of(devServer));
  }
}
