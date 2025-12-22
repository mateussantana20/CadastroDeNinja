package dev.java10x.cadastrodeninjas.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasvindas () {
        return "Boas vindas";
    }

    // Adicionar ninja - CREATE
    @PostMapping("/criar")
    public String criarNinja () {
        return "Ninja Criada";
    }

    // Mostrar todos os ninjas - READ
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas () {
        return "Mostrando todos os ninjas";
    }

    // Mostrar ninja por ID  - READ
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId () {
        return "Mostrar ninja por ID";
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
