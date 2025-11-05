package com.exp1.s1.repository;

import com.exp1.s1.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    boolean existsByTitulo(String titulo);

    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByAutorContainingIgnoreCase(String autor);
    List<Libro> findByGeneroContainingIgnoreCase(String genero);

    
}
