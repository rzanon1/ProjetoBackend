package br.upf.backendprojeto.DTO

import br.upf.backendprojeto.model.Status
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDate
import java.time.LocalDateTime

data class CampDTO(
    @field:NotEmpty(message = "Campeonato sempre deve ter um nome" )
    val nome: String,
    @field:NotEmpty(message = "Campeonato sempre deve ter uma data" )
    val data: LocalDate,
    @field:NotEmpty (message = "Deve ter uma data de inicio das inscrições" )
    val dataInicioInsc : LocalDateTime ,
    @field:NotEmpty (message = "Deve ter uma data de fim das inscrições" )
    val dataFimInsc: LocalDateTime ,
    val descricao: String,
    val status: Status
)