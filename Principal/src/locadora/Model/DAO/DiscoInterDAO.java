package locadora.Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import locadora.Model.VO.DiscoVO;


public interface DiscoInterDAO<VO extends DiscoVO> extends ConectarBDinterDAO<VO> {
	public void alterarValor(VO vo) throws SQLException;

	public void alterarQuantidade(VO vo) throws SQLException;
	
	public List<DiscoVO> listar() throws SQLException;

	public ResultSet buscarByTitle(VO vo) throws SQLException;

}
