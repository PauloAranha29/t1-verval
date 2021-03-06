//package VerValT1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class teste {

	private ScoresBuggedImpl scores = new ScoresBuggedImpl();	
	
	@Before
	public void limpaScores() {
		for(int i=0; i<5; i++) {
			scores.entries[i] = null;
		}
		assertEquals("Deve ter 0 elementos: ", 0, scores.getNumElements());
	}
	
	@Test
	public void testeAdd() {
		
		assertEquals("Deve ter 0 elementos: ", 0, scores.getNumElements());
		
		GameEntry john = new GameEntry("John", 10);
		assertEquals("Deve inserir na lista: ", true, scores.add(john));
		assertEquals("Deve ter 1 elemento: ", 1, scores.getNumElements());
		
		GameEntry joao = new GameEntry("Joao", 7);
		assertEquals("Deve inserir na lista: ", true, scores.add(joao));
		
		GameEntry laura = new GameEntry("Laura", 13);
		assertEquals("Deve inserir na lista: ", true, scores.add(laura));
		
		GameEntry carlos = new GameEntry("Carlos", 11);
		assertEquals("Deve inserir na lista: ", true, scores.add(carlos));
		
		GameEntry luiza = new GameEntry("Luiza", 11);
		assertEquals("Deve inserir na lista: ", true, scores.add(luiza));
		
		assertEquals("Deve ter 5 elementos (lista cheia): ", 5, scores.getNumElements());
		
		assertEquals("N�o deve inserir na lista: ", false, scores.add(new GameEntry("Gabriel", 2)));
		
		assertEquals("Deve ter 5 elementos (lista cheia): ", 5, scores.getNumElements());
		
		assertEquals("Deve inserir na lista: ", true, scores.add(new GameEntry("Carol", 55)));
		assertEquals("Deve ter 5 elementos (lista cheia): ", 5, scores.getNumElements());
	}
	
	@Test(expected = NullPointerException.class)
	public final void testeAdd2(){
		GameEntry aux = null;
		scores.add(aux);
	}
	
	@Test
	public void testeRemove() {
		
		GameEntry fernando = new GameEntry("Fernando", 10);	
		scores.add(fernando);
		assertEquals("Deve apagar da lista: ", fernando, scores.remove(0));
		
		GameEntry luiza = new GameEntry("Luiza", 10);
		scores.add(luiza);
		GameEntry joao = new GameEntry("Joao", 7);
		scores.add(joao);
		GameEntry laura = new GameEntry("Laura", 13);
		scores.add(laura);
		GameEntry carlos = new GameEntry("Carlos", 11);
		scores.add(carlos);
		GameEntry john = new GameEntry("John", 12);
		scores.add(john);
		
		assertEquals("Deve remover john da lista: ", john, scores.remove(1));
		assertEquals("Deve ter 0 elementos: ", 4, scores.getNumElements());
		assertEquals("Deve remover carlos da lista: ", carlos, scores.remove(1));
		assertEquals("Deve ter 0 elementos: ", 3, scores.getNumElements());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public final void testeRemove2(){
		scores.remove(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public final void testeRemove3(){
		scores.remove(5);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public final void testeRemove4(){
		scores.remove(4);
	}
	
	@Test
	public void testeNumElementos() {
		assertEquals("Deve ter 0 elementos: ", 0, scores.getNumElements());
		
		GameEntry john = new GameEntry("John", 10);
		scores.add(john);
		assertEquals("Deve ter 0 elementos: ", 1, scores.getNumElements());

		GameEntry carol = new GameEntry("Carol", 5);
		scores.add(carol);
		GameEntry dan = new GameEntry("Dan", 3);
		scores.add(dan);
		assertEquals("Deve ter 0 elementos: ", 3, scores.getNumElements());
		
		GameEntry paulo = new GameEntry("Paulo", 1);
		scores.add(paulo);
		GameEntry gesiel = new GameEntry("Gesiel", 15);
		scores.add(gesiel);
		GameEntry gabriel = new GameEntry("Gabriel", 1);
		scores.add(gabriel);
		assertEquals("Deve ter 0 elementos: ", 5, scores.getNumElements());

	}
	
	@Test
	public void testeCapacidade() {
		assertEquals("Deve retornar 5:", 5, scores.getCapacity());
	}
	
	@Test
	public void testeOrdem() {
		
		GameEntry luiza = new GameEntry("Luiza", 10);
		assertEquals("Deve inserir na lista: ", true, scores.add(luiza));
		GameEntry joao = new GameEntry("Joao", 7);
		assertEquals("Deve inserir na lista: ", true, scores.add(joao));
		GameEntry laura = new GameEntry("Laura", 13);
		assertEquals("Deve inserir na lista: ", true, scores.add(laura));
		GameEntry carlos = new GameEntry("Carlos", 11);
		assertEquals("Deve inserir na lista: ", true, scores.add(carlos));
		GameEntry john = new GameEntry("John", 12);
		assertEquals("Deve inserir na lista: ", true, scores.add(john));
		
		assertEquals("Deve remover laura da lista: ", laura, scores.remove(0));
		assertEquals("Deve remover john da lista: ", john, scores.remove(0));
		assertEquals("Deve remover carlos da lista: ", carlos, scores.remove(0));
		assertEquals("Deve remover luiza da lista: ", luiza, scores.remove(0));
		assertEquals("Deve remover joao da lista: ", joao, scores.remove(0));
	}
	

}
