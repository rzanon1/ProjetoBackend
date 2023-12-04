package br.upf.backendprojeto.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Inscricao(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    val candidato: Candidato,
    @ManyToOne
    val campeonato: Campeonato,
    val data: LocalDateTime = LocalDateTime.now()
)