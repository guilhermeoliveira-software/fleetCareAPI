package dto;

public record VeiculoResponseDTO(

        Long id,
        String placa,
        String modelo,
        Integer ano,
        double quilometragemAtual
) {
}