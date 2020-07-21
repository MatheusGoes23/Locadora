package locadora.Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import locadora.Model.DAO.LocacaoDAO;
import locadora.Model.VO.LocacaoVO;
import locadora.exception.InsertException;

public class LocacaoBO implements LocacaoInterBO<LocacaoVO> {
	static private LocacaoDAO<LocacaoVO> dao = new LocacaoDAO<LocacaoVO>();

	// M�todos

	public void inserir(LocacaoVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				throw new InsertException("Imposs�vel inserir, pois j� existe uma loca��o com esse Id");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void alterarLocacao() {
		// toDo
	}

	public void remover(LocacaoVO vo) throws InsertException {
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new InsertException("Imposs�vel remover, pois n�o existe nenhuma loca��o com esse Id");
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}

	}

	public void pesquisarLocacao() {
		// toDo
	}

	public void imprimirFaturamentoMes() {
		// Lista dos itens alugados num determinado m�s com os valores somados
		// toDo
	}

	public void imprimirLocacaoData() {
		// Lista de itens alugados num determinado per�odo
		// toDo
	}

	public void imprimirLocacaoCliente() {
		// Lista de itens(codigo e titulo) alugados por um cliente
		// toDo
	}

	public void imprimirComprovanteLocacao() {
		// Um recibo para loca��o
		// toDo
	}

	@Override
	public List<LocacaoVO> listar() throws InsertException {
		// TODO Auto-generated method stub
		return null;
	}
}