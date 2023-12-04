package br.upf.backendprojeto.model

import jakarta.persistence.*


@Entity
data class Candidato(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String,
    @OneToMany(mappedBy = "candidato")
    val inscricoes: List<Inscricao> = listOf()
)