package locadora.Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import locadora.Model.VO.LivroVO;


public class LivroDAO extends ConectarBD {

    //Métodos
    //Métodos
    public void inserir(LivroVO livro){
        connection = getConnection();
        String sql = "insert into livro(titulo, autor, genero, anoLancamento, qtdExemplares, qtdPaginas, valorAluguel) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ptst = connection.prepareStatement(sql);
            ptst.setString(1, livro.getTitulo());
            ptst.setString(2, livro.getAutor());
            ptst.setString(3, livro.getGenero());
            ptst.setInt(4, livro.getAnoDeLancamento());
            ptst.setInt(5, livro.getQtdExemplares());
            ptst.setInt(6, livro.getQtdPaginas());
            ptst.setDouble(7, livro.getValorDoAluguel());
            ptst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarValor(LivroVO livro) {
        connection = getConnection();
        String sql = "UPDATE livro SET valorAluguel=? WHERE idLivro=?";
        try {
            PreparedStatement ptst = connection.prepareStatement(sql);
            ptst.setDouble(1, livro.getValorDoAluguel());
            ptst.setLong(2, livro.getIdProduto());
            ptst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterarQuantidade(LivroVO livro) {
        connection = getConnection();
        String sql = "UPDATE livro SET qtdExemplares=? WHERE idLivro=?";
        try {
            PreparedStatement ptst = connection.prepareStatement(sql);
            ptst.setDouble(1, livro.getQtdExemplares());
            ptst.setLong(2, livro.getIdProduto());
            ptst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerById(LivroVO livro) {
        connection = getConnection();
        String sql = "DELETE FROM livro WHERE idLivro=?";
        try {
            PreparedStatement ptst = connection.prepareStatement(sql);
            ptst.setLong(1, livro.getIdProduto());
            ptst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public List<LivroVO> listar() {
        connection = getConnection();
        String sql = "SELECT * FROM livro";      
        Statement st;
        ResultSet resultado;
        List<LivroVO> livros = new ArrayList<LivroVO>();
        
        try {
            st = connection.createStatement();
            resultado = st.executeQuery(sql);
            while (resultado.next()) {
                LivroVO liv = new LivroVO();
                liv.setIdProduto(resultado.getLong("IdLivro"));
                liv.setTitulo(resultado.getString("titulo"));
                liv.setAutor(resultado.getString("autor"));
                liv.setGenero(resultado.getString("genero"));
                liv.setAnoDeLancamento(resultado.getInt("anoLancamento"));
                liv.setQtdExemplares(resultado.getInt("qtdExemplares"));
                liv.setQtdPaginas(resultado.getInt("qtdPaginas"));
                liv.setValorDoAlulguel(resultado.getDouble("valorAluguel"));
                livros.add(liv);
            }
        } catch (SQLException ex) {
            System.out.println("deu mal");}
            return livros;
        }

    public LivroVO buscar(LivroVO livro) {
        connection = getConnection();
        String sql = "SELECT * FROM livro WHERE idLivro=?";
        try {
            PreparedStatement ptst = connection.prepareStatement(sql);
            ptst.setLong(1, livro.getIdProduto());
            ResultSet resultado = ptst.executeQuery();
            if (resultado.next()) {
                livro.setIdProduto(resultado.getLong("IdLivro"));
                livro.setTitulo(resultado.getString("titulo"));
                livro.setAutor(resultado.getString("autor"));
                livro.setGenero(resultado.getString("genero"));
                livro.setAnoDeLancamento(resultado.getInt("anoLancamento"));
                livro.setQtdExemplares(resultado.getInt("qtdExemplares"));
                livro.setQtdPaginas(resultado.getInt("qtdPaginas"));
                livro.setValorDoAlulguel(resultado.getDouble("valorAluguel"));
                return livro;
            }
        } catch (SQLException ex) {
        System.out.println("deu mal");
        }
        return livro;
    }
}
