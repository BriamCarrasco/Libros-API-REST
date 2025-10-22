package com.exp1.s1.Service;

import java.util.Optional;
import java.util.List;
import com.exp1.s1.model.Libro;

public interface LibroService {

    List<Libro> getAllLibros();
    Optional<Libro> getLibroById(long id);
    Libro createLibro(Libro libro);
    Libro updateLibro(long id, Libro libro);
    void deleteLibro(long id);
    
}

