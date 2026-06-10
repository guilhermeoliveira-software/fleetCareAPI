package infra.repository;

import infra.entity.Veiculo;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {


    boolean existsByPlaca(@NotBlank(message = "A placa é obrigatória.") String placa);
}
