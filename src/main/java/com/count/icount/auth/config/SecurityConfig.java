package com.count.icount.auth.config;

import com.count.icount.auth.AuthProvider.ICountDaoAuthenticationProvider;
import com.count.icount.auth.filter.ICountSecurityFilter;
import com.count.icount.auth.service.ICountUserDetailService;
import com.count.icount.auth.service.handler.ICountAuthenticationFailedHandler;
import com.count.icount.auth.service.handler.ICountAuthenticationSuccessHandler;
import com.count.icount.config.CorsConfig;
import lombok.RequiredArgsConstructor;
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
    public ICountSecurityFilter authFilter(HttpSecurity http) throws Exception {
        ICountSecurityFilter filter = new ICountSecurityFilter(authenticationSuccessHandler, authenticationFailedHandler);
        filter.setAuthenticationManager(authenticationManager(http));
        return filter;
    }


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http)
            throws Exception {
        http
                .csrf().disable()
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
