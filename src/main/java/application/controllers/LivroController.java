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
import application.repositories.LivroRepository;
 
@Controller
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroRepository livroRepo;
 
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("livros", livroRepo.findAll());
        return "list.jsp"; 
    }
    @RequestMapping("/insert")
    public String formInsert() {
        return "insert.jsp";
    }
 
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String saveInsert(@RequestParam("nome") String nome) {
        Livro livro = new Livro();
        livro.setNome(nome);

        livroRepo.save(livro);
 
        return "redirect:/livro/list";
    }
    @RequestMapping("/update/{id}")
    public String formUpdate(Model model, @PathVariable int id) {
        Optional<Livro> livro = livroRepo.findById(id);
        if(!livro.isPresent())
            return "redirect:/livro/list";
        model.addAttribute("livro", livro.get());
        return "/livro/update.jsp";
    }
 
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveUpdate(@RequestParam("nome") String nome, @RequestParam("id") int id) {
        Optional<Livro> livro = livroRepo.findById(id);
        if(!livro.isPresent())
            return "redirect:/livro/list";
        livro.get().setNome(nome);
 
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