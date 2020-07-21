package locadora.Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import locadora.Model.VO.LivroVO;
import locadora.Model.VO.UsuarioVO;

public interface LivroInterDAO<VO extends LivroVO> extends ConectarBDinterDAO<VO> {
	public void alterarValor(VO vo) throws SQLException;

	public void alterarQuantidade(VO vo) throws SQLException;
	
	public List<LivroVO> listar() throws SQLException;

	public ResultSet buscarByTitle(VO vo) throws SQLException;
}
