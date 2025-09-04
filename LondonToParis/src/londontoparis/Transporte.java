package londontoparis;

import java.util.List;

public interface Transporte {
	
	public double calculaDistanciaPercorrida(double distancia);
	public double calculaTempoGasto(double distancia, List<PontoDeInteresse> pontos);
	public double calculaTempoMedio(List<PontoDeInteresse> pontos);
	public String formataTransporte();
	public List<String> listarPontosDeInteresse(List<PontoDeInteresse> pontos);  
	
}
