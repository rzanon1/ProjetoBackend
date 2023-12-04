package br.upf.backendprojeto.converter

import br.upf.backendprojeto.DTO.CampDTO
import br.upf.backendprojeto.DTO.CampResponseDTO
import br.upf.backendprojeto.model.Campeonato
import org.springframework.stereotype.Component


@Component
class CampConverter  {
    fun toCampeonato(dto: CampDTO): Campeonato {
        return Campeonato(
            nome = dto.nome,
            data = dto.data,
            dataInicioInsc = dto.dataInicioInsc,
            dataFimInsc = dto.dataFimInsc,
            descricao = dto.descricao,
            status = dto.status,
            candidatos = listOf()
        )
    }
    fun tocampResponseDTO(campeonato: Campeonato): CampResponseDTO {
        return CampResponseDTO(
            id = campeonato.id,
            nome = campeonato.nome,
            data = campeonato.data,
            dataInicioInsc = campeonato.dataInicioInsc,
            dataFimInsc = campeonato.dataFimInsc,
            descricao = campeonato.descricao,
            status = campeonato.status,
            inscritos = campeonato.candidatos
        )
    }

}