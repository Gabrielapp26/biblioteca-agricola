package application.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import application.repositories.LivroRepository;
 
@Controller
@RequestMapping("/livro")
public class LivroController {
@Autowired
private LivroRepository livrosRepo;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("livros", livrosRepo.findAll());
        return "list.jsp";
    }
 
public String listar(){
    return "livro/list.jsp";
}
 
}