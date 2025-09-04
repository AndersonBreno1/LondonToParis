package londontoparis;

import java.util.ArrayList;
import java.util.List;

public class Trem implements Transporte {
	
	private String numTrem;
	private double valorPassagem;
	
	public Trem(String numTrem, double valorPassagem) {
		this.numTrem = numTrem;
		this.valorPassagem = valorPassagem;
	}

	@Override
	public double calculaDistanciaPercorrida(double distancia) {
		return distancia + 50;
	}

	@Override
	public double calculaTempoGasto(double distancia, List<PontoDeInteresse> pontos) {
		return calculaDistanciaPercorrida(distancia) / 30 + calculaTempoMedio(pontos);
	}

	public double calculaTempoMedio(List<PontoDeInteresse> pontos) {
		double tm = 0;
		
		for (PontoDeInteresse pdi : pontos) {
			if ("carro".equals(pdi.getTipo().toLowerCase())) {
				tm += pdi.getTempoMedio();
			}
		}
		
		return tm;
	}
	
	public String formataTransporte() {
		return "Trem" + 
				"\nNúmero do trem: " + numTrem +
				"\nValor da passagem: " + valorPassagem;
	}

	@Override
	public List<String> listarPontosDeInteresse(List<PontoDeInteresse> pontos) {
		List<String> out = new ArrayList<>();
		
		for (PontoDeInteresse pdi : pontos) {
			if ("trem".equals(pdi.getTipo().toLowerCase())) {
				out.add(pdi.toString());
			}
		}
		
		return out;
	}
}
