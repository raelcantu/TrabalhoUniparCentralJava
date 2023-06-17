package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.models.Agencia;
import br.unipar.central.repositories.AgenciaDAO;
import java.sql.SQLException;
import java.util.List;

public class AgenciaService {

    public void validar(Agencia agencia) throws EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        //FALTA VALIDAR CONTA
        
        BancoService bs = new BancoService();
        bs.validar(agencia.getBanco());
        
        if (agencia == null) {
            throw new EntNaoInformadaException("Agencia");
        }

        if (agencia.getCnpj()== null || agencia.getCnpj().isEmpty() || agencia.getCnpj().isBlank()) {
            throw new CampoNaoInformadoException("CNPJ");
        }

        if (agencia.getCodigo()== null || agencia.getCodigo().isEmpty() || agencia.getCodigo().isBlank()) {
            throw new CampoNaoInformadoException("Código");
        }

        if (agencia.getRa() == null || agencia.getRa().isEmpty() || agencia.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (agencia.getRazaoSocial()== null || agencia.getRazaoSocial().isEmpty() || agencia.getRazaoSocial().isBlank()) {
            throw new CampoNaoInformadoException("Razão Social");
        }
        
        if (!(agencia.getRa().length() == 8)) {
            throw new TamanhoInvalidoException("RA", "igual a 8 Números.");
        }
        
        if (agencia.getCodigo().length()>20) {
            throw new TamanhoInvalidoException("Código", "menor que 20 dígitos");
        }

        if (agencia.getRazaoSocial().length() > 80) {
            throw new TamanhoInvalidoException("Razão Social", "menor que 80 letras.");
        }

    }
    
        public List<Agencia> findAll() throws SQLException {

        AgenciaDAO agenciaDAO = new AgenciaDAO();

        List<Agencia> resultado = agenciaDAO.findAll();
        return resultado;
    }

    public Agencia findById(int id) throws SQLException, TamanhoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoInvalidoException("id", "00");
        }

        AgenciaDAO agenciaDAO = new AgenciaDAO();

        Agencia retorno = agenciaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id informado");
        }

        return retorno;
    }

    public void insert(Agencia agencia) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {

        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.insert(agencia);

    }

    public void update(Agencia agencia) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException {
        
        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.update(agencia);
        
    }
    
    public void delete(Agencia agencia) throws SQLException {
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.delete(agencia.getId());
    }
}
