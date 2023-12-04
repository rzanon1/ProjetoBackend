package br.upf.backendprojeto.converter

import br.upf.backendprojeto.DTO.CandidatoDTO
import br.upf.backendprojeto.DTO.CandidatoResponseDTO
import br.upf.backendprojeto.model.Candidato
import org.springframework.stereotype.Component

@Component
class CandidatoConverter {
    fun toCandidatoResponseDTO(candidato: Candidato): CandidatoResponseDTO {
        return CandidatoResponseDTO(
            id = candidato.id,
            nome = candidato.nome,
            cidade = candidato.cidade,
            telefone = candidato.telefone
        )
    }
    fun toCandidato(dto: CandidatoDTO): Candidato {
        return Candidato(
            nome = dto.nome,
            cidade = dto.cidade,
            telefone = dto.telefone
        )
    }
}