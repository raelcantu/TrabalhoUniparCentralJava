package br.unipar.central.repositories;

import br.unipar.central.models.Cidade;
import br.unipar.central.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {
    
    private static final String INSERT =
            "INSERT INTO cidade(id, nome, ra, estado_id)" +
            "VALUES(?, ?, ?, ?)";
    
    private static final String FIND_ALL =
            "SELECT id, nome, ra, estado_id FROM PAIS";
    
    private static final String FIND_BY_ID =
            "SELECT id, nome, ra, estado_id FROM cidade WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM estado WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE estado SET nome = ?, ra = ?, estado_id = ? " +
            "WHERE ID = ?";
    
    public List<Cidade> findAll() throws SQLException {
        
        ArrayList<Cidade> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("ID"));
                cidade.setNome(rs.getString("NOME"));
                cidade.setRa (rs.getString("RA"));
                cidade.setEstado(new EstadoDAO().findById(
                        rs.getInt("estado_id")));
                
                retorno.add(cidade);
                
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
    
    public Cidade findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cidade retorno = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Cidade();
               retorno.setId(rs.getInt("ID"));
               retorno.setNome(rs.getString("NOME"));
               retorno.setRa(
                       rs.getString("RA"));
               retorno.setEstado(new EstadoDAO().findById(
                        rs.getInt("estado_id")));
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
    
    public void insert(Cidade cidade) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, cidade.getId());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getRa());
            pstmt.setInt(4, cidade.getEstado().getId());
            
            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    public void update(Cidade cidade) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, cidade.getNome());
            pstmt.setString(2, cidade.getRa());
            pstmt.setInt(3, cidade.getId());
            pstmt.setInt(4, cidade.getEstado().getId());
            
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