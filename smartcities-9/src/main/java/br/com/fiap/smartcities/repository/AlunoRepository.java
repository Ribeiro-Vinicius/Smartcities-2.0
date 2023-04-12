package br.com.fiap.smartcities.repository;

import br.com.fiap.smartcities.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
