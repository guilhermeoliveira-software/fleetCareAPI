package infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository <entity.Usuario, Long> {
    Optional<entity.Usuario> findByEmail(String email);
}
