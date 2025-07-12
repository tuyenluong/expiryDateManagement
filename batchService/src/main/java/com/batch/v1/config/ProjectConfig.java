package com.batch.v1.config;//package com.ims.product.v1.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class ProjectConfig {
//
//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/api/**/**").permitAll())
//                .formLogin(loginConfigurer -> Customizer.withDefaults())
//                .logout(logoutConfigurer -> Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        http.headers(headersConfigurer -> headersConfigurer
//                .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
//        return http.build();
//
//    }
//
////    @Bean
////    public InMemoryConfiguration inMemoryConfiguration(){
////
////    }
//}
