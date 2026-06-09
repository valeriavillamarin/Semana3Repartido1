package uy.utec.semana3repartido1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uy.utec.semana3repartido1.model.Usuario;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsername(String username);
}
