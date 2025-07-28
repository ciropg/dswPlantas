package dsw.sighierbabackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indica que esta clase contiene configuración de Spring
@EnableWebSecurity // Habilita la seguridad web de Spring
public class SecurityConfig {

    // Define la cadena de filtros de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Permite el acceso público al endpoint de registro de usuarios
                        .requestMatchers("/api/usuarios/registro").permitAll()
                        // Cualquier otra solicitud requiere autenticación
                        .anyRequest().authenticated()
                )
                // Habilita autenticación HTTP básica
                .httpBasic(Customizer.withDefaults())
                // Deshabilita CSRF (para pruebas o APIs sin navegador)
                .csrf(csrf -> csrf.disable());

        return http.build(); // Construye y retorna la configuración de seguridad
    }

    // Bean para encriptar contraseñas usando BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Retorna el codificador de contraseñas
    }
}
