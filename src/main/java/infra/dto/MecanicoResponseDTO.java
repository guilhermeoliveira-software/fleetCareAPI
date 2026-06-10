package infra.dto;

public record MecanicoResponseDTO(
        Long id,
        String nome,
        int idade,
        Integer cpf,
        String email
) {
}