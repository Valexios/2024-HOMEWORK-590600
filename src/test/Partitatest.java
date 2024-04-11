package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class Partitatest {
	
	Partita P = new Partita();
	
	@Test
	public void getStanzaCorrente() {
		assertEquals("Atrio", P.getStanzaCorrente().getNome());
	}
	
	@Test
	public void vintafalso() {
		assertFalse(P.vinta());
	}
	
}
