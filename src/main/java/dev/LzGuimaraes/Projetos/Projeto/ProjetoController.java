package dev.LzGuimaraes.Projetos.Projeto;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.LzGuimaraes.Projetos.Projeto.dto.ProjetoDTO;
import dev.LzGuimaraes.Projetos.Projeto.dto.StatusReportDTO;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping("/all")
    public List<ProjetoDTO> getAllProjetos() {
        return projetoService.getAllProjetos();
    }

    @GetMapping("/all/{numeroProjeto}")
    public ProjetoDTO getByNumeroProjeto(@PathVariable String numeroProjeto) {
        return projetoService.getByNumeroProjeto(numeroProjeto);
    }

    @GetMapping("/filtrar")
    public List<ProjetoDTO> filtrarProjetos(
            @RequestParam(required = false) String busca,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String fase,
            @RequestParam(required = false) String gerente) {
        
        return projetoService.filtrar(busca, estado, fase, gerente);
    }

    @PatchMapping("/{numeroProjeto}/status-report")
    public ProjetoDTO atualizarStatusReport(
            @PathVariable String numeroProjeto,
            @RequestBody StatusReportDTO statusDTO) {
        return projetoService.atualizarStatusReport(numeroProjeto, statusDTO.statusReport());
    }
}