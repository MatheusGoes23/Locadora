package locadora.Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import locadora.Model.DAO.DiscoDAO;
import locadora.Model.VO.DiscoVO;
import locadora.exception.InsertException;

public class DiscoBO implements DiscoInterBO<DiscoVO> {
	static private DiscoDAO<DiscoVO> dao = new DiscoDAO<DiscoVO>();

	// M�todos

	public void inserir(DiscoVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscarByTitle(vo);
			if (rs.next()) {
				throw new InsertException("Imposs�vel inserir, pois j� existe um disco com esse t�tulo");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void alterarValor(DiscoVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.alterarValor(vo);
			} else {
				throw new InsertException("Imposs�vel alterar, pois n�o existe nenhum disco com esse Id");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void alterarQuantidade(DiscoVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.alterarQuantidade(vo);
			} else {
				throw new InsertException("Imposs�vel alterar, pois n�o existe nenhum disco com esse Id");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void remover(DiscoVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new InsertException("Imposs�vel remover, pois n�o existe nenhum disco com esse Id");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}

	}

	public List<DiscoVO> listar() {
		List<DiscoVO> discos = dao.listar();

		return discos;
	}

}