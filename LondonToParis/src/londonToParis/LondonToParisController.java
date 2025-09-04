package londonToParis;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LondonToParisController {
	
	private Map<Integer, Rota> rotas;
	
	public LondonToParisController() {
		this.rotas = new HashMap<>();
	}
	
	public int cadastrarRota(String origem, String destino, double distancia) {
		verificaRota(origem, destino);
		
		int id = this.rotas.size();
		this.rotas.put(id, new Rota(origem, destino, distancia, id));
		
		return id + 1;
	}
	
	public void cadastraPontoDeInteresseEmRota(int idRota, String tipo, String descricao, double tempoMedio) {
		verificaRota(idRota);
		
		Rota rota = getRota(idRota);
		
		rota.cadastraPontoInteresse(tipo, descricao, tempoMedio);
	}
	
	public String mostrarRota(int idRota) {
		return getRota(idRota).toString();
	}
	
	public String[] mostrarRotas() {
		ArrayList<String> rotas = new ArrayList<>();
		
		for (Rota r : this.rotas.values()) {
			rotas.add(r.toString());
		}
		
		return emArray(rotas);
	}
	
	public void atribuirCarroRota(int idRota, String rodovia) {
		verificaRota(idRota);
		
		getRota(idRota).setTransporte(new Carro(rodovia));
	}
	
	public void atribuirBicicletaRota(int idRota, String tipoTerreno, int pernoites) {
		verificaRota(idRota);
		
		getRota(idRota).setTransporte(new Bicicleta(tipoTerreno, pernoites));
	}
	
	public void atribuirTremRota(int idRota, String numTrem, double valorPassagem) {
		verificaRota(idRota);
		
		getRota(idRota).setTransporte(new Trem(numTrem, valorPassagem));
	}
	
	public double mostrarDistanciaPercorrida(int idRota) {
		verificaRota(idRota);
		
		return getRota(idRota).mostrarDistanciaPercorrida();
	}
	
	public double mostrarTempoGasto(int idRota) {
		verificaRota(idRota);
		
		return getRota(idRota).mostrarTempoGasto();
	}
	 
	private String[] emArray(List<String> rotas) {
		String[] out = new String[rotas.size()];
		int idxOut = 0;
		
		for (String rota : rotas) {
			out[idxOut++] = rota;
		}
		
		return out;
	}
	
	private void verificaRota(int idRota) {
		if (!temRota(idRota)) throw new IllegalArgumentException("Rota já existe");
	}
	
	private boolean temRota(int idRota) {
		return this.rotas.containsKey(idRota);
	}

	private void verificaRota(String origem, String destino) {
		if (temRota(origem, destino)) throw new IllegalArgumentException("Rota já existe");
	}

	private boolean temRota(String origem, String destino) {
		Rota lilRota = new Rota(origem, destino, 0, 0);
		for (Rota r : this.rotas.values()) {
			if (r.equals(lilRota)) {
				return true;
			}
		}
		return false;
	}
	
	private Rota getRota(int idRota) {
		return this.rotas.get(idRota);
	}
}
