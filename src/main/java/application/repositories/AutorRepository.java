package application.repositories;

import org.springframework.data.repository.CrudRepository;

import application.models.Autor;


public interface AutorRepository extends CrudRepository<Autor, Integer> {
    
}
