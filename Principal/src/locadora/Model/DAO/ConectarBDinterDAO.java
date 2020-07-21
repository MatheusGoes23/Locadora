package locadora.Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ConectarBDinterDAO<VO> {
	public void inserir(VO vo) throws SQLException;

	public void remover(VO vo) throws SQLException;

	public ResultSet buscar(VO vo) throws SQLException;

}