package gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //disabilito dei comportamenti di default
        httpSecurity.formLogin(http->http.disable()); //tolgo il form di login perché questo andrà fatto con React
        httpSecurity.csrf(http->http.disable()); //tolgo la protezione da attacchi CSRF, non necessaria
        httpSecurity.sessionManagement(http->http.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //tolgo le sessioni perché con JWT non si utilizzano
        httpSecurity.authorizeHttpRequests(http->http.requestMatchers("/**").permitAll()); //evito di ricevere 401 su ogni richiesta
        return httpSecurity.build();
    }
}
