package test;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Labirinto;
import org.junit.Test;

public class LabirintoTest {
	
	Labirinto L = new Labirinto();
	@Test
	public void GetStanzaVincente() {
		assertEquals("Biblioteca", L.getStanzaVincente().getNome());
	}
	
	@Test
	public void GetStanzaIniziale() {
		assertEquals("Atrio", L.getStanzaIniziale().getNome());
	}

}
