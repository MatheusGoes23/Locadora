package locadora.Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locadora.Model.VO.ClienteVO;

import locadora.Model.VO.UsuarioVO;


public class ClienteDAO<VO extends ClienteVO> extends ConectarBD<VO> implements ClienteInterDAO<VO> {

	// Métodos

	// Lista todos os dados dos clientes existentes no Banco de Dados
	public List<ClienteVO> listar() {
		String sql = "SELECT * FROM cliente";
		Statement st;
		ResultSet resultado = null;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				ClienteVO cli = new ClienteVO();
				cli.setIdCliente(resultado.getLong("idCliente"));
				cli.setNome(resultado.getString("nome"));
				cli.setCpf(resultado.getString("cpf"));
				cli.setTelefone(resultado.getString("telefone"));
				cli.setEndereco(resultado.getString("endereco"));
				clientes.add(cli);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return clientes;
	}

	/*
	 * Busca os dados de um cliente expecífico no Banco de Bados a partir do cpf
	 * informado
	 */
	public ResultSet buscarByCPF(VO cliente) {
		String sql = "SELECT * FROM cliente WHERE cpf=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, cliente.getCpf());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	/*
	 * Busca os dados de um cliente expecífico no Banco de Bados a partir do cpf
	 * informado
	 */
	public ResultSet buscar(VO cliente) {
		String sql = "SELECT * FROM cliente WHERE IdCliente=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, cliente.getIdCliente());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	/*
	 * Altera o nome de um cliente específico no Banco de Dados a partir do
	 * IdCliente informado
	 */
	public void alterar(VO cliente) {
		String sql = "UPDATE cliente SET nome=? , cpf=? , endereco=? , telefone=? WHERE idCliente=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, cliente.getNome());
			ptst.setString(2, cliente.getCpf());
			ptst.setString(3, cliente.getEndereco());
			ptst.setString(4, cliente.getTelefone());
			ptst.setLong(5, cliente.getIdCliente());
			ptst.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Remove todos os dados de um cliente específico no Banco de Dados a partir do
	 * id do cliente informado
	 */
	public void remover(VO cliente) {
		String sql = "DELETE FROM cliente WHERE IdCliente=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, cliente.getIdCliente());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Remove todos os dados de um cliente específico no Banco de Dados a partir do
	 * cpf informado
	 */
	public void removerByCPF(VO cliente) {
		String sql = "DELETE FROM cliente WHERE cpf=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, cliente.getCpf());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Cadastra os dados de um cliente no Banco de Dados
	public void inserir(VO cliente) {
		String sql = "insert into cliente(nome, cpf, telefone, endereco) values(?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, cliente.getNome());
			ptst.setString(2, cliente.getCpf());
			ptst.setString(3, cliente.getTelefone());
			ptst.setString(4, cliente.getEndereco());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				cliente.setIdCliente(generatedKeys.getLong(1));
			} else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Recebe um titulo e faz uma pesquisa e retorna os dados do cliente com esse
	// titulo
	public List<ClienteVO> pesquisar(VO cliente) {
		String sql = "SELECT * FROM cliente WHERE CPF=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, cliente.getCpf());
			resultado = st.executeQuery();
			while (resultado.next()) {
				ClienteVO cli = new ClienteVO();
				cli.setIdCliente(resultado.getLong("idCliente"));
				cli.setCpf(resultado.getString("cpf"));
				cli.setNome(resultado.getString("nome"));
				cli.setTelefone(resultado.getString("telefone"));
				cli.setEndereco(resultado.getString("endereco"));

				clientes.add(cli);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return clientes;
	}

}


