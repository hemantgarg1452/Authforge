package in.project.authforge.config;

import in.project.authforge.service.AppUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class securityConfig {

    private final AppUserDetailsService appUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilerChain(HttpSecurity http) throws Exception{
        http.cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->auth
                        .requestMatchers("/login","/register","/send-reset-otp","/reset-password","/logout")
                        .permitAll().anyRequest().authenticated())
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .logout(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsFilter corsFilter(){
        return new CorsFilter(corsconfiurationSource());
    }

//doubts: string changes

    private CorsConfigurationSource corsconfiurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin(String.valueOf(List.of("http://localhost:5173")));
        configuration.addAllowedMethod(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH").toString());
        configuration.addAllowedHeader(String.valueOf(List.of("Authorization","Content-Type")));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(appUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authenticationProvider);
    }
}
