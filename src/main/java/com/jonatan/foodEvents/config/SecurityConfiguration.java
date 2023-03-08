package com.jonatan.foodEvents.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(List.of("http://localhost:4200","http://localhost:8080","http://localhost:8100"));
        configuration.setAllowedMethods(List.of("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
        configuration.setAllowedHeaders(List.of("Access-Control-Allow-Origin", "X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/getUserByUsername/{username}").permitAll()
                .requestMatchers("/api/getUserById/{id}").permitAll()
                .requestMatchers("/api/crearEvento").permitAll()
                .requestMatchers("/api/updateEvento/{id_evento}").permitAll()
                .requestMatchers("/api/getEventosDeUsuario/{id_usuario}").permitAll()
                .requestMatchers("/api/getAllUbicaciones").permitAll()
                .requestMatchers("/api/getUbicacion/{id_ubicacion}").permitAll()
                .requestMatchers("/api/getUbicacionesPorTipo/{tipo}").permitAll()
                .requestMatchers("/api/getAllMenus").permitAll()
                .requestMatchers("/api/getAllDecoraciones").permitAll()
                .requestMatchers("/api/getMesasDeEvento/{id_evento}").permitAll()
                .requestMatchers("/api/addMesa").permitAll()
                .requestMatchers("/api/getMesa/{id_mesa}").permitAll()
                .requestMatchers("/api/editMesa/{id_mesa}").permitAll()
                .requestMatchers("/api/deteleMesa/{id_mesa}").permitAll()
                .requestMatchers("/api/getComensalesDeMesa/{id_mesa}").permitAll()
                .requestMatchers("/api/getComensalesDeEvento/{id_evento}").permitAll()
                .requestMatchers("/api/addComensal").permitAll()
                .requestMatchers("/api/editComensal/{id_comensal}").permitAll()
                .requestMatchers("/api/deteleComensal/{id_comensal}").permitAll()
                .requestMatchers("/api/getAllEventos").permitAll()
                .requestMatchers("/api/deteleEvento/{id_evento}").permitAll()
                .requestMatchers("/api/getAllUsuarios").permitAll()
                .requestMatchers("/api/deleteUser/{id_usuario}").permitAll()
                .requestMatchers("/api/editUser/{id_usuario}").permitAll()
                .requestMatchers("/api/createUser").permitAll()
                .requestMatchers("/api/createUbicacion").permitAll()
                .requestMatchers("/api/editUbicacion/{id_ubicacion}").permitAll()
                .requestMatchers("/api/deleteUbicacion/{id_ubicacion}").permitAll()
                .requestMatchers("/api/createMenu").permitAll()
                .requestMatchers("/api/editMenu/{id_menu}").permitAll()
                .requestMatchers("/api/deleteMenu/{id_menu}").permitAll()
                .requestMatchers("/api/createDecoracion").permitAll()
                .requestMatchers("/api/editDecoracion/{id_decoracion}").permitAll()
                .requestMatchers("/api/deleteDecoracion/{id_decoracion}").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
