package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.models.Telefone;
import br.unipar.central.models.Telefone;
import br.unipar.central.repositories.TelefoneDAO;
import java.sql.SQLException;
import java.util.List;

public class TelefoneService {


    public void validar(Telefone telefone) throws EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

//    FALTA VALIDAR AGENCIA        
        
        if (telefone == null) {
            throw new EntNaoInformadaException("Pessoa");
        }

        if (telefone.getNumero() == null || telefone.getNumero().isEmpty() || telefone.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("Número de telefone");
        }

        if (telefone.getRa() == null || telefone.getRa().isEmpty() || telefone.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (!(telefone.getRa().length() == 8)) {
            throw new TamanhoInvalidoException("RA", "igual a 8 Números.");
        }

        if (telefone.getNumero().length() > 13) {
            throw new TamanhoInvalidoException("Número de telefone", "menor que 13 números.");
        }

        PessoaService ps = new PessoaService();
        ps.validar(telefone.getPessoa());

    }

        public List<Telefone> findAll() throws SQLException {

        TelefoneDAO telefoneDAO = new TelefoneDAO();

        List<Telefone> resultado = telefoneDAO.findAll();
        return resultado;
    }

    public Telefone findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        TelefoneDAO telefoneDAO = new TelefoneDAO();

        Telefone retorno = telefoneDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um telefone com o id informado");
        }

        return retorno;
    }

    public void insert(Telefone telefone) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.insert(telefone);

    }

    public void update(Telefone telefone) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {
        
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.update(telefone);
        
    }
    
    public void delete(Telefone telefone) throws SQLException {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.delete(telefone.getId());
    }
    
}
