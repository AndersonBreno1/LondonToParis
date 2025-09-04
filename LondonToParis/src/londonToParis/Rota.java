package londonToParis;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rota {
	
	private String origem;
	private String destino;
	private double distancia;
	private int id;
	private List<PontoDeInteresse> pontos;
	private Transporte transporte;
	
	public Rota(String origem, String destino, double distancia, int id) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.id = id;
		this.pontos = new ArrayList<>();
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public double getDistancia() {
		return distancia;
	}

	public int getId() {
		return id;
	}
	
	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, origem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rota other = (Rota) obj;
		return Objects.equals(destino, other.destino) && Objects.equals(origem, other.origem);
	}

	@Override
	public String toString() {
		return "Origem: " + origem +
				"\nDestino: " + destino + 
				"\nDistancia: " + distancia +
				"\n"; 
	}

	public void cadastraPontoInteresse(String tipo, String descricao, double tempoMedio) {
		this.pontos.add(new PontoDeInteresse(tipo, descricao, tempoMedio));
	}

	public double mostrarDistanciaPercorrida() {
		return this.transporte.calculaDistanciaPercorrida(this.distancia);
	}

	public double mostrarTempoGasto() {
		return this.transporte.calculaTempoGasto(distancia, pontos);
	}

}
