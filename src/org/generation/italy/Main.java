package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Scrivere un programma che simula la vendita di prodotti di un negozio.

PARTE 1:

All'avvio del programma, chiedere quanti prodotti sono in vendita nel negozio, e successivamente far inserire per ogni prodotto:

nome (String)
prezzo (double)
quantità disponibile (int)
(utilizzare 3 array per memorizzare queste informazioni)

PARTE 2:

Chiedere all'utente il nome del prodotto da acquistare (si può indicare anche una parte del nome) e, se il prodotto esiste chiedere anche la quantità da acquistare.

Se il prodotto esiste e la quantità disponibile è sufficiente l'acquisto va a buon fine, in questo caso aggiornare la quantità disponibile nel negozio.

Se il prodotto non esiste, oppure se la quantità disponibile non è sufficiente, mostrare un messaggio.

Dopo ogni acquisto, chiedere se si vuole acquistare un altro prodotto.
Al termine mostrare l'importo totale da pagare
		 */
		
		Scanner sc=new Scanner(System.in);
		int numberProduct;

		System.out.println("Inserisci il numero di prodotti in vendita: ");
		numberProduct = sc.nextInt();
		sc.nextLine();
		String nomi []=new String[numberProduct];
		double prezzi []=new double[numberProduct];
		double quantita []=new double[numberProduct];
		int nProdottoScelto;		//numero del prodotto scelto dal utente quando la stringa 
									//inserita per la ricera del prodotto da piu di un risultato
		int quantitaScelta;			//quantita scelta dal utente per l'acquisto
		int unicoProdottoTrovato=0;
		for (int i=0;i<numberProduct;i++) {
			System.out.print("Insirisci il nome prodotto numero "+ (i+1) + ":");
			nomi[i]=sc.nextLine();
			System.out.print("Insirisci il prezzo: ");

			prezzi[i]=sc.nextDouble();
			sc.nextLine();
			System.out.print("Insirisci la quantitá: ");

			quantita[i]=sc.nextDouble();
			sc.nextLine();		
		}
		
		
		String prodottoUtente;
			
		String risposta;
		do {
				
			boolean trovato=false;
			
			int nProdottiTrovati=0;		//quantitá prodotti contenenti la stessa sigla
			System.out.println("Cerca un prodotto da acquistare:");
			prodottoUtente=sc.nextLine();
			//sapere quanti prodotti contengono lastessa parte di striga scritta nella ricerca
			for(int i=0;i<numberProduct;i++) {
				if(nomi[i].toLowerCase().indexOf(prodottoUtente.toLowerCase())>=0) {
					trovato=true;
					nProdottiTrovati++;
					unicoProdottoTrovato=i;
					
					

				}
			}
			//Caso in cui piu di un articolo contiene la stessa stringa inserita
			if(nProdottiTrovati>1) {					
				int[] prodottiTrovati=new int[nProdottiTrovati];		//stringa che contiene le posizioni dei prodotti 
																		//trovati
				
				nProdottiTrovati=0;					
				for(int i=0;i<numberProduct;i++) {
					if(nomi[i].toLowerCase().indexOf(prodottoUtente.toLowerCase())>=0) {
						prodottiTrovati[nProdottiTrovati]=i;	///inserisce nel array prodotti trovati 
																//gli indici dei prodotti trovato
						
						nProdottiTrovati++;				//questo aqumentasolo quando trova un articolo
															//corrisponde alla stringa inserita
						System.out.print("Prodotto numero " + nProdottiTrovati +" : ");
						System.out.println(nomi[i]);
						
						System.out.print("Prezzo: ");
						System.out.println(prezzi[i]);

						System.out.print("Quantitá disponibile: ");
						System.out.println(quantita[i] + "\n");
					}			
				}
				
				System.out.print("Scrivi il numero del prodotto corrispondente: ");
				nProdottoScelto= sc.nextInt();
				sc.nextLine();
				boolean disponibilita=true;
				do {
					
					if(quantita[prodottiTrovati[(nProdottoScelto-1)]]>0) {
						System.out.println("Scrivi la quantitá: ");
						quantitaScelta=sc.nextInt();
						sc.nextLine();
						if(quantita[prodottiTrovati[(nProdottoScelto-1)]]>=quantitaScelta) {
							disponibilita=true;				//true cosi si esce dal ciclo while se la quantita é disponibile
							System.out.println("La quantitá richiesta é disponobile.. ");
							System.out.println("Prezzo totale é :" + (prezzi[prodottiTrovati[(nProdottoScelto-1)]]*quantitaScelta));
							quantita[prodottiTrovati[(nProdottoScelto-1)]]-=quantitaScelta; 		//aggiornamento quantitá disponibile
							System.out.println("Quantita aggiornata: " + quantita[prodottiTrovati[(nProdottoScelto-1)]]);   
						}else {
							System.out.println("La quantitá richiesta non é disponibile..!");	//se la quantitá scelta dal utente va oltre la disponibilitá
							disponibilita=false;
						}
					}else {
						disponibilita=true;							//se il prodotto é esaurito esci dal ciclo while
																	//e chiedi di nuovo quale acticolo vuoi scegliere
						System.out.println("Prodotto esaurito..");
					}
				}while(disponibilita==false);			//se la quantita non é disponibile 
															//richiede di nuovo la Quantitá
				
			}else if (nProdottiTrovati==1) {			//se disponibile un solo articolo contenente la stessa stringa
		
				
				System.out.print("Unico prodotto trovato: ");
				System.out.println(nomi[unicoProdottoTrovato]);
				
				System.out.print("Prezzo: ");
				System.out.println(prezzi[unicoProdottoTrovato]);

				System.out.println("La quantitá richiesta é disponibile..!");
				
				System.out.println(quantita[unicoProdottoTrovato] + "\n");
				boolean disponibilita;
				do {

					
					if(quantita[unicoProdottoTrovato]>0) {
						System.out.println("Scrivi la quantitá: ");
						quantitaScelta=sc.nextInt();
						sc.nextLine();
						if(quantita[unicoProdottoTrovato]>=quantitaScelta) {
							disponibilita=true;
		
							System.out.println("La quantitá richiesta é disponibile: ");
		
							quantita[unicoProdottoTrovato]-=quantitaScelta;
							System.out.println("Prezzo totale: "+prezzi[unicoProdottoTrovato]*quantitaScelta);
							System.out.println("Quantita aggiornata: " + quantita[unicoProdottoTrovato]);
						}else {
							System.out.print("La quantitá richiesta non é disponibile.");//se la quantitá scelta dal utente va oltre la disponibilitá
							disponibilita=false;
						}
					}else {
						disponibilita=true;						//se il prodotto é esaurito esci dal ciclo while
																//e chiedi di nuovo quale acticolo vuoi scegliere
						System.out.println("Prodotto esaurito..");
					}
				}while(disponibilita==false);	
			}else
				System.out.println("Prodotto non trovato...");

			System.out.println("vuoi aquistare un altro prodotto?");
			risposta=sc.nextLine();
			
		}while(risposta.equalsIgnoreCase("s"));
			
	}
		
}


