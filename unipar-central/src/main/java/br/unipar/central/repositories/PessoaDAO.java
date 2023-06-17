
package br.unipar.central.repositories;

import br.unipar.central.models.Pessoa;
import br.unipar.central.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    
        
    private static final String INSERT =
            "INSERT INTO pessoa(id, email, ra)" +
            "VALUES(?, ?, ?)";
    
    private static final String FIND_ALL =
            "SELECT id, email, ra FROM pessoa";
    
    private static final String FIND_BY_ID =
            "SELECT id, email, ra FROM pessoa WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM pessoa WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE pessoa SET email = ?, ra = ? " +
            "WHERE ID = ?";
    
    public List<Pessoa> findAll() throws SQLException {
        
        ArrayList<Pessoa> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("ID"));
                pessoa.setEmail(rs.getString("EMAIL"));
                pessoa.setRa(
                        rs.getString("RA"));
                
                retorno.add(pessoa);
                
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
    
    public Pessoa findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Pessoa retorno = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Pessoa();
               retorno.setId(rs.getInt("ID"));
               retorno.setEmail(rs.getString("EMAIL"));
               retorno.setRa(
                       rs.getString("RA"));
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
    
    public void insert(Pessoa pessoa) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, pessoa.getId());
            pstmt.setString(2, pessoa.getEmail());
            pstmt.setString(3, pessoa.getRa());
            
            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    public void update(Pessoa pessoa) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoa.getEmail());
            pstmt.setString(2, pessoa.getRa());
            pstmt.setInt(3, pessoa.getId());
            
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
