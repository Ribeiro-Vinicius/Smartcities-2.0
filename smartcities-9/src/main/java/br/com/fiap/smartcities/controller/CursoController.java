package br.com.fiap.smartcities.controller;

import br.com.fiap.smartcities.model.Curso;
import br.com.fiap.smartcities.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("curso")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;


    @PostMapping("cadastrar")
    public String processarFormulario(@Validated Curso curso, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "curso/form";
        }
        redirectAttributes.addFlashAttribute("msg","Cadastrado!");
        cursoRepository.save(curso);
        return "redirect:listar";
    }

    @GetMapping("listar")
    public String listarCursos(Model model){
        model.addAttribute("curso", cursoRepository.findAll());
        return "curso/lista";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long codigo, Model model){
        model.addAttribute("curso",cursoRepository.findById(codigo));
        return "curso/form";
    }

    @PostMapping("excluir")
    public String remover(Long codigo, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg","Removido!");
        cursoRepository.deleteById(codigo);
        return "redirect:listar";
    }
}
