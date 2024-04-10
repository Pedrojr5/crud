package index.style.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import index.style.models.producto;

public interface productoRepository extends JpaRepository<producto, Integer> {

}
