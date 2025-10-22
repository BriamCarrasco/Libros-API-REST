package com.exp1.s1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exp1.s1.model.Libro;
import com.exp1.s1.repository.LibroRepository;
import java.util.Optional;


@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;


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

}
