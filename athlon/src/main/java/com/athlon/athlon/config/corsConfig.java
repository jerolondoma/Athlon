package com.athlon.athlon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class corsConfig  implements WebMvcConfigurer{
    
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/*")
        .allowedOrigins("*")//Escribir la url del proyecto front a conectar
        .allowedMethods("*")//podemos especificar los metodos a permitir desfde el front
        .allowCredentials(true);//para que permita las credenciales
    }

}
