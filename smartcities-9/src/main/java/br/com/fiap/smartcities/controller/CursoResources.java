package br.com.fiap.smartcities.controller;

import br.com.fiap.smartcities.model.Curso;
import br.com.fiap.smartcities.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curso")
public class CursoResources {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @GetMapping("{codigo}")
    public Curso buscar(@PathVariable Long codigo) {
        return cursoRepository.findById(codigo).get();
    }


    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Curso cadastrar(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @PutMapping("{codigo}")
    public Curso atualizar(@RequestBody Curso curso, @PathVariable Long codigo) {
        curso.setCodigo(codigo);
        return cursoRepository.save(curso);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable Long codigo){
        cursoRepository.deleteById(codigo);
    }


    }




