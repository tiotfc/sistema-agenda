package br.com.sada.sistema.agenda.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerService {

	@Bean
	public Docket agendaApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.securitySchemes(Arrays.asList(new ApiKey("Bearer", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
				.securityContexts(Arrays.asList(securityContext()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("API de Agenda de Contatos")
				.description("API de agenda de contatos")
				.version("1.0.0")
				.build();

		return apiInfo;
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
				.securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex("/contatos.*")) 
				.build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("Bearer", authorizationScopes));
	}
}
