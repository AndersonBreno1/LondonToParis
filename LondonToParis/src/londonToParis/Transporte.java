package londonToParis;

import java.util.List;

public interface Transporte {
	
	public double calculaDistanciaPercorrida(double distancia);
	public double calculaTempoGasto(double distancia, List<PontoDeInteresse> pontos);
	public double calculaTempoMedio(List<PontoDeInteresse> pontos);
	public String formataTransporte();
	
}
