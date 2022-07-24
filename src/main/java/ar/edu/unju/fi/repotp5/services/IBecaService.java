package ar.edu.unju.fi.repotp5.services;

import java.util.List;

import ar.edu.unju.fi.repotp5.entity.Beca;

public interface IBecaService {
    public void guardarBeca(Beca beca);
    public void eliminarBeca(Long codigo);
    public Beca getBeca(Long codigo);
    public List<Beca> getbecas();
}
