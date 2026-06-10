package com.techlevs.fleetCareAPI.dto;

import com.techlevs.fleetCareAPI.entity.Mecanico;
import com.techlevs.fleetCareAPI.entity.Veiculo;

public record OrdemServicoResponseDTO(
        Long id,
        String descricaoProblema,
        double valorOrcado,
        String mecanicoResponsavel,
        Mecanico mecanico,
        Veiculo veiculo,
        String status
) {
}