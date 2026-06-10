package com.techlevs.fleetCareAPI.repository;

import com.techlevs.fleetCareAPI.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

}
