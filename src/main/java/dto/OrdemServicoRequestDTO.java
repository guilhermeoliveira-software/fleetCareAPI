package dto;

import entity.Mecanico;
import entity.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrdemServicoRequestDTO(

        @NotBlank(message = "A descrição do problema é obrigatória.")
        String descricaoProblema,

        @Positive(message = "O valor orçado deve ser maior que zero.")
        double valorOrcado,

        @NotBlank(message = "O mecânico responsável é obrigatório.")
        String mecanicoResponsavel,

        @NotNull(message = "O mecânico é obrigatório.")
        Mecanico mecanico,

        @NotNull(message = "O veículo é obrigatório.")
        Veiculo veiculo,

        @NotBlank(message = "O status é obrigatório.")
        String status
) {
}