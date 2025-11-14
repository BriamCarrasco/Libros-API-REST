package com.exp1.s1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.exp1.s1.model.Libro;
import com.exp1.s1.repository.LibroRepository;
import java.util.Optional;


@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }


    @Override
    public Optional<Libro> getLibroById(long id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro createLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro updateLibro(long id, Libro libro) {
        libro.setIdLibro(id);
        return libroRepository.save(libro);
    }

    @Override
    public void deleteLibro(long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public List<Libro> findByTitulo(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Libro> findByAutor(String autor) {
        return libroRepository.findByAutorContainingIgnoreCase(autor);
    }

    @Override
    public List<Libro> findByGenero(String genero) {
        return libroRepository.findByGeneroContainingIgnoreCase(genero);
    }

}
