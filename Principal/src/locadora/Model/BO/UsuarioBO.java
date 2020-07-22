package locadora.Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import locadora.Model.DAO.UsuarioDAO;
import locadora.Model.VO.UsuarioVO;
import locadora.exception.AutenticationException;
import locadora.exception.InsertException;

public class UsuarioBO implements UsuarioInterBO<UsuarioVO> {
	static private UsuarioDAO<UsuarioVO> dao = new UsuarioDAO<UsuarioVO>();

	// M�todos

	public void inserir(UsuarioVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				throw new InsertException("Imposs�vel inserir, pois j� existe um usuario com esse login");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void alterar(UsuarioVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.alterar(vo);
			} else {
				throw new InsertException("Imposs�vel alterar, pois n�o existe nenhum usuario com esse login");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void remover(UsuarioVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new InsertException("Imposs�vel remover, pois n�o existe nenhum usuario com esse login");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}

	}

	public UsuarioVO buscarUsuario(String login) {
		// toDO
		UsuarioVO usuario = new UsuarioVO();

		return usuario;
	}

	public List<UsuarioVO> listar() {
		List<UsuarioVO> usuarios = dao.listar();

		return usuarios;
	}

	public UsuarioVO autenticar(UsuarioVO vo) throws AutenticationException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.autenticar(vo);
			} else {
				throw new AutenticationException();
			}
		} catch (SQLException e) {
			throw new AutenticationException();

		}
		return vo;
	}
}
