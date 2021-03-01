package com.br.systemvoting.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
		  info = @Info(
		  title = "System-Voting",
		  description = "" +
		    "Documentção da api ",
		  contact = @Contact(
		    name = "Felipe Ribeiro Simões Diniz" ,
			email = "felipersdiniz@gmail.com.br"
		  ),
		  license = @License(
		    name = "MIT Licence")),
		  servers = @Server(url = "http://localhost:8080/v1"))
public class Swagger {
    
}
