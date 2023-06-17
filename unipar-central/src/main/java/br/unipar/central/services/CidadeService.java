package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.models.Cidade;
import br.unipar.central.repositories.CidadeDAO;
import java.sql.SQLException;
import java.util.List;

public class CidadeService {

    public void validar(Cidade cidade) throws EntNaoInformadaException, CampoNaoInformadoException, TamanhoInvalidoException {
        if (cidade == null) {
            throw new EntNaoInformadaException("Cidade");
        }

        if (cidade.getNome() == null || cidade.getNome().isEmpty() || cidade.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome da Cidade");
        }

        if (cidade.getNome().length() > 60) {
            throw new TamanhoInvalidoException("Nome", "menor que 60 letras.");
        }

        if (cidade.getRa() == null || cidade.getRa().isEmpty() || cidade.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }
    }
    
    
    public List<Cidade> findAll() throws SQLException {

        CidadeDAO cidadeDAO = new CidadeDAO();

        List<Cidade> resultado = cidadeDAO.findAll();
        return resultado;
    }

    public Cidade findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        CidadeDAO cidadeDAO = new CidadeDAO();

        Cidade retorno = cidadeDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar uma cidade com o id informado");
        }

        return retorno;
    }

    public void insert(Cidade cidade) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        validar(cidade);
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.insert(cidade);

    }

    public void update(Cidade cidade) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {
        
        validar(cidade);
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(cidade);
        
    }
    
    public void delete(Cidade cidade) throws SQLException {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(cidade.getId());
    }
}
