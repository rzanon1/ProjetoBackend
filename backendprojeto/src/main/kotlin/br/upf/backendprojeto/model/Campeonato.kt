package br.upf.backendprojeto.model

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime
import jakarta.persistence.*


@Entity
data class Campeonato(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val data: LocalDate,
    val dataInicioInsc: LocalDateTime,
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    @Enumerated(value = EnumType.STRING)
    val status: Status,
    @OneToMany(mappedBy = "campeonato")
    val candidatos: List<Inscricao> = listOf()
)
