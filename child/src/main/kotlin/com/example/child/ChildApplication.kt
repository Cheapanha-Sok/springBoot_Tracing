package com.example.child

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ChildApplication

fun main(args: Array<String>) {
	runApplication<ChildApplication>(*args)
}