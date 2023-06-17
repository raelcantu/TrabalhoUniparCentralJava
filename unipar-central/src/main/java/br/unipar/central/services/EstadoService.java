package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.models.Estado;
import br.unipar.central.repositories.EstadoDAO;
import java.sql.SQLException;
import java.util.List;

public class EstadoService {

    public void validar(Estado estado) throws CampoNaoInformadoException, TamanhoInvalidoException, EntNaoInformadaException {

        PaisService p = new PaisService();

        p.validar(estado.getPais());

        if (estado == null) {
            throw new EntNaoInformadaException("Estado");
        }

        if (estado.getNome() == null || estado.getNome().isEmpty() || estado.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome do estado");
        }

        if (estado.getSigla() == null || estado.getSigla().isEmpty() || estado.getSigla().isBlank()) {
            throw new CampoNaoInformadoException("Sigla");
        }

        if (!(estado.getSigla().length() == 2)) {
            throw new TamanhoInvalidoException("Sigla", "igual a 2 letras.");
        }

        if (estado.getNome().length() > 30) {
            throw new TamanhoInvalidoException("Nome", "menor que 30 letras.");
        }

        if (estado.getRa() == null || estado.getRa().isEmpty() || estado.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

    }

    public List<Estado> findAll() throws SQLException {

        EstadoDAO estadoDAO = new EstadoDAO();

        List<Estado> resultado = estadoDAO.findAll();
        return resultado;
    }

    public Estado findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        EstadoDAO estadoDAO = new EstadoDAO();

        Estado retorno = estadoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um estado com o id informado");
        }

        return retorno;
    }

    public void insert(Estado estado) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        PaisService pais = new PaisService();  
        pais.validar(estado.getPais());
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.insert(estado);

    }

    public void update(Estado estado) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        PaisService pais = new PaisService();  
        pais.validar(estado.getPais());
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.update(estado);

    }

    public void delete(Estado estado) throws SQLException {
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.delete(estado.getId());
    }

}
