package br.upf.backendprojeto.service

import br.upf.backendprojeto.DTO.CampDTO
import br.upf.backendprojeto.DTO.CampResponseDTO
import br.upf.backendprojeto.converter.CampConverter
import br.upf.backendprojeto.exceptions.NotFoundException
import br.upf.backendprojeto.repository.CampRepository
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable

private val CAMP_NOT_FOUND_MESSAGE = "Campeonato não encontrado!"

@Service
class CampService(
    private val repository: CampRepository,
    private val converter: CampConverter
) {


    fun listar(
        nomeCampeonato: String?,
        paginacao: Pageable): Page<CampResponseDTO> {
        val campeonatos = if (nomeCampeonato == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeCampeonato, paginacao)
        }
        return campeonatos
            .map(converter::tocampResponseDTO)
    }

    fun buscarPorId(id: Long): CampResponseDTO {
        val campeonato = repository.findById(id)
            .orElseThrow { NotFoundException(CAMP_NOT_FOUND_MESSAGE) }
        return converter.tocampResponseDTO(campeonato)
    }

    fun atualizar(id: Long, dto: CampDTO): CampResponseDTO {
        val campeonato = repository.findById(id)
            .orElseThrow { NotFoundException(CAMP_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                data = dto.data,
                dataInicioInsc = dto.dataInicioInsc,
                dataFimInsc = dto.dataFimInsc,
                descricao = dto.descricao,
                status = dto.status
            )
        return converter.tocampResponseDTO(repository.save(campeonato))
    }
    fun deletar(id: Long) {
        repository.deleteById(id)
    }
    fun cadastrar(dto: CampDTO): CampResponseDTO {
        return converter.tocampResponseDTO(
            repository.save(converter.toCampeonato(dto)))
    }
}