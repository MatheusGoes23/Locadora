package locadora.Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import locadora.Model.DAO.LivroDAO;
import locadora.Model.VO.LivroVO;

import locadora.Model.VO.ProdutoVO;
import locadora.Model.VO.UsuarioVO;

import locadora.exception.InsertException;

public class LivroBO implements LivroInterBO<LivroVO> {
	static private LivroDAO<LivroVO> dao = new LivroDAO<LivroVO>();

	// Métodos

	public void inserir(LivroVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscarByTitle(vo);
			if (rs.next()) {
				throw new InsertException("Impossível inserir, pois já existe um livro com esse título");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void alterarValor(LivroVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.alterarValor(vo);
			} else {
				throw new InsertException("Impossível alterar, pois não existe um livro com esse Id");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void alterarQuantidade(LivroVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.alterarQuantidade(vo);
			} else {
				throw new InsertException("Impossível alterar, pois não existe um livro com esse Id");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void remover(LivroVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new InsertException("Impossível remover, pois não existe um livro com esse Id");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}

	}

	public List<LivroVO> listar() {
		List<LivroVO> livros = dao.listar();

		return livros;
	}


	public List<LivroVO> pesquisar(LivroVO vo) throws InsertException {
		List<LivroVO> livros = null;
		try {
			ResultSet rs = dao.buscarByTitle(vo);

			if (rs.next()) {
				List<LivroVO> livros2 = dao.pesquisar(vo);
				livros = livros2;
			} else {
				throw new InsertException("Impossível encontrar o livro, pois não existe um livro com esse título");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return livros;
	}

}

