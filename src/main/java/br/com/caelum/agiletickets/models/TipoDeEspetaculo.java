package br.com.caelum.agiletickets.models;

public enum TipoDeEspetaculo {
	
	CINEMA(0.05, 0.10), SHOW(0.05, 0.10), TEATRO(0.00, 0.00), BALLET(0.50, 0.20), ORQUESTRA(0.50, 0.20);
	
	
	double valorMinimo;
	double multiplicador;
	
	private TipoDeEspetaculo(double valorMinimo, double multiplicador) {
		this.valorMinimo = valorMinimo;
		this.multiplicador = multiplicador;
	}

	public double getPorcentagemCadeirasDisponiveis() {
		return valorMinimo;
	}

	public double getAcrescimoValor() {
		return multiplicador;
	}
		
}
