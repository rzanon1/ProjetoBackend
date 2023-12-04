package br.upf.backendprojeto.DTO

import br.upf.backendprojeto.model.Inscricao
import br.upf.backendprojeto.model.Status
import java.time.LocalDate
import java.time.LocalDateTime

data class CampResponseDTO (
    val id: Long?,
    val nome: String,
    val data: LocalDate,
    val dataInicioInsc: LocalDateTime,
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    val status: Status,
    val inscritos: List<Inscricao>
)