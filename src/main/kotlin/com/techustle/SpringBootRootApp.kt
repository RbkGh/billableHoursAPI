package com.techustle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootRootApp

fun main(args: Array<String>) {
	runApplication<SpringBootRootApp>(*args)
}
