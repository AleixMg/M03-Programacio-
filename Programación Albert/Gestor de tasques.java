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

