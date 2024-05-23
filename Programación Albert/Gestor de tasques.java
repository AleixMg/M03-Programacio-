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


