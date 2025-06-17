package ContactBook.Contact.Book.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
// Diperlukan import baru
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("\n\n===== MEMUAT KONFIGURASI KEAMANAN KUSTOM! =====\n\n");

        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(HttpMethod.GET, "/**").permitAll()
//                        .anyRequest().authenticated()
                                .anyRequest().permitAll() // Mengizinkan semua request

                );
        return http.build();
    }
}