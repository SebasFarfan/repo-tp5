package ar.edu.unju.fi.repotp5.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repotp5.entity.Beca;
import ar.edu.unju.fi.repotp5.repository.IBecaRepository;
import ar.edu.unju.fi.repotp5.services.IBecaService;

@Service(value = "becaServiceMysql")
public class BecaServiceImpMysql implements IBecaService {

    @Autowired
    private IBecaRepository becaRepository;

    @Override
    public void guardarBeca(Beca beca) {
        this.becaRepository.save(beca);        
    }

    @Override
    public void eliminarBeca(Long codigo) {
        this.becaRepository.deleteById(codigo);        
    }

    @Override
    public Beca getBeca(Long codigo) {        
        return this.becaRepository.getReferenceById(codigo);
    }

    @Override
    public List<Beca> getbecas() {        
        return this.becaRepository.findAll();
    }
    
}
