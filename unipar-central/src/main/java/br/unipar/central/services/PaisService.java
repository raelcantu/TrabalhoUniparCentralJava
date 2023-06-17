package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.models.Pais;
import br.unipar.central.repositories.PaisDAO;
import java.sql.SQLException;
import java.util.List;

public class PaisService {

    public void validar(Pais pais) throws EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        if (pais == null) {
            throw new EntNaoInformadaException("País");
        }

        if (pais.getNome() == null || pais.getNome().isEmpty() || pais.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome do país");
        }

        if (pais.getSigla() == null || pais.getSigla().isEmpty() || pais.getSigla().isBlank()) {
            throw new CampoNaoInformadoException("Sigla");
        }

        if (!(pais.getSigla().length() == 2)) {
            throw new TamanhoInvalidoException("Sigla", "igual a 2 letras.");
        }

        if (pais.getNome().length() > 60) {
            throw new TamanhoInvalidoException("Nome", "menor que 60 letras.");
        }

        if (pais.getRa() == null || pais.getRa().isEmpty() || pais.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

    }

    public List<Pais> findAll() throws SQLException {

        PaisDAO paisDAO = new PaisDAO();

        List<Pais> resultado = paisDAO.findAll();
        return resultado;
    }

    public Pais findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        PaisDAO paisDAO = new PaisDAO();

        Pais retorno = paisDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id informado");
        }

        return retorno;
    }

    public void insert(Pais pais) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        validar(pais);
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.insert(pais);

    }

    public void update(Pais pais) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {
        
        validar(pais);
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.update(pais);
        
    }
    
    public void delete(Pais pais) throws SQLException {
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.delete(pais.getId());
    }

}
