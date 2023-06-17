package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.models.Pessoa;
import br.unipar.central.repositories.PessoaDAO;
import java.sql.SQLException;
import java.util.List;

public class PessoaService {

    public void validar(Pessoa pessoa) throws EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        if (pessoa == null) {
            throw new EntNaoInformadaException("Pessoa");
        }

        if (pessoa.getEmail() == null || pessoa.getEmail().isEmpty() || pessoa.getEmail().isBlank()) {
            throw new CampoNaoInformadoException("Email");
        }

        if (pessoa.getRa() == null || pessoa.getRa().isEmpty() || pessoa.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (!(pessoa.getRa().length() == 8)) {
            throw new TamanhoInvalidoException("RA", "igual a 8 Números.");
        }

        if (pessoa.getEmail().length() > 60) {
            throw new TamanhoInvalidoException("Email", "menor que 60 letras.");
        }

    }
    
    
    public List<Pessoa> findAll() throws SQLException {

        PessoaDAO pessoaDAO = new PessoaDAO();

        List<Pessoa> resultado = pessoaDAO.findAll();
        return resultado;
    }

    public Pessoa findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        PessoaDAO pessoaDAO = new PessoaDAO();

        Pessoa retorno = pessoaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar uma pessoa com o id informado");
        }

        return retorno;
    }

    public void insert(Pessoa pessoa) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.insert(pessoa);

    }

    public void update(Pessoa pessoa) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {
        
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.update(pessoa);
        
    }
    
    public void delete(Pessoa pessoa) throws SQLException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.delete(pessoa.getId());
    }
    
}
