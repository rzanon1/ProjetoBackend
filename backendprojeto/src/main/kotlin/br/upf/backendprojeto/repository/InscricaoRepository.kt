package br.upf.backendprojeto.repository

import br.upf.backendprojeto.model.Inscricao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InscricaoRepository: JpaRepository<Inscricao, Long> {
}