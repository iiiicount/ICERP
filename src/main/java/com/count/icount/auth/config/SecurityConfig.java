package com.count.icount.auth.config;

import com.count.icount.auth.AuthProvider.ICountDaoAuthenticationProvider;
import com.count.icount.auth.filter.ICountAuthenticationSecurityFilter;
import com.count.icount.auth.service.ICountUserDetailService;
import com.count.icount.auth.service.handler.ICountAuthenticationFailedHandler;
import com.count.icount.auth.service.handler.ICountAuthenticationSuccessHandler;
import com.count.icount.config.CorsConfig;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CorsConfig corsConfig;
    private final ICountUserDetailService userDetailService;
    private final ICountAuthenticationSuccessHandler authenticationSuccessHandler;
    private final ICountAuthenticationFailedHandler authenticationFailedHandler;


    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(this.corsConfig.getAllowedHeaders());
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedMethods(this.corsConfig.getAllowedMethods());
        corsConfiguration.setAllowedOrigins(this.corsConfig.getAllowedOrigins());
        corsConfiguration.setMaxAge(this.corsConfig.getMaxAge());

        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return corsConfigurationSource;
    }

    @Bean
    public SecurityContextRepository securityContextRepository(){
        return new HttpSessionSecurityContextRepository();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public ICountDaoAuthenticationProvider customDaoAuthenticationProvider(){
        return new ICountDaoAuthenticationProvider(userDetailService, passwordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http)
            throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(customDaoAuthenticationProvider());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public ICountAuthenticationSecurityFilter authFilter(HttpSecurity http) throws Exception {
        ICountAuthenticationSecurityFilter filter = new ICountAuthenticationSecurityFilter(
                authenticationSuccessHandler,
                authenticationFailedHandler,
                securityContextRepository()
        );
        filter.setAuthenticationManager(authenticationManager(http));
        return filter;
    }


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http)
            throws Exception {
        http
                .cors().configurationSource(corsConfigurationSource()).and()
                .csrf().disable()
                .securityContext(securityContext -> securityContext
                        .securityContextRepository(securityContextRepository()))
                .addFilterBefore(authFilter(http),
                        UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(config -> config
                        .anyRequest().permitAll())
                .formLogin(form -> form
                        .loginProcessingUrl("/login")
                )
                .logout(config -> config
                        .logoutUrl("/logout"));
        return http.build();
    }

}
