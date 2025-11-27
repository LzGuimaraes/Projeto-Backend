package dev.LzGuimaraes.Projetos.Projeto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long> {

    Optional<ProjetoModel> findByNumeroProjeto(String numeroProjeto);
    @Query("SELECT p FROM ProjetoModel p WHERE " +
           "(:busca IS NULL OR :busca = '' OR LOWER(p.numeroProjeto) LIKE LOWER(CONCAT('%', :busca, '%')) OR LOWER(p.cliente) LIKE LOWER(CONCAT('%', :busca, '%'))) " +
           "AND (:estado IS NULL OR :estado = '' OR LOWER(p.estado) = LOWER(:estado)) " +
           "AND (:fase IS NULL OR :fase = '' OR LOWER(p.fase) = LOWER(:fase)) " +
           "AND (:gerente IS NULL OR :gerente = '' OR LOWER(p.gerente) = LOWER(:gerente))")
    List<ProjetoModel> filtrarProjetos(
            @Param("busca") String busca,
            @Param("estado") String estado,
            @Param("fase") String fase,
            @Param("gerente") String gerente);
}