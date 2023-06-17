
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.models.PessoaJuridica;
import br.unipar.central.repositories.PessoaJuridicaDAO;
import java.sql.SQLException;
import java.util.List;

public class PessoaJuridicaService {
    
        public void validar(PessoaJuridica pessoaJuridica) throws EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

            PessoaService p = new PessoaService();
            p.validar(pessoaJuridica.getPessoa());
            
        if (pessoaJuridica == null) {
            throw new EntNaoInformadaException("Pessoa Física");
        }

        if (pessoaJuridica.getCnaePrincipal()== null || pessoaJuridica.getCnaePrincipal().isEmpty() || pessoaJuridica.getCnaePrincipal().isBlank()) {
            throw new CampoNaoInformadoException("CNAE");
        }

        if (pessoaJuridica.getRazaoSocial()== null || pessoaJuridica.getRazaoSocial().isEmpty() || pessoaJuridica.getRazaoSocial().isBlank()) {
            throw new CampoNaoInformadoException("Razão Social");
        }

        if (pessoaJuridica.getCnpj()== null || pessoaJuridica.getCnpj().isEmpty() || pessoaJuridica.getCnpj().isBlank()) {
            throw new CampoNaoInformadoException("cnpj");
        }

        if (!(pessoaJuridica.getCnpj().length() == 14)) {
            throw new TamanhoInvalidoException("cnpj", "igual a 14 dígitos.");
        }

        if (pessoaJuridica.getRazaoSocial().length() > 60) {
            throw new TamanhoInvalidoException("Nome", "menor que 60 letras.");
        }

    }

    public List<PessoaJuridica> findAll() throws SQLException {

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

        List<PessoaJuridica> resultado = pessoaJuridicaDAO.findAll();
        return resultado;
    }

    public PessoaJuridica findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

        PessoaJuridica retorno = pessoaJuridicaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id informado");
        }

        return retorno;
    }

    public void insert(PessoaJuridica pessoaJuridica) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.insert(pessoaJuridica);

    }

    public void update(PessoaJuridica pessoaJuridica) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {
        
        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.update(pessoaJuridica);
        
    }
    
    public void delete(PessoaJuridica pessoaJuridica) throws SQLException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.delete(pessoaJuridica.getId());
    }
    
}
