package application.controllers;
 
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import application.models.Livro;
import application.repositories.GeneroRepository;
import application.repositories.LivroRepository;
import application.repositories.AutorRepository;
 
@Controller
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroRepository livroRepo;
    @Autowired
    private GeneroRepository generoRepo;
    @Autowired
    private AutorRepository autorRepo;
 
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("livros", livroRepo.findAll());
        return "list.jsp"; 
    }
 
    @RequestMapping("/insert")
    public String formInsert(Model model) {
        model.addAttribute("generos", generoRepo.findAll());
        model.addAttribute("autores", autorRepo.findAll());
        return "insert.jsp";
    }
 
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String saveInsert(@RequestParam("titulo") String titulo, @RequestParam("genero") int generoId, @RequestParam("autor") int autorId) {
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setGenero(generoRepo.findById(generoId).get());
        livro.setAutor(autorRepo.findById(autorId).get());
 
        livroRepo.save(livro);
 
        return "redirect:/livro/list";
    }
 
    @RequestMapping("/update/{id}")
    public String formUpdate(Model model, @PathVariable int id) {
        Optional<Livro> livro = livroRepo.findById(id);
        if(!livro.isPresent())
            return "redirect:/livro/list";
        model.addAttribute("livro", livro.get());
        model.addAttribute("generos", generoRepo.findAll());
        model.addAttribute("autores", autorRepo.findAll());
        return "/livro/update.jsp";
    }
 
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveUpdate(@RequestParam("titulo") String titulo, @RequestParam("id") int id, @RequestParam("genero") int generoId, @RequestParam("autor") int autorId) {
        Optional<Livro> livro = livroRepo.findById(id);
        if(!livro.isPresent())
            return "redirect:/livro/list";
        livro.get().setTitulo(titulo);
        livro.get().setGenero(generoRepo.findById(generoId).get());
        livro.get().setAutor(autorRepo.findById(autorId).get());
 
        livroRepo.save(livro.get());
 
        return "redirect:/livro/list";
    }
 
    @RequestMapping("/delete/{id}")
    public String formDelete(Model model, @PathVariable int id) {
        Optional<Livro> livro = livroRepo.findById(id);
        if(!livro.isPresent())
            return "redirect:/livro/list";
        model.addAttribute("livro", livro.get());
        return "/livro/delete.jsp";
    }
 
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String confirmDelete(@RequestParam("id") int id) {
        livroRepo.deleteById(id);
        return "redirect:/livro/list";
    }
}