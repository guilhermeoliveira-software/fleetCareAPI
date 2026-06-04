package com.techlevs.fleetCareAPI.controller;

import com.techlevs.fleetCareAPI.business.OrdemServicoService;
import com.techlevs.fleetCareAPI.dto.VeiculoRequestDTO;
import com.techlevs.fleetCareAPI.entity.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/veiculo")
public class VeiculoController {

    private final OrdemServicoService ordemServicoService;

    public VeiculoController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrarVeiculo(@RequestBody VeiculoRequestDTO dto) {
        return ordemServicoService.cadastrarVeiculo(dto);
    }

}
