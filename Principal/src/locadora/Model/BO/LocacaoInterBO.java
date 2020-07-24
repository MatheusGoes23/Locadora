package locadora.Model.BO;

import locadora.Model.VO.LocacaoVO;

public interface LocacaoInterBO<VO extends LocacaoVO> extends ConectarBDinterBO<VO> {
	public double faturamentoMes();
}
