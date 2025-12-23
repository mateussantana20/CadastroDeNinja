package dev.java10x.cadastrodeninjas.Ninjas;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas () {
        return "Boas vindas";
    }

    // Adicionar ninja - CREATE
    @PostMapping("/criar")
    public NinjaModel criarNinja (@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas - READ
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas () {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID  - READ
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId (@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    // Alterar dados dos ninjas - UPDATE
    @PutMapping("/alterarID")
    public String alterarNinjasPorId () {
        return "Alterar ninja por ID";
    }

    // Deletar Ninja  - DELETE
    @DeleteMapping("/deletarID")
    public String deletarNinjasPorId () {
        return "Deletar ninja por ID";
    }

}
