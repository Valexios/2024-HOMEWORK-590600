package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsatest {

	 Attrezzo A= null; 
	 Attrezzo B= new Attrezzo("aa",1);
	 Attrezzo a= new Attrezzo("a",9);
	 Attrezzo b= new Attrezzo("a",2);
	 Attrezzo c= new Attrezzo("a",3);
	 Borsa BO= new Borsa(10);
	 
	    @Test 
		public void addattrezzonull() {
	    	assertFalse(BO.addAttrezzo(A));
		}
	 
		@Test
		public void addattrezzoesist() {
			assertTrue(BO.addAttrezzo(B));
		}
		@Test
		public void addattrezzotroppo() {
			BO.addAttrezzo(a);
			assertFalse(BO.addAttrezzo(b));
		}
		
		@Test
		public void removeattrezzonull() {
			assertEquals(null,BO.removeAttrezzo(null));
		}
		@Test
		public void removeattrezzodoppio() {
			BO.addAttrezzo(b);
			BO.addAttrezzo(c);
			assertEquals(b,BO.removeAttrezzo(b.getNome()));
			assertEquals(c,BO.removeAttrezzo(c.getNome()));
		}
		@Test
		public void removeattrezzoesistente() {
			BO.addAttrezzo(B);
			assertEquals(B,BO.removeAttrezzo(B.getNome()));
		}
		@Test
		public void removeattrezzononesiste() {
			BO.addAttrezzo(B);
			assertEquals(null,BO.removeAttrezzo(b.getNome()));
		}

}
