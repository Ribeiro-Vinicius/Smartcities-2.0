package br.com.fiap.smartcities.controller;

import br.com.fiap.smartcities.model.Aluno;
import br.com.fiap.smartcities.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoResources {
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    @GetMapping("{ra}")
    public Aluno buscar(@PathVariable Long ra){
        return alunoRepository.findById(ra).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno){
        return alunoRepository.save(aluno);
    }

    @PutMapping("{ra}")
    public Aluno atualizar(@RequestBody Aluno aluno, @PathVariable Long ra){
        aluno.setRa(ra);
        return alunoRepository.save(aluno);
    }

    @DeleteMapping
    public void remover(@PathVariable Long ra){
        alunoRepository.deleteById(ra);
    }
}

