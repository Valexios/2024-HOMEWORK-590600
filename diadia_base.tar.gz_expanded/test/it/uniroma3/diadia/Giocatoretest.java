package it.uniroma3.diadia;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNotNull;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class Giocatoretest {
	
	Giocatore G= new Giocatore();
	
	@Test
	public void getCfu() {
		assertEquals(20,G.getCfu());
	}
	@Test
	public void getBorsa() {
		assumeNotNull(G.getBorsa());
	}

}
