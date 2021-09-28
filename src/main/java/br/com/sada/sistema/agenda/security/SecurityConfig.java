package br.com.sada.sistema.agenda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.sada.sistema.agenda.services.UsuarioServiceImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AutenticacaoService autenticacaoService;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(encoder());
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().csrf().disable()
		.authorizeRequests().antMatchers("/h2-console/**").permitAll()
		.antMatchers("/v2/api-docs","/swagger-ui/**","/swagger-resources/**","/swagger-ui.html**","/webjars/**","favicon.ico").permitAll()
		.antMatchers("/auth/**").permitAll()
		.antMatchers("/email/**").permitAll()
		.anyRequest().authenticated()
		.and().headers().frameOptions().sameOrigin()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new JwtTokenFilter(tokenService, usuarioService), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	protected BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
