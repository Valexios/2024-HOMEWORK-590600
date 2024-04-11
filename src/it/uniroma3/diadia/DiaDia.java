package it.uniroma3.diadia;


import it.uniroma3.diadia.ambienti.Stanza;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","borsa"};

	private Partita partita;
	private IOConsole IOConsole;

	public DiaDia() {
		this.partita = new Partita();
		this.IOConsole = new IOConsole();
	}

	public void gioca() {
		String istruzione; 

		IOConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione=IOConsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto")
			   ||comandoDaEseguire.getNome().equals("info"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("borsa"))
			this.borsa();
		else
			IOConsole.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			IOConsole.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   
	

	// implementazioni dei comandi dell'utente:
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		StringBuilder aiuto = new StringBuilder();
		for(int i=0; i< elencoComandi.length; i++) 
			aiuto.append(elencoComandi[i]+" ");
		IOConsole.mostraMessaggio(aiuto.toString());
	}

	/**
	 * cerca di prendere un oggetto
	 */
	//non adattato
	private void prendi(String attrezzocanc) {
		boolean succ=false;
		if(partita.getStanzaCorrente().getnumAttrezzi()==0)
			IOConsole.mostraMessaggio("non ci sono oggetti da prendere");
		else {
			succ=partita.getGiocatore().getBorsa().addAttrezzo
					(partita.getStanzaCorrente().removeAttrezzo(attrezzocanc));
			if(succ) 
				IOConsole.mostraMessaggio("hai preso "+ attrezzocanc);
			else
				IOConsole.mostraMessaggio("non hai preso nulla");
			}
	}
	
	private void posa(String attrezzolancia) {
		boolean succ=false;
		if(partita.getGiocatore().getBorsa().isEmpty())
			IOConsole.mostraMessaggio("non ci sono oggetti da posare");
		else {
			succ=partita.getStanzaCorrente().addAttrezzo
					(partita.getGiocatore().getBorsa().removeAttrezzo(attrezzolancia));
			if(succ) 
				IOConsole.mostraMessaggio("hai posato "+ attrezzolancia);
			else
				IOConsole.mostraMessaggio("non hai posato nulla");
			}
	}
	/*
	 * 
	 * */
	//creare classe inventario/personaggio
	private void borsa() {
		IOConsole.mostraMessaggio(partita.getGiocatore().getBorsa().toString()+"\n");
	}
	private void vai(String direzione) {
		if(direzione==null)
			IOConsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			IOConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		IOConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		IOConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}