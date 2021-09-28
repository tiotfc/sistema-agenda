package br.com.sada.sistema.agenda.services;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerService {

	@Bean
	public Docket agendaApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.securitySchemes(Arrays.asList(new ApiKey("Token access", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
    private ApiInfo apiInfo() {

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title ("API de Agenda de Contatos")
                .description ("API de agenda de contatos")
                .version("1.0.0")
                .build();

        return apiInfo;
    }

}
