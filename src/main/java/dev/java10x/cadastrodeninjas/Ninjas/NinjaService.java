package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    //Listar todos os ninjas por ID
    public NinjaModel listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = new NinjaMapper().map(ninjaDTO);
        ninja =  ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar um ninja - Tem que ser um metodo VOID
    public void deletarNinjasPorId(Long id) {
//        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
//        ninjaPorId.ifPresent(ninjaModel -> ninjaRepository.delete(ninjaModel));
//        return ninjaPorId.orElse(null);
        ninjaRepository.deleteById(id);
    }

    //Atualizar ninja por ID
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizada) {
      if (ninjaRepository.existsById(id)) {
          ninjaAtualizada.setId(id);
          return ninjaRepository.save(ninjaAtualizada);
      }
      return null;
    }

}
