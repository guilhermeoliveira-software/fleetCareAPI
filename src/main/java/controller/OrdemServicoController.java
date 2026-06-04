package controller;

import business.OrdemServicoService;
import business.enums.StatusOrdem;
import entity.OrdemServico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/ordem-servico")
public class OrdemServicoController {

    private final OrdemServicoService ordemServicoService;

    public OrdemServicoController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    @PatchMapping("/{id}")
    public OrdemServico atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusOrdem novoStatus,
            @RequestParam(required = false) Long idMecanico) {

        return ordemServicoService.atualizarStatus(
                id,
                novoStatus,
                idMecanico
        );
    }
}
