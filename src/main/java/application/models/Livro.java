package application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livros")
public class Livro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    
    public int getId() {
        return id;
    }public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setNome(String nome) {
    }
}