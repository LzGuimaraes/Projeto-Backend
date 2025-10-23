package dev.LzGuimaraes.Projetos.Projeto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long> {
    Optional<ProjetoModel> findByNumeroProjeto(String numeroProjeto);
    List<ProjetoModel> findByClienteContainingIgnoreCase(String cliente);
    List<ProjetoModel> findByNumeroProjetoOrClienteContainingIgnoreCase(String numeroProjeto, String cliente);
}
