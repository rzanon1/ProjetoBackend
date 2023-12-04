package br.upf.backendprojeto.service

import br.upf.backendprojeto.DTO.CandidatoDTO
import br.upf.backendprojeto.DTO.CandidatoResponseDTO
import br.upf.backendprojeto.converter.CandidatoConverter
import br.upf.backendprojeto.exceptions.NotFoundException
import br.upf.backendprojeto.repository.CampRepository
import br.upf.sistemaeventos.repository.CandidatoRepository
import org.springframework.stereotype.Service

private const val CANDIDATO_NOT_FOUND_MESSAGE = "Candidato não encontrado!"
@Service
class CandidatoService(
    private val repository: CandidatoRepository,
    private val converter: CandidatoConverter
) {
    fun listar(): List<CandidatoResponseDTO> {
        return repository.findAll()
            .map(converter::toCandidatoResponseDTO)
    }
    fun buscarPorId(id: Long): CandidatoResponseDTO {
        val candidato = repository.findById(id)
            .orElseThrow { NotFoundException( CANDIDATO_NOT_FOUND_MESSAGE) }
        return converter.toCandidatoResponseDTO(candidato)
    }
    fun cadastrar(dto: CandidatoDTO): CandidatoResponseDTO {
        return converter.toCandidatoResponseDTO(
            repository.save(converter.toCandidato(dto)))
    }

    fun atualizar(id: Long, dto: CandidatoDTO): CandidatoResponseDTO {
        val candidato = repository.findById(id)
            .orElseThrow { NotFoundException( CANDIDATO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                cidade = dto.cidade,
                telefone = dto.telefone
            )
        return converter.toCandidatoResponseDTO(repository.save(candidato))
    }
    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}