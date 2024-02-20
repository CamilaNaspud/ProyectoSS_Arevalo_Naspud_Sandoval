package com.app.libros.models.services;

import java.util.Optional;

import com.app.libros.models.entity.Libro;

public interface LibroService {
	
	public Iterable<Libro> findAll();
	
	public Optional<Libro> findById(Long id);
	
	public Libro save(Libro libro);
	
	public void deleteById(Long id);

}
