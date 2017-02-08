package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		
		double valorUnitario = (sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue();
		
		preco = cacularValorUltimosIngressos(sessao, valorUnitario, sessao.getEspetaculo().getTipo());

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal cacularValorUltimosIngressos(Sessao sessao,
			double valorUnitario, TipoDeEspetaculo tipoDeEspetaculo) {
		
		BigDecimal preco;
		
		if(valorUnitario <= tipoDeEspetaculo.getPorcentagemCadeirasDisponiveis()) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(tipoDeEspetaculo.getAcrescimoValor())));
		} else {
			preco = sessao.getPreco();
		}
		
		if((tipoDeEspetaculo.equals(TipoDeEspetaculo.ORQUESTRA) || tipoDeEspetaculo.equals(TipoDeEspetaculo.BALLET)) 
				&& sessao.getDuracaoEmMinutos() > 60){
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}

}