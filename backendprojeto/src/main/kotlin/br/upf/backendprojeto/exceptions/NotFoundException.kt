package br.upf.backendprojeto.exceptions

class NotFoundException(override val message: String)
    : RuntimeException()