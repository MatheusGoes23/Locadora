package locadora.Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import locadora.Model.DAO.DiscoDAO;
import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.LivroVO;
import locadora.Model.VO.ProdutoVO;
import locadora.exception.InsertException;

public class DiscoBO implements DiscoInterBO<DiscoVO> {
	static private DiscoDAO<DiscoVO> dao = new DiscoDAO<DiscoVO>();

	// Métodos
	
	public void inserir(DiscoVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscarByTitle(vo);
			if (rs.next()) {
				throw new InsertException("Impossível inserir, pois já existe um disco com esse título");
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
				throw new InsertException("Impossível alterar, pois não existe um disco com esse Id");
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
				throw new InsertException("Impossível alterar, pois não existe um disco com esse Id");
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
				throw new InsertException("Impossível remover, pois não existe um disco com esse Id");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}

	}

	public ProdutoVO imprimirFicha(ProdutoVO produto) {
		// Ficha do Livro
		// toDo
		DiscoVO disco = new DiscoVO();

		return disco;
	}

	public ProdutoVO[] pesquisarTitulo(String titulo) {
		// toDo
		DiscoVO discos[] = new DiscoVO[5];

		return discos;
	}

	public ProdutoVO[] pesquisarAno(int ano) {
		// toDo
		DiscoVO discos[] = new DiscoVO[5];

		return discos;
	}

	public ProdutoVO[] pesquisarGenero(String genero) {
		// toDo
		DiscoVO discos[] = new DiscoVO[5];

		return discos;
	}

	public void imprimirLista() {
		// Imprime listagem de discos com Código, Título, QtdExemplares...
		// public List<DiscoVO> imprimirLista(){
		// toDo
	}

	@Override
	public List<DiscoVO> listar() throws InsertException {
		// TODO Auto-generated method stub
		return null;
	}


}