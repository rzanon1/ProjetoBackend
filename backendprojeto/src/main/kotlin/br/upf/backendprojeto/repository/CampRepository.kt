package br.upf.backendprojeto.repository

import br.upf.backendprojeto.model.Campeonato
import br.upf.backendprojeto.model.Candidato
import br.upf.backendprojeto.model.Inscricao
import br.upf.backendprojeto.model.Status
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate

@Repository
interface CampRepository: JpaRepository<Campeonato, Long> {
    fun findByNome(nomeCampeonato: String, paginacao: Pageable): Page<Campeonato>
}

