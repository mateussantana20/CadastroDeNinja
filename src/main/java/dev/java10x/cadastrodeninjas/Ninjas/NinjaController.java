package dev.java10x.cadastrodeninjas.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja (@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criada com sucesso: " + novoNinja.getNome());
    }

    // Mostrar todos os ninjas - READ
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas () {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por ID  - READ
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId (@PathVariable Long id) {
       NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
       if(ninja != null) {
           return ResponseEntity.ok(ninja);
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Não existe ninja com esse ID");
       }
    }

    // Alterar dados dos ninjas - UPDATE
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarNinja (@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado!!");
        }
    }

    // Deletar Ninja  - DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjasPorId (@PathVariable Long id) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjasPorId(id);
            return ResponseEntity.ok("Ninja Deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado!!");
        }
    }
}
