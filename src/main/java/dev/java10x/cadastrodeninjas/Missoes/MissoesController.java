package dev.java10x.cadastrodeninjas.Missoes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET - Mandar uma requisão para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes () {
        return missoesService.listarMissoes();
    }

    // POST - Mandar uma requisão para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        return missoesService.criarMissao(missao);
    }

    // PUT - Mandar uma requisão para altrar as missoes
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "alterando Missão";
    }

    // DELETE - Mandar uma requisão para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }
}
