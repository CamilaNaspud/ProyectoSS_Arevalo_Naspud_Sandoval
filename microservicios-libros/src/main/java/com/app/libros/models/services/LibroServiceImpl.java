package com.app.libros.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;

import com.app.libros.models.repository.LibroRepository;
import com.app.libros.models.entity.Libro;

@Service
public class LibroServiceImpl implements LibroService {
    
    @Autowired
    private LibroRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public Iterable<Libro> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Libro> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Secured("ROLE_ADMIN") // Solo los usuarios con el rol "ADMIN" pueden acceder a este método
    public Libro save(Libro libro) {
        return repository.save(libro);
    }

    @Override
    @Secured("ROLE_ADMIN") // Solo los usuarios con el rol "ADMIN" pueden acceder a este método
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // Método para agregar cabeceras
    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value");
        return headers;
    }
}
