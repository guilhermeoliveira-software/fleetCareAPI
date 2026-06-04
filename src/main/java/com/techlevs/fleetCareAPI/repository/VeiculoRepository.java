package com.techlevs.fleetCareAPI.repository;

import com.techlevs.fleetCareAPI.entity.Veiculo;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {


    boolean existsByPlaca(@NotBlank(message = "A placa é obrigatória.") String placa);
}
