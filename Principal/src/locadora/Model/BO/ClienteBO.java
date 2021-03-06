package locadora.Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import locadora.Model.DAO.ClienteDAO;
import locadora.Model.VO.ClienteVO;

import locadora.Model.VO.LocacaoVO;
import locadora.Model.VO.UsuarioVO;

import locadora.exception.InsertException;

public class ClienteBO implements ClienteInterBO<ClienteVO> {
	static private ClienteDAO<ClienteVO> dao = new ClienteDAO<ClienteVO>();

	// M�todos

	public void inserir(ClienteVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscarByCPF(vo);
			if (rs.next()) {
				throw new InsertException("Imposs�vel inserir, pois j� existe um cliente com este CPF");
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
				throw new InsertException("Imposs�vel alterar, pois n�o existe um cliente com esse Id");
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
				throw new InsertException("Imposs�vel remover, pois n�o existe um cliente com esse CPF");
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
				throw new InsertException("Imposs�vel remover, pois n�o existe um cliente com esse CPF");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}

	}

	public List<ClienteVO> listar() {
		List<ClienteVO> clientes = dao.listar();

		return clientes;
	}

	public List<ClienteVO> pesquisar(ClienteVO vo) throws InsertException {
		List<ClienteVO> clientes = null;
		try {
			ResultSet rs = dao.buscarByCPF(vo);
			
			if (rs.next()) {
				List<ClienteVO> clientes2 = dao.pesquisar(vo);
				clientes = clientes2;
			} else {
				throw new InsertException("Imposs�vel encontrar us�ario, pois n�o existe um cliente com esse CPF");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return clientes;
	}
	



}