package com.vazquez.dbdherencia.Config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfing {

@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

    http.authorizeHttpRequests(ant->
            ant
               .requestMatchers("/index.html","/style.css","/loginUser.js").permitAll()
                    .requestMatchers("/formUser.html","wallpaper.jpg").permitAll()
               .requestMatchers(HttpMethod.POST, "/api/persons","/api/login").permitAll()
                    .anyRequest().authenticated())
            .csrf(csrf->csrf.disable())
            .headers(headers -> headers.frameOptions(options -> options.disable()));

    http.formLogin(formLogin ->
                formLogin.loginPage("/formUser.html")
                        .loginProcessingUrl("/api/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .successHandler( (request, response, authentication) -> clearAuthenticationAttributes(request))
                        .failureHandler((request, response, exception) -> response.sendError(403)))
            .exceptionHandling( exceptionHandlingConfigurer ->
                    exceptionHandlingConfigurer.authenticationEntryPoint((request, response, authException) -> response.sendError(403)))
            .logout(logout -> logout.logoutUrl("/api/logout")
            .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
            .deleteCookies("JSESSIONID"))
            .rememberMe(Customizer.withDefaults());

    return http.build();

}


    private void clearAuthenticationAttributes(HttpServletRequest request){
       HttpSession session =request.getSession(false);
        if(session != null){
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }

}

}
