package br.unipar.central.repositories;

import br.unipar.central.models.Transacao;
import br.unipar.central.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    
        
    private static final String INSERT =
            "INSERT INTO transacao(id, datahora, valor, tipo, ra, conta_origem , conta_destino)" +
            "VALUES(?,?,?,?,?,?,?)";
    
    private static final String FIND_ALL =
            "SELECT id, datahora, valor, tipo, ra, conta_origem, conta_destino FROM transacao";
    
    private static final String FIND_BY_ID =
            "SELECT id, datahora, valor, tipo, ra, conta_origem, conta_destino FROM transacao WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM transacao WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE transacao SET datahora = ?, valor = ?,  tipo = ?, ra = ?, conta_origem = ?, conta_destino = ? " +
            "WHERE ID = ?";
    
    public List<Transacao> findAll() throws SQLException {
        
        ArrayList<Transacao> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                Transacao transacao = new Transacao();
//                id, datahora, valor, tipo, ra, conta_origem, conta_destino
                transacao.setId(rs.getInt("ID"));
                transacao.setDatahora(null);
                transacao.setValor(rs.getLong("valor"));
                transacao.setTipo(rs.getInt("tipo"));
                transacao.setRa(rs.getString("ra"));
                transacao.setContaDestino(new ContaDAO().findById(rs.getInt("conta_destino")));
                transacao.setContaOrigem(new ContaDAO().findById(rs.getInt("conta_origem")));
                retorno.add(transacao);
                
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
    
    public Transacao findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transacao retorno = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Transacao();
                retorno.setId(rs.getInt("ID"));
                retorno.setDatahora(null);
                retorno.setValor(rs.getLong("valor"));
                retorno.setTipo(rs.getInt("tipo"));
                retorno.setRa(rs.getString("ra"));
                retorno.setContaDestino(new ContaDAO().findById(rs.getInt("conta_destino")));
                retorno.setContaOrigem(new ContaDAO().findById(rs.getInt("conta_origem")));
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
    
    public void insert(Transacao transacao) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
//                id, datahora, valor, tipo, ra, conta_origem, conta_destino
            pstmt.setInt(1, transacao.getId());
            pstmt.setDate(2, transacao.getDatahora());
            pstmt.setLong(3, transacao.getValor());
            pstmt.setInt(4, transacao.getTipo());
            pstmt.setString(5, transacao.getRa());
            pstmt.setInt(6, transacao.getContaOrigem().getId());
            pstmt.setInt(7, transacao.getContaDestino().getId());
            
            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    public void update(Transacao transacao) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setDate(1, transacao.getDatahora());
            pstmt.setLong(2, transacao.getValor());
            pstmt.setInt(3, transacao.getTipo());
            pstmt.setString(4, transacao.getRa());
            pstmt.setInt(5, transacao.getContaOrigem().getId());
            pstmt.setInt(6, transacao.getContaDestino().getId());
            pstmt.setInt(7, transacao.getId());
            
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
