package locadora.Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import locadora.Model.DAO.ClienteDAO;
import locadora.Model.VO.ClienteVO;
import locadora.Model.VO.LocacaoVO;
import locadora.Model.VO.UsuarioVO;
import locadora.exception.InsertException;
import locadora.exception.NotFoundException;

public class ClienteBO implements ClienteInterBO<ClienteVO> {
	static private ClienteDAO<ClienteVO> dao = new ClienteDAO<ClienteVO>();

	// Métodos

	public void inserir(ClienteVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscarByCPF(vo);
			if (rs.next()) {
				throw new InsertException("Impossível inserir, pois já existe um cliente com este CPF");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void alterar(ClienteVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.alterar(vo);
			} else {
				throw new InsertException("Impossível alterar, pois não existe um cliente com esse Id");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void remover(ClienteVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new InsertException("Impossível remover, pois não existe um cliente com esse CPF");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}

	}

	public void removerByCPF(ClienteVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscarByCPF(vo);
			if (rs.next()) {
				dao.removerByCPF(vo);
			} else {
				throw new InsertException("Impossível remover, pois não existe um cliente com esse CPF");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}

	}

	public List<ClienteVO> listar() {
		List<ClienteVO> clientes = dao.listar();

		return clientes;
	}

	public void imprimirFichaCliente(ClienteVO cliente, LocacaoVO locacao) {
		// Imprime um lista de Clientes com CPF, Nome, Telefone...
		// toDo
	}

	@Override
	public void buscar(ClienteVO vo) throws NotFoundException {
		// TODO Auto-generated method stub

	}

}