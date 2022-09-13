package ru.nikonov.metrics.common.security;

import static ru.nikonov.metrics.enums.RoleEnum.ADMIN;
import static ru.nikonov.metrics.enums.RoleEnum.USER;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.GET, "/api/**").hasAnyRole(ADMIN.name(), USER.name())
            .antMatchers(HttpMethod.POST, "/api/**").hasRole(ADMIN.name())
            .antMatchers(HttpMethod.PUT, "/api/**").hasRole(ADMIN.name())
            .antMatchers(HttpMethod.DELETE, "/api/**").hasRole(ADMIN.name())
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles(ADMIN.name())
                .build(),
            User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles(USER.name())
                .build()
        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
