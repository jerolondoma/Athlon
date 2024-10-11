package com.athlon.athlon.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@ControllerAdvice
@OpenAPIDefinition(
    info=@Info(
        title="Atlhon",
        version = "1.0",
        description = "Api para generar,modificar y eliminar diferentes clientes"
    ),
    tags = {
        @Tag(
            name = "Base Controller",
            description = "Base Controller para la api, este controlador se extendera a todos los endpoints del api"


        )
    }
)
public class ApibaseController {
    
}
