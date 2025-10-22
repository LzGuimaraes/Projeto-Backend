package dev.LzGuimaraes.Projetos.Projeto;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.LzGuimaraes.Projetos.Projeto.dto.ProjetoDTO;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final ProjetoMapper projetoMapper;

    public ProjetoService(ProjetoRepository projetoRepository, ProjetoMapper projetoMapper) {
        this.projetoRepository = projetoRepository;
        this.projetoMapper = projetoMapper;
    }

    public List<ProjetoDTO> getAllProjetos() {
        return projetoRepository.findAll()
            .stream()
            .map(projetoMapper::toResponse)
            .toList();
    }

    public ProjetoDTO getByNumeroProjeto(String numeroProjeto) {
        return projetoRepository.findByNumeroProjeto(numeroProjeto)
            .map(projetoMapper::toResponse)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado: " + numeroProjeto));
    }
}
