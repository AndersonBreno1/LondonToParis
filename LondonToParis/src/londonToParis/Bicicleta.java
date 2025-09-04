package londonToParis;

import java.util.List;

public class Bicicleta implements Transporte {
	
	private String tipoTerreno;
	private int pernoites;
	
	public Bicicleta(String terreno, int pernoites) {
		this.tipoTerreno = terreno;
		this.pernoites = pernoites;
	}

	@Override
	public double calculaDistanciaPercorrida(double distancia) {
		return distancia + 100;
	}

	@Override
	public double calculaTempoGasto(double distancia, List<PontoDeInteresse> pontos) {
		return calculaDistanciaPercorrida(distancia) / 30 + calculaTempoMedio(pontos);
	}
	
	public double calculaTempoMedio(List<PontoDeInteresse> pontos) {
		double tm = 0;
		
		for (PontoDeInteresse pdi : pontos) {
			if ("bicicleta".equals(pdi.getTipo().toLowerCase())) {
				tm += pdi.getTempoMedio();
			}
		}
		
		return tm;
	}
	
	public String formataTransporte() {
		return "Bicicleta" +
				"\nTipo do terreno: " + tipoTerreno +
				"\nPernoites: " + pernoites;
	}
}
