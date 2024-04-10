package index.style.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import index.style.models.categoria;

public interface categoriaRepository extends JpaRepository<categoria, Integer> {

    Optional<categoria> findByNomcat(String nomcat);

}
