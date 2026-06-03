package dto;

import entity.Mecanico;
import entity.Veiculo;

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