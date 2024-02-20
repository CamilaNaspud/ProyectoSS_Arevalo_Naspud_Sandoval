package com.app.libros.models.repository;


import org.springframework.data.repository.CrudRepository;

import com.app.libros.models.entity.Libro;



public interface LibroRepository extends CrudRepository<Libro,Long>{

}
