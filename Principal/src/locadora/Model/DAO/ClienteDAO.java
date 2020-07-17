package locadora.Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import locadora.Model.VO.ClienteVO;


public class ClienteDAO extends ConectarBD {
    
    //Métodos
    public List<ClienteVO> listar() {
        connection = getConnection();
        String sql = "SELECT * FROM cliente";      
        Statement st;
        ResultSet resultado;
        List<ClienteVO> clientes = new ArrayList<ClienteVO>();
        
        try {
            st = connection.createStatement();
            resultado = st.executeQuery(sql);
            while (resultado.next()) {
                ClienteVO cli = new ClienteVO();
                cli.setIdCliente(resultado.getLong("IdCliente"));
                cli.setCpf(resultado.getString("cpf"));
                cli.setNome(resultado.getString("nome"));
                cli.setEndereco(resultado.getString("endereco"));
                cli.setTelefone(resultado.getString("telefone"));
                clientes.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("deu mal");}
            return clientes;
        }

        public ClienteVO buscar(ClienteVO cliente) {
            connection = getConnection();
            String sql = "SELECT * FROM cliente WHERE cpf=?";
            try {
                PreparedStatement ptst = connection.prepareStatement(sql);
                ptst.setString(1, cliente.getCpf());
                ResultSet rs = ptst.executeQuery();
                if (rs.next()) {
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setEndereco(rs.getString("endereco"));
                    return cliente;
                }
            } catch (SQLException ex) {
            System.out.println("deu mal");
            }
            return cliente;
    }
        
    public void alterar(ClienteVO cliente) {
        connection = getConnection();
        String sql = "UPDATE cliente SET nome=? WHERE idCliente=?";
        try {
            PreparedStatement ptst = connection.prepareStatement(sql);
            ptst.setString(1, cliente.getNome());
            ptst.setLong(2, cliente.getIdCliente());
            ptst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public void removerByCPF(ClienteVO cliente) {
            connection = getConnection();
            String sql = "DELETE FROM cliente WHERE cpf=?";
            try {
                PreparedStatement ptst = connection.prepareStatement(sql);
                ptst.setString(1, cliente.getCpf());
                ptst.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    public void removerById(ClienteVO cliente) {
        connection = getConnection();
        String sql = "DELETE FROM cliente WHERE idCliente=?";
        try {
            PreparedStatement ptst = connection.prepareStatement(sql);
            ptst.setLong(1, cliente.getIdCliente());
            ptst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        public void inserir(ClienteVO cliente){
            connection = getConnection();
            String sql = "insert into cliente(nome, cpf, telefone, endereco) values(?,?,?,?)";
            try {
                PreparedStatement ptst = connection.prepareStatement(sql);
                ptst.setString(1, cliente.getNome());
                ptst.setString(2, cliente.getCpf());
                ptst.setString(3, cliente.getTelefone());
                ptst.setString(4, cliente.getEndereco());
                ptst.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
