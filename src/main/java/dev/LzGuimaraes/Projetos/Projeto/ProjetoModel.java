package dev.LzGuimaraes.Projetos.Projeto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "projetos_tb")
@Entity
@Getter
@Setter
public class ProjetoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_projeto", unique = true, nullable = false)
    private String numeroProjeto;

    @Column(name = "nome_projeto", nullable = false)
    private String nomeProjeto;

    private String gerente;
    private String cliente;
    private String fase;
    private String estado;

    @Column(name = "porcentagem_conclusao")
    private BigDecimal porcentagemConclusao;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_termino_aprovada")
    private LocalDate dataTerminoAprovada;

    @Column(name = "status_report", columnDefinition = "TEXT")
    private String statusReport;

}
