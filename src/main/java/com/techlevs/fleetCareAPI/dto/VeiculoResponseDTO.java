package com.techlevs.fleetCareAPI.dto;

public record VeiculoResponseDTO(

        Long id,
        String placa,
        String modelo,
        Integer ano,
        double quilometragemAtual
) {
}