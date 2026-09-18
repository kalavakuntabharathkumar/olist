package com.example.orders.config;
import com.example.orders.security.JwtFilter;
import com.example.orders.security.JwtService;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration @EnableMethodSecurity
public class SecurityConfig {
  @Bean SecurityFilterChain chain(HttpSecurity http,JwtFilter filter)throws Exception{
    return http.csrf(c->c.disable()).sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(a->a.requestMatchers("/api/auth/**").permitAll().anyRequest().authenticated())
      .addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class).build();
  }
  @Bean BCryptPasswordEncoder encoder(){return new BCryptPasswordEncoder();}
}
