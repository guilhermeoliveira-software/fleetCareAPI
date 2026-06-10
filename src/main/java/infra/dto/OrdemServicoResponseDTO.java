package infra.dto;

import infra.entity.Mecanico;
import infra.entity.Veiculo;

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