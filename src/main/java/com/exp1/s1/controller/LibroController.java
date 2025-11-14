package com.exp1.s1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import com.exp1.s1.model.Libro;
import com.exp1.s1.service.LibroService;

import java.util.List;

@RestController
@RequestMapping("/libros")
@CrossOrigin(origins = "*")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.getAllLibros();
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Long id) {
        return libroService.getLibroById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado con id: " + id));
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.createLibro(libro);
    }

    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return libroService.updateLibro(id, libro);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
    }

    @GetMapping("/buscar/titulo/{titulo}")
    public List<Libro> buscarPorTitulo(@PathVariable String titulo) {
        return libroService.findByTitulo(titulo);
    }

    @GetMapping("/buscar/autor/{autor}")
    public List<Libro> buscarPorAutor(@PathVariable String autor) {
        return libroService.findByAutor(autor);
    }

    @GetMapping("/buscar/genero/{genero}")
    public List<Libro> buscarPorGenero(@PathVariable String genero) {
        return libroService.findByGenero(genero);
    }

}
