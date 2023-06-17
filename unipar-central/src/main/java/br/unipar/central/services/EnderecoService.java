package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.models.Endereco;
import br.unipar.central.models.Endereco;
import br.unipar.central.repositories.EnderecoDAO;
import java.sql.SQLException;
import java.util.List;

public class EnderecoService {

    public void validar(Endereco endereco) throws EntNaoInformadaException, CampoNaoInformadoException, TamanhoInvalidoException {
        if (endereco == null) {
            throw new EntNaoInformadaException("Cidade");
        }

        CidadeService c = new CidadeService();

        c.validar(endereco.getCidade());

        if (endereco.getBairro() == null || endereco.getBairro().isEmpty() || endereco.getBairro().isBlank()) {
            throw new CampoNaoInformadoException("Bairro");
        }

        if (endereco.getBairro().length() > 40) {
            throw new TamanhoInvalidoException("Bairro", "menor que 40 dígitos");
        }

        if (endereco.getCep() == null || endereco.getCep().isEmpty() || endereco.getCep().isBlank()) {
            throw new CampoNaoInformadoException("CEP");
        }

        if (!(endereco.getCep().length() == 8)) {
            throw new TamanhoInvalidoException("CEP", "igual a 8 dígitos");
        }

        if (endereco.getComplemento() == null || endereco.getComplemento().isEmpty() || endereco.getComplemento().isBlank()) {
            throw new CampoNaoInformadoException("Complemento");
        }

        if (endereco.getComplemento().length() > 40) {
            throw new TamanhoInvalidoException("Comeplento", "menor que 40 dígitos");
        }

        if (endereco.getNumero() == null || endereco.getNumero().isEmpty() || endereco.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("Número");
        }

        if (endereco.getRua() == null || endereco.getRua().isEmpty() || endereco.getRua().isBlank()) {
            throw new CampoNaoInformadoException("Nome da Cidade");
        }

        if (endereco.getRua().length() > 40) {
            throw new TamanhoInvalidoException("Rua", "menor que 40 dígitos");
        }
    }

    
    public List<Endereco> findAll() throws SQLException {

        EnderecoDAO enderecoDAO = new EnderecoDAO();

        List<Endereco> resultado = enderecoDAO.findAll();
        return resultado;
    }

    public Endereco findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        EnderecoDAO enderecoDAO = new EnderecoDAO();

        Endereco retorno = enderecoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um endereço com o id informado");
        }

        return retorno;
    }

    public void insert(Endereco endereco) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        validar(endereco);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.insert(endereco);

    }

    public void update(Endereco endereco) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {
        
        validar(endereco);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(endereco);
        
    }
    
    public void delete(Endereco endereco) throws SQLException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.delete(endereco.getId());
    }
    
}
