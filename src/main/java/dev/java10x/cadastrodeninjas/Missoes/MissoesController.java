package dev.java10x.cadastrodeninjas.Missoes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // GET - Mandar uma requisão para mostrar as missoes
    @GetMapping("/listar")
    public String ListarMissao () {
        return "Listando missões";
    }

    // POST - Mandar uma requisão para criar as missoes
    @PostMapping("/criar")
    public String criarMissao() {
        return "Criando Missão";
    }

    // PUT - Mandar uma requisão para altrar as missoes
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "alterando Missão";
    }

    // DELETE - Mandar uma requisão para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Deletando Missão";
    }
}
