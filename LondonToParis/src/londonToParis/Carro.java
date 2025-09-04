package londonToParis;

import java.util.List;

public class Carro implements Transporte {
	
	private String rodovia;
	
	public Carro(String rodovia) {
		this.rodovia = rodovia;
	}

	@Override
	public double calculaDistanciaPercorrida(double distancia) {
		return distancia;
	}

	@Override
	public double calculaTempoGasto(double distancia, List<PontoDeInteresse> pontos) {
		return calculaDistanciaPercorrida(distancia) / 100 + calculaTempoMedio(pontos);
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
		return "Carro" +
				"\nRodovia: " + rodovia;
	}
}
