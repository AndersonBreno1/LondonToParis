package londontoparis;

public class PontoDeInteresse {
	
	private String tipo;
	private String descricao;
	private double tempoMedio;
	
	public PontoDeInteresse(String tipo, String descricao, double tempoMedio) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.tempoMedio = tempoMedio;
	}

	@Override
	public String toString() {
		return "PontoDeInteresse [tipo=" + tipo + ", descricao=" + descricao + ", tempoMedio=" + tempoMedio + "]";
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getTempoMedio() {
		return tempoMedio;
	}
}
