package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.models.Conta;
import br.unipar.central.models.Conta;
import br.unipar.central.repositories.ContaDAO;
import java.sql.SQLException;
import java.util.List;

public class ContaService {

    public void validar(Conta conta) throws EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        AgenciaService bs = new AgenciaService();
        bs.validar(conta.getAgencia());
        
        PessoaService ps = new PessoaService();
        ps.validar(conta.getPessoa());
        
        if (conta == null) {
            throw new EntNaoInformadaException("Conta");
        }

        if (conta.getDigito()== null || conta.getDigito().isEmpty() || conta.getDigito().isBlank()) {
            throw new CampoNaoInformadoException("Dígito");
        }

        if (conta.getRa() == null || conta.getRa().isEmpty() || conta.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (!(conta.getRa().length() == 8)) {
            throw new TamanhoInvalidoException("RA", "igual a 8 Números.");
        }

    }

        public List<Conta> findAll() throws SQLException {

        ContaDAO contaDAO = new ContaDAO();

        List<Conta> resultado = contaDAO.findAll();
        return resultado;
    }

    public Conta findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        ContaDAO contaDAO = new ContaDAO();

        Conta retorno = contaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id informado");
        }

        return retorno;
    }

    public void insert(Conta conta) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.insert(conta);

    }

    public void update(Conta conta) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {
        
        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.update(conta);
        
    }
    
    public void delete(Conta conta) throws SQLException {
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.delete(conta.getId());
    }
    
}
