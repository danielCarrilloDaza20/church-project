package co.edu.uptc.gerencia.security;

import co.edu.uptc.gerencia.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    // Add support for JDBC ... No more hardcoded users

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("USER")
                                .requestMatchers("/students/**").hasRole("TEACHER")
                                .requestMatchers("/teachers/**", "/students/**").hasRole("ADMINISTRATOR")
                                .requestMatchers("/register/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authUser")
                                .defaultSuccessUrl("/", true)
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()

                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );
        return http.build();
    }





    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails daniel = User.builder()
                .username("daniel")
                .password("{noop}daniel123")
                .roles("USER")
                .build();

        UserDetails felipe = User.builder()
                .username("felipe")
                .password("{noop}felipe123")
                .roles("USER", "TEACHER")
                .build();

        UserDetails daniela = User.builder()
                .username("daniela")
                .password("{noop}daniela123")
                .roles("USER", "TEACHER", "ADMINISTRATOR")
                .build();
        return new InMemoryUserDetailsManager(daniel, felipe, daniela);
    }

     */
}
