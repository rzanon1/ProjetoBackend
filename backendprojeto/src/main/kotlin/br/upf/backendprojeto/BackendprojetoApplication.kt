package br.upf.backendprojeto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class BackendprojetoApplication

fun main(args: Array<String>) {
	runApplication<BackendprojetoApplication>(*args)
}
