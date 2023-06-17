package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.models.PessoaFisica;
import br.unipar.central.repositories.PessoaFisicaDAO;
import java.sql.SQLException;
import java.util.List;

public class PessoaFisicaService {

    public void validar(PessoaFisica pessoaFisica) throws EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        PessoaService p = new PessoaService();

        p.validar(pessoaFisica.getPessoa());

        if (pessoaFisica == null) {
            throw new EntNaoInformadaException("Pessoa Física");
        }

        if (pessoaFisica.getNome() == null || pessoaFisica.getNome().isEmpty() || pessoaFisica.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome da pessoa");
        }

        if (pessoaFisica.getCpf() == null || pessoaFisica.getCpf().isEmpty() || pessoaFisica.getCpf().isBlank()) {
            throw new CampoNaoInformadoException("cpf");
        }

        if (!(pessoaFisica.getCpf().length() == 11)) {
            throw new TamanhoInvalidoException("Nome", "igual a 11 números.");
        }
        
        if(!(pessoaFisica.getRg().length() == 7)){
            throw new TamanhoInvalidoException("Rg", "igual a 7 números.");
        }

        if (pessoaFisica.getNome().length() > 60) {
            throw new TamanhoInvalidoException("Nome", "menor que 60 letras.");
        }

        if (pessoaFisica.getRa() == null || pessoaFisica.getRa().isEmpty() || pessoaFisica.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (!(pessoaFisica.getRa().length() == 8)) {
            throw new TamanhoInvalidoException("RA", "igual a 8 Números.");
        }
    }

    public List<PessoaFisica> findAll() throws SQLException {

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();

        List<PessoaFisica> resultado = pessoaFisicaDAO.findAll();
        return resultado;
    }

    public PessoaFisica findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();

        PessoaFisica retorno = pessoaFisicaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id informado");
        }

        return retorno;
    }

    public void insert(PessoaFisica pessoaFisica) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.insert(pessoaFisica);

    }

    public void update(PessoaFisica pessoaFisica) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.update(pessoaFisica);

    }

    public void delete(PessoaFisica pessoaFisica) throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.delete(pessoaFisica.getId());
    }

}
