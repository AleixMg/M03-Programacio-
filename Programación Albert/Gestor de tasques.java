package taskmanagement;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

class Tasca {
	// Anem a declarar cada variable del personatge.
	//<editor-fold defaultstate="collapsed" desc="Atributs">
	private static int cont = 0;
	private int id;
	private String descripcio;
	private boolean tasca_completada;
	private String prioritat;
	//</editor-fold>
	
	//Fem un constructor de la classe i inicialitzem les varibles d'instacia.
  	//<editor-fold defaultstate="collapsed" desc="Constructor Tasca">
	public Tasca(String descripcio, String prioritat) {
	//al contador li fiquem un autoincrement per a que autoincrementi la id de forma sola
    	this.id = ++cont;
    	this.descripcio = descripcio;
    	this.tasca_completada = false;
    	this.prioritat = prioritat;
	}
	//</editor-fold>

 	//Farem uns metodes d'accés a les varibles de la tasca amb els getters. 
	//<editor-fold defaultstate="collapsed" desc="Getters">
	public void marcarTascaCompletada() {
    	this.tasca_completada = true;
	}

	public int getID() {
    	return this.id;
	}

	public String getDescripcio() {
    	return this.descripcio;
	}

	public boolean estaCompletada() {
    	return this.tasca_completada;
	}

	public String getPrioritat() {
    	return this.prioritat;
	}

	//Fem un toString per convertir la informació en una cadena de text, ho seprearem amb tabulacions i dos |.
	@Override
	public String toString() {
    	String estat_tasca = tasca_completada ? "Completada" : "Pendent";
    	return "ID: " + id + "\t||Descripcio: " + descripcio + "\t||Prioritat: " + prioritat + "\t||Estat: " + estat_tasca;
	}
	//</editor-fold>
}

//Declarem la nova clase per gestionar les tasques
class GestorTasques {
	
	private static final String MSG_1 = "baixa";
	private static final String MSG_2 = "mitjana";
	private static final String MSG_3 = "alta";
	private HashMap<String, ArrayList<Tasca>> llistaPrioritat;
	private HashMap<Integer, Tasca> tasques;
	private Scanner scanner;

	public GestorTasques() {
    		llistaPrioritat = new HashMap<>();
    		llistaPrioritat.put(MSG_1, new ArrayList<>());
    		llistaPrioritat.put(MSG_2, new ArrayList<>());
    		llistaPrioritat.put(MSG_3, new ArrayList<>());
    		tasques = new HashMap<>();
    		scanner = new Scanner(System.in);
	}
	
	//Metode per afegir la tasca a partir de la ID que digui el usuari que vulgui modificar 
	public void afegirTasca(String descripcio, String prioritat) {
    		Tasca tasca = new Tasca(descripcio, prioritat);
    		llistaPrioritat.get(prioritat).add(tasca);
    		tasques.put(tasca.getID(), tasca);
	}

	//Metode per marcar la tasca a partir de la ID que digui el usuari que vulgui modificar
	public void marcarTascaCompletada(int idTasca) {
    		Tasca tasca = tasques.get(idTasca);
		if (tasca != null) {
      			tasca.marcarTascaCompletada();
    		}	
	}

	//Metode per esborrar la tasca a partir de la ID que digui el usuari que vulgui modificar
	public void esborrarTasca(int idTasca) {
    		Tasca tasca = tasques.remove(idTasca);
    		if (tasca != null) {
        		String prioritat = tasca.getPrioritat();
        		llistaPrioritat.get(prioritat).remove(tasca);
    		}
	}
	//Metode per afegir la tasca 
	public void mostrarTotesLesTasques() {
    	System.out.println("Totes les tasques:");
    		for (Tasca tasca : tasques.values()) {
        		System.out.println(tasca);
    		}
	}
	
	//Metode per afegir la tasca per ordre de prioritat
	public void mostrarTasquesPerPrioritat(String prioritat) {
    	System.out.println("Tasques de prioritat " + prioritat + ":");
    		for (Tasca tasca : llistaPrioritat.get(prioritat)) {
        		System.out.println(tasca);
    		}
	}
	
	//metode per sortir del programa 
	public void sortir() {
    		scanner.close();
    		System.exit(0);
	}
}


