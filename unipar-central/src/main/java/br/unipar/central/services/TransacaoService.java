package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.SaldoInsuficienteException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.Transacao;
import br.unipar.central.repositories.TransacaoDAO;
import java.sql.SQLException;
import java.util.List;

public class TransacaoService {
    
        public void validar(Transacao transacao) throws EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException, SaldoInsuficienteException, ValorInvalidoException {

        if (transacao == null) {
            throw new EntNaoInformadaException("Transação");
        }

        if (transacao.getId()<= 0) {
            throw new CampoNaoInformadoException("ID");
        }
        
        if(transacao.getValor()<=0){
            throw new ValorInvalidoException();
        }
        
//        if(transacao.getContaOrigem().getSaldo()< transacao.getValor()){
//            throw new SaldoInsuficienteException(transacao.getContaOrigem().getSaldo(), transacao.getValor());
//        }

        if (transacao.getRa() == null || transacao.getRa().isEmpty() || transacao.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (transacao.getContaDestino()== null) {
            throw new CampoNaoInformadoException("Conta destino");
        }

        if (transacao.getContaOrigem()== null) {
            throw new CampoNaoInformadoException("Conta origem");
        }

    }

    public List<Transacao> findAll() throws SQLException {

        TransacaoDAO transacaoDAO = new TransacaoDAO();

        List<Transacao> resultado = transacaoDAO.findAll();
        return resultado;
    }

    public Transacao findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        TransacaoDAO transacaoDAO = new TransacaoDAO();

        Transacao retorno = transacaoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar uma conta com o id informado");
        }

        return retorno;
    }

    public void insert(Transacao transacao) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException, SaldoInsuficienteException, ValorInvalidoException {

        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.insert(transacao);

    }

    public void update(Transacao transacao) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException, SaldoInsuficienteException, ValorInvalidoException {
        
        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.update(transacao);
        
    }
    
    public void delete(Transacao transacao) throws SQLException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.delete(transacao.getId());
    }
    
}
