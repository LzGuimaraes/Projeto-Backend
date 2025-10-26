package dev.LzGuimaraes.Projetos.Projeto;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.LzGuimaraes.Projetos.Projeto.dto.ProjetoDTO;
import dev.LzGuimaraes.Projetos.Projeto.dto.StatusReportDTO;

@RestController
@RequestMapping("/projetos")
@CrossOrigin(origins = {"https://projeto-v2-pi.vercel.app/"})
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

    @GetMapping("/buscar/{valor}")
    public List<ProjetoDTO> buscar(@PathVariable String valor) {
    return projetoService.buscarPorNumeroOuCliente(valor);
    }

    @PatchMapping("/{numeroProjeto}/status-report")
    public ProjetoDTO atualizarStatusReport(
            @PathVariable String numeroProjeto,
            @RequestBody StatusReportDTO statusDTO) {
        return projetoService.atualizarStatusReport(numeroProjeto, statusDTO.statusReport());
    }
}
