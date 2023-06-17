 package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.models.Banco;
import br.unipar.central.repositories.BancoDAO;
import java.sql.SQLException;
import java.util.List;


public class BancoService {

    public void validar(Banco banco) throws EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        if (banco == null) {
            throw new EntNaoInformadaException("Banco");
        }

        if (banco.getNome()== null || banco.getNome().isEmpty() || banco.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome do banco");
        }

        if (banco.getRa() == null || banco.getRa().isEmpty() || banco.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (!(banco.getRa().length() == 8)) {
            throw new TamanhoInvalidoException("RA", "igual a 8 Números.");
        }

        if (banco.getNome().length() > 60) {
            throw new TamanhoInvalidoException("Nome do banco", "menor que 60 letras.");
        }

    }
    
    
    public List<Banco> findAll() throws SQLException {

        BancoDAO bancoDAO = new BancoDAO();

        List<Banco> resultado = bancoDAO.findAll();
        return resultado;
    }

    public Banco findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        BancoDAO bancoDAO = new BancoDAO();

        Banco retorno = bancoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um banco com o id informado");
        }

        return retorno;
    }

    public void insert(Banco banco) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.insert(banco);

    }

    public void update(Banco banco) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {
        
        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.update(banco);
        
    }
    
    public void delete(Banco banco) throws SQLException {
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.delete(banco.getId());
    }
    
}
