package com.techustle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.GetMapping
import springfox.documentation.swagger2.annotations.EnableSwagger2

//@EnableSwagger2
@SpringBootApplication
class SpringBootRootApp

fun main(args: Array<String>) {
    runApplication<SpringBootRootApp>(*args)
}


