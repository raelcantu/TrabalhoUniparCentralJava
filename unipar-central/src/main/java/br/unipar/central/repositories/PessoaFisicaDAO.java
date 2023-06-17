package br.unipar.central.repositories;

import br.unipar.central.models.PessoaFisica;
import br.unipar.central.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {

    private static final String INSERT
            = "INSERT INTO pessoaFisica(nome, cpf, rg, datanascimento, pessoa_id) "
            + "VALUES(?, ?, ?, ?, ?)";

    private static final String FIND_ALL
            = "SELECT nome, cpf, rg, datanascimento, pessoa_id FROM pessoaFisica";

    private static final String FIND_BY_ID
            = "SELECT nome, cpf, rg, datanascimento FROM pessoaFisica WHERE pessoa_id = ?";

    private static final String DELETE_BY_ID
            = "DELETE FROM pessoaFisica WHERE pessoa_id = ?";

    private static final String UPDATE
            = "UPDATE pessoaFisica SET NOME = ?, cpf = ?, rg = ?, datanascimento = ?"
            + "WHERE pessoa_id = ?";

    public List<PessoaFisica> findAll() throws SQLException {

        ArrayList<PessoaFisica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {

//                id, nome, cpf, rg, datanascimento, pessoa_id
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setNome(rs.getString("NOME"));
                pessoaFisica.setCpf(rs.getString("cpf"));
                pessoaFisica.setRg(rs.getString("rg"));
                pessoaFisica.setDataNascimento(rs.getDate("datanascimento"));
                pessoaFisica.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));

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

    public PessoaFisica findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaFisica retorno = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new PessoaFisica();
                retorno.setNome(rs.getString("NOME"));
                retorno.setCpf(rs.getString("cpf"));
                retorno.setRg(rs.getString("rg"));
                retorno.setDataNascimento(rs.getDate("datanascimento"));
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
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

    public void insert(PessoaFisica pessoaFisica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);

//                id, nome, cpf, rg, datanascimento, pessoa_id
            pstmt.setString(1, pessoaFisica.getNome());
            pstmt.setString(2, pessoaFisica.getCpf());
            pstmt.setString(3, pessoaFisica.getRg());
            pstmt.setDate(4, pessoaFisica.getDataNascimento());
            pstmt.setInt(5, pessoaFisica.getPessoa().getId());

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

    public void update(PessoaFisica pessoaFisica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoaFisica.getNome());
            pstmt.setString(2, pessoaFisica.getCpf());
            pstmt.setString(3, pessoaFisica.getRg());
            pstmt.setDate(4, pessoaFisica.getDataNascimento());
            pstmt.setInt(5, pessoaFisica.getPessoa().getId());

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
