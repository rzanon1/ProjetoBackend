package br.upf.backendprojeto.DTO

data class CandidatoResponseDTO(
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String,
)