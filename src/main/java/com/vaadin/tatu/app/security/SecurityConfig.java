package com.vaadin.tatu.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.vaadin.tatu.app.Application;
import com.vaadin.tatu.backend.data.Role;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final RedirectAuthenticationSuccessHandler successHandler;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder,
            RedirectAuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // Not using Spring CSRF here to be able to use plain HTML for the login
        // page
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(new AntPathRequestMatcher("/VAADIN/**"))
                .permitAll().requestMatchers(new AntPathRequestMatcher("/**"))
                .hasAnyAuthority(Role.getAllRoles()));
        http.csrf(csrfCustomizer -> csrfCustomizer.disable());

        http.formLogin(config -> config.loginPage(Application.LOGIN_URL)
                .loginProcessingUrl(Application.LOGIN_PROCESSING_URL)
                .failureUrl(Application.LOGIN_FAILURE_URL)
                .successHandler(successHandler).permitAll());

        http.logout(config -> config.logoutSuccessUrl(Application.LOGOUT_URL));

        return http.build();
    }

}
