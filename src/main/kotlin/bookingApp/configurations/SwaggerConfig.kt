package bookingApp.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket? = Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("bookingApp.controllers"))
            .build()
            .apiInfo(
                    ApiInfo(
                            "Booking app API",
                            "For more info visit https://github.com/Diamindes/BookingApp",
                            "0.01",
                            "",
                           null,
                            "",
                            "",
                            emptyList()
                    )
            )
}