package com.app.libros.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.libros.models.entity.Libro;
import com.app.libros.models.services.LibroService;

@RestController
public class LibroController {
    
    @Autowired
    private LibroService service;
    
    @GetMapping
    public ResponseEntity<?> listar() {
        HttpHeaders headers = createHeaders();
        return ResponseEntity.ok().headers(headers).body(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<Libro> o = service.findById(id);
        if (!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = createHeaders();
        return ResponseEntity.ok().headers(headers).body(o.get());
    }
    
    @PostMapping
    @Secured("ROLE_ADMIN") // Solo los usuarios con el rol "ADMIN" pueden acceder a este método
    public ResponseEntity<?> crear(@RequestBody Libro libro) {
        Libro libroDb = service.save(libro);
        HttpHeaders headers = createHeaders();
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(libroDb);
    }
    
    // Método para agregar cabeceras
    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value");
        return headers;
    }
}
