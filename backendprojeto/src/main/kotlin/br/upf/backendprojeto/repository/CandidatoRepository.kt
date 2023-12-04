package br.upf.sistemaeventos.repository

import br.upf.backendprojeto.model.Candidato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CandidatoRepository: JpaRepository<Candidato, Long> {
}
