package com.techlevs.fleetCareAPI.dto;

public record ErrorResponseDTO(

        int status,
        String mensagem
) {
}
