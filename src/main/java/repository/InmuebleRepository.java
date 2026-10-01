package repository;


import com.exemplo.demo.entity.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Sobreescribe o comportamento LAZY de 'pedidos' cargándoos nun único JOIN
    @EntityGraph(attributePaths = {"pedidos"})
    List<Usuario> findAll();

    // Tamén aplicable a métodos derivados con filtros
    @EntityGraph(attributePaths = {"pedidos"})
    Optional<Usuario> findByEmail(String email);
}
