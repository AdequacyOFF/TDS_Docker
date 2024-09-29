package com.tds.tds_project.utils;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Task Distribution System",
                description = "Система распределения задач и контроля их выполнения", version = "0.2.1",
                contact = @Contact(
                        name = "Столов Андрей",
                        email = "andrey_stolov@mail.ru",
                        url = "https://github.com/AdequacyOFF"
                )
        )
)
public class OpenApiConfig {
    
}