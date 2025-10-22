package dev.LzGuimaraes.Projetos.Projeto.dto;

import java.time.LocalDate;

public record ProjetoDTO(
    String numeroProjeto,
    String nomeProjeto,
    String gerente,
    String cliente,
    String fase,
    String estado,
    Double porcentagemConclusao,
    LocalDate dataInicio,
    LocalDate dataTerminoAprovada,
    String statusReport
){} 
