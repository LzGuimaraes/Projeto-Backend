package dev.LzGuimaraes.Projetos.Projeto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import dev.LzGuimaraes.Projetos.Projeto.dto.ProjetoDTO;

@Component
public class ProjetoMapper {

    public ProjetoDTO toResponse(ProjetoModel entity) {
        return new ProjetoDTO(
            entity.getNumeroProjeto(),
            entity.getNomeProjeto(),
            entity.getGerente(),
            entity.getCliente(),
            entity.getEstado(),
            entity.getFase(),
            entity.getPorcentagemConclusao() != null ? entity.getPorcentagemConclusao().doubleValue() : null,
            entity.getDataInicio(),
            entity.getDataTerminoAprovada(),
            entity.getStatusReport()
        );
    }

    public ProjetoModel toEntity(ProjetoDTO dto) {
        ProjetoModel projeto = new ProjetoModel();
        projeto.setNumeroProjeto(dto.numeroProjeto());
        projeto.setNomeProjeto(dto.nomeProjeto());
        projeto.setGerente(dto.gerente());
        projeto.setCliente(dto.cliente());
        projeto.setFase(dto.fase());
        projeto.setPorcentagemConclusao(dto.porcentagemConclusao() != null ? BigDecimal.valueOf(dto.porcentagemConclusao()) : null);
        projeto.setDataInicio(dto.dataInicio());
        projeto.setDataTerminoAprovada(dto.dataTerminoAprovada());
        projeto.setStatusReport(dto.statusReport());
        return projeto;
    }
}
