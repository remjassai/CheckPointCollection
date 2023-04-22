ESERCIZIO
1) Scrivere un metodo processFile(String filename) che prende 
    in input un file di testo con indirizzo filename, legge le
    righe del file rimuovendo spazi all’inizio e alla fine delle
    righe e inserisce tali righe in una lista che poi verrà ritornata.
2) Scrivere un metodo processLines(List<String>) che prende in input
   una lista di righe e ritorna una mappa con chiavi String e valore Integer.
   Per ognuna delle righe:
   a) Se la riga è vuota, stampa un messaggio per informare l’utente
   e non fa nulla.
   b) Altrimenti divide la riga in parole (eliminando eventuale punteggiatura)
   ed eliminando eventuali parole duplicate inserisce nella mappa come chiave
   la parola e come valore il numero di vocali contenute in essa.
   ESEMPIO: se nel file di testo è contenuto
   “sopra la panca la capra campa”
   la mappa sarà: {‘sopra’: 2, ‘la’:1, ‘panca’: 2, ‘capra’: 2, ‘campa’: 2}
3) Scrivere un metodo writeResult(String filename, Map<String,Integer>)
   che scrive nel file con indirizzo filename la mappa nel formato
   “il numero di vocali in ” + parola ” è ” + numero_vocali
   Nell’esempio precedente nel file dovrà essere scritto:
   “il numero di vocali in sopra è 2” “il numero di vocali in la è 1” ecc.
