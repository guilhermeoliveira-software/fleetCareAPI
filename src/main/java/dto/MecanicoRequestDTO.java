package dto;

import jakarta.validation.constraints.*;

public record MecanicoRequestDTO(

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotNull(message = "A idade é obrigatória.")
        @Min(value = 18, message = "A idade mínima é 18 anos.")
        int idade,

        @Size(min = 11, max = 11)
        @NotBlank(message = "O cpf é obrigatório.")
        Integer cpf,

        @Email(message = "Email inválido.")
        @NotBlank(message = "Email é obrigatório.")
        String email
) {
}
