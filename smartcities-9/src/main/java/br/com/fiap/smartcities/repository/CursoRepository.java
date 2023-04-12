package br.com.fiap.smartcities.repository;

import br.com.fiap.smartcities.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNome(String nome);
    List<Curso> findByPreco(double preco);

}
