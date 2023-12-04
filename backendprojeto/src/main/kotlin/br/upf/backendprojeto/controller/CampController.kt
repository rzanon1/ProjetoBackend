package br.upf.backendprojeto.controller

import br.upf.backendprojeto.DTO.CampDTO
import br.upf.backendprojeto.DTO.CampResponseDTO
import br.upf.backendprojeto.service.CampService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault


@RestController
@RequestMapping("/campeonato")
class CampController (val service: CampService) {

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: CampDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CampResponseDTO> {
        val campResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/campeonato/${campResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(campResponse)
    }
    @GetMapping

    fun listar(
        @RequestParam(required = false) nomeCampeonato: String?,
        @PageableDefault(size = 10) paginacao: Pageable)
            : Page<CampResponseDTO> {
        return service.listar(nomeCampeonato, paginacao)
    }

    @GetMapping("/{id}")

    fun buscarPorId(@PathVariable id: Long): CampResponseDTO {
        return service.buscarPorId(id)
    }
    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: CampDTO
    ): CampResponseDTO {
        return service.atualizar(id, dto)
    }
    @DeleteMapping("/{id}")
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }


}

