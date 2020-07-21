package locadora.Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import locadora.Model.VO.LivroVO;

public interface LivroInterDAO<VO extends LivroVO> extends ConectarBDinterDAO<VO> {
	public void alterarValor(VO vo) throws SQLException;

	public void alterarQuantidade(VO vo) throws SQLException;

	public ResultSet buscarByTitle(VO vo) throws SQLException;
}
