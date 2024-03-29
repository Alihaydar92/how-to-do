package com.alinem.howtodo.config;
import com.alinem.howtodo.service.UserInfoUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withUsername("Heydar")
//                .password(encoder.encode("Narmin"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.withUsername("Narmin")
//                .password(passwordEncoder.encode("Heydar"))
//                .roles("USER")
//                .build();

        return new UserInfoUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        return http.httpBasic().and()
                .authorizeHttpRequests().requestMatchers("/topics/taqetSensiz","/users").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/topics/**","/allBlogs/**","/blogs/**")
                .authenticated().and()
                .authorizeHttpRequests().requestMatchers("/auth").authenticated().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}
