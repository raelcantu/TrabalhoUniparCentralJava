package br.unipar.central.repositories;

import br.unipar.central.models.PessoaJuridica;
import br.unipar.central.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {
    
        
    private static final String INSERT =
            "INSERT INTO pessoaJuridica(razaoSocial, cnpj, cnaeprincipal, fantasia, pessoa_id)" +
            "VALUES(?, ?, ?, ?, ?)";
    
    private static final String FIND_ALL =
            "SELECT razaoSocial, cnpj, cnaeprincipal, fantasia, pessoa_id FROM pessoaJuridica";
    
    private static final String FIND_BY_ID =
            "SELECT razaoSocial, cnpj, cnaeprincipal, fantasia, pessoa_id FROM pessoaJuridica WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM pessoaJuridica WHERE pessoa_id = ?";
    
    private static final String UPDATE = 
            "UPDATE pessoaJuridica SET razaoSocial = ?, cnpj = ?, cnaeprincipal = ?, fantasia = ? " +
            "WHERE pessoa_id = ?";
    
    public List<PessoaJuridica> findAll() throws SQLException {
        
        ArrayList<PessoaJuridica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
//                razaoSocial, cnpj, cnaeprincipal, fantasia, pessoa_id
                pessoaJuridica.setCnpj(rs.getString("cnpj"));
                pessoaJuridica.setRazaoSocial("razaoSocial");
                pessoaJuridica.setCnaePrincipal("cnaeprincipal");
                pessoaJuridica.setFantasia(rs.getString("fantasia"));
                pessoaJuridica.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                
                retorno.add(pessoaJuridica);
                
            }
            
        } finally {
            
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null) 
                conn.close();
        }
        
        return retorno;
        
    }
    
    public PessoaJuridica findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaJuridica retorno = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new PessoaJuridica();
                retorno.setCnpj(rs.getString("cnpj"));
                retorno.setRazaoSocial("razaoSocial");
                retorno.setCnaePrincipal("cnaeprincipal");
                retorno.setFantasia(rs.getString("fantasia"));
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
            }
            
        } finally {
            
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
            
        }
        
        return retorno;
        
    }
    
    public void insert(PessoaJuridica pessoaJuridica) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
//                razaoSocial, cnpj, cnaeprincipal, fantasia, pessoa_id
            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCnpj());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
            pstmt.setInt(5, pessoaJuridica.getPessoa().getId());
            
            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    public void update(PessoaJuridica pessoaJuridica) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCnpj());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
            pstmt.setInt(5, pessoaJuridica.getPessoa().getId());
            
            pstmt.executeUpdate();
            
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    
    public void delete(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
        
    }
    
}
