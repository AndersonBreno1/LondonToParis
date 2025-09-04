package londontoparis;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import londontoparis.exception.LondonToParisException;

public class Rota {
	
	private String origem;
	private String destino;
	private double distancia;
	private int id;
	private List<PontoDeInteresse> pontos;
	private Transporte transporte;
	
	public Rota(String origem, String destino, double distancia, int id) {
		validaParametro(origem);
		validaParametro(destino);
		validaParametro(distancia);
		
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
		validaTransporte();
		
		return getTransporte().calculaDistanciaPercorrida(this.distancia);
	}

	public double mostrarTempoGasto() {
		validaTransporte();
		
		return getTransporte().calculaTempoGasto(distancia, pontos);
	}

	public String[] mostrarPontosDeInteresseDeTransporteDaRota() {
		validaTransporte();
		
		return emArray(getTransporte().listarPontosDeInteresse(pontos));
	}
	
	private String[] emArray(List<String> lista) {
		String[] out = new String[lista.size()];
		int idxOut = 0;
		
		for (String elem : lista) {
			out[idxOut++] = elem;
		}
		
		return out;
	}

	private void validaTransporte() {
		if (getTransporte() == null) throw new LondonToParisException("Transporte nulo.");
	}

	private void validaParametro(double param) {
		if (param < 0) throw new LondonToParisException("Parametro negativo");
		if (param == 0) throw new LondonToParisException("Parametro nulo");
	}

	private void validaParametro(String param) {
		if (param == null) throw new LondonToParisException("Parametro nulo");
		if ("".equals(param)) throw new LondonToParisException("Parametro nulo");
	}

}
