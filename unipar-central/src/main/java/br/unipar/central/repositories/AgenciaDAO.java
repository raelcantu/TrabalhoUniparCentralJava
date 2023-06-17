package br.unipar.central.repositories;

import br.unipar.central.models.Agencia;
import br.unipar.central.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO {

    private static final String INSERT
            = "INSERT INTO agencia(id, codigo, razaoSocial, cnpj, ra, banco_id)"
            + "VALUES(?,?,?,?,?,?)";

    private static final String FIND_ALL
            = "SELECT id, codigo, razaoSocial, cnpj, ra, banco_id FROM agencia";

    private static final String FIND_BY_ID
            = "SELECT id, codigo, razaoSocial, cnpj, ra, banco_id FROM agencia WHERE ID = ?";

    private static final String DELETE_BY_ID
            = "DELETE FROM agencia WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE agencia SET codigo = ?, razaoSocial = ?, cnpj = ?, ra = ?, banco_id = ? "
            + "WHERE ID = ?";

    public List<Agencia> findAll() throws SQLException {

        ArrayList<Agencia> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {

//                id, codigo, razaoSocial, cnpj, ra, banco_id
                Agencia agencia = new Agencia();
                agencia.setId(rs.getInt("ID"));
                agencia.setCodigo(rs.getString("codigo"));
                agencia.setRazaoSocial(rs.getString("razaoSocial"));
                agencia.setCnpj(rs.getString("cnpj"));
                agencia.setRa(rs.getString("ra"));
                agencia.setBanco(new BancoDAO().findById(rs.getInt("banco_id")));

                retorno.add(agencia);

            }

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

        return retorno;

    }

    public Agencia findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Agencia retorno = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                retorno = new Agencia();
                retorno.setId(rs.getInt("ID"));
                retorno.setCodigo(rs.getString("codigo"));
                retorno.setRazaoSocial(rs.getString("razaoSocial"));
                retorno.setCnpj(rs.getString("cnpj"));
                retorno.setRa(rs.getString("ra"));
                retorno.setBanco(new BancoDAO().findById(rs.getInt("banco_id")));
            }

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }

        }

        return retorno;

    }

    public void insert(Agencia agencia) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            // id, codigo, razaoSocial, cnpj, ra, banco_id
            pstmt.setInt(1, agencia.getId());
            pstmt.setString(2, agencia.getCodigo());
            pstmt.setString(3, agencia.getRazaoSocial());
            pstmt.setString(4, agencia.getCnpj());
            pstmt.setString(5, agencia.getRa());
            pstmt.setInt(6, agencia.getBanco().getId());

            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

    }

    public void update(Agencia agencia) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, agencia.getCodigo());
            pstmt.setString(2, agencia.getRazaoSocial());
            pstmt.setString(3, agencia.getCnpj());
            pstmt.setString(4, agencia.getRa());
            pstmt.setInt(5, agencia.getBanco().getId());
            pstmt.setInt(6, agencia.getId());

            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
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
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }


}
