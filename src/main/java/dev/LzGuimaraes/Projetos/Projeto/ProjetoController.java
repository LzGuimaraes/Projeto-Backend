package dev.LzGuimaraes.Projetos.Projeto;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.LzGuimaraes.Projetos.Projeto.dto.ProjetoDTO;

@RestController
@RequestMapping("/projetos")
@CrossOrigin(origins = {"http://localhost:5173", "https://projetos-alpha-bay.vercel.app/"})
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping("/all")
    public List<ProjetoDTO> getAllProjetos() {
        return projetoService.getAllProjetos();
    }

    @GetMapping("all/{numeroProjeto}")
    public ProjetoDTO getByNumeroProjeto(@PathVariable String numeroProjeto) {
        return projetoService.getByNumeroProjeto(numeroProjeto);
    }
}
