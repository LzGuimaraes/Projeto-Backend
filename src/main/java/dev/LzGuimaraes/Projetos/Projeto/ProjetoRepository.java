package dev.LzGuimaraes.Projetos.Projeto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long> {
    Optional<ProjetoModel> findByNumeroProjeto(String numeroProjeto);
}
