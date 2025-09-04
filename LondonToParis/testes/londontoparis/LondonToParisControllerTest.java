package londontoparis;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import londontoparis.LondonToParisController;
import londontoparis.exception.LondonToParisException;

class LondonToParisControllerTest {
	
	private LondonToParisController ltpc;
	
	@BeforeEach
	void prepara() {
		this.ltpc = new LondonToParisController();
	}
	
	@Test
	void testCadastrarRota() {
		assertEquals(1, ltpc.cadastrarRota("aqui", "ali", 50));
	}
	
	@Test
	void testCadastrarRotaOrigemVazia() {
		try {
			ltpc.cadastrarRota("", "ali", 50);
			fail("Espera-se uma exceção");
		} catch (LondonToParisException ltpce) {	
			assertEquals("Parametro nulo", ltpce.getMessage());
		}
	}
	
	@Test
	void testCadastrarRotaOrigemNula() {
		try {
			ltpc.cadastrarRota(null, "ali", 50);
			fail("Espera-se uma exceção");
		} catch (LondonToParisException ltpce) {	
			assertEquals("Parametro nulo", ltpce.getMessage());
		}
	}

}
