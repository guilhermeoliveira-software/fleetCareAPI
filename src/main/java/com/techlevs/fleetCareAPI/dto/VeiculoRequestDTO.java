package com.techlevs.fleetCareAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record VeiculoRequestDTO(

        @NotBlank(message = "A placa é obrigatória.")
        String placa,

        @NotBlank(message = "O modelo é obrigatório.")
        String modelo,

        @NotBlank(message = "O ano é obrigatório.")
        Integer ano,

        @Positive(message = "A quilometragem deve ser maior que zero.")
        double quilometragemAtual

) {
}