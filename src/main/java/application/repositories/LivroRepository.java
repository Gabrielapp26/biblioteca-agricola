package application.repositories;

import org.springframework.data.repository.CrudRepository;
import application.models.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer>{

}