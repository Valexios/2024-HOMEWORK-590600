package test;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;
import org.junit.Test;

public class StanzaTest {
 Attrezzo A= null; 
 Attrezzo B= new Attrezzo("",1);
 Attrezzo C= new Attrezzo("abaco",5);
 Attrezzo a= new Attrezzo("",1);
 Attrezzo b= new Attrezzo("",1);
 Attrezzo c= new Attrezzo("",1);
 Attrezzo d= new Attrezzo("",1);
 Attrezzo e= new Attrezzo("",1);
 Attrezzo f= new Attrezzo("",1);
 Attrezzo g= new Attrezzo("",1);
 Attrezzo h= new Attrezzo("",1);
 Attrezzo i= new Attrezzo("",1);
 Attrezzo m= new Attrezzo("",1);
 Stanza S= new Stanza("");
 
	@Test
	public void removeattrezzonull() {
		assertEquals(null,S.removeAttrezzo(null));
	}
	@Test
	public void removeattrezzoesistente() {
		S.addAttrezzo(B);
		assertEquals(B,S.removeAttrezzo(B.getNome()));
	}
	@Test
	public void removeattrezzononesiste() {
		assertEquals(null,S.removeAttrezzo(C.getNome()));
	}
	@Test
	public void addattrezzonull(){
		assertFalse(S.addAttrezzo(null));
	}
	@Test 
	public void addattrezzi10null(){
	S.addAttrezzo(a);
	S.addAttrezzo(b);
	S.addAttrezzo(c);
	S.addAttrezzo(d);
	S.addAttrezzo(e);
	S.addAttrezzo(f);
	S.addAttrezzo(g);
	S.addAttrezzo(h);
	S.addAttrezzo(i);
	S.addAttrezzo(m);
		assertFalse(S.addAttrezzo(C));
	}
	@Test
	public void addattrezzodisp() {
		assertTrue(S.addAttrezzo(C));
	}
}
	