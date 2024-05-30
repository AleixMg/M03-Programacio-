package com.example.database;
import java.util.Scanner;



   	 
public class Main {
    
	private static final String MSG_1 = "********Cinema********";
	private static final String MSG_2 = "1.Afegeix un director";
	private static final String MSG_3 = "2.Afegieix una pelicula";
	private static final String MSG_4 = "3.Mostrar totes les pelicules d'un director";
	private static final String MSG_5 = "4.Mostrar tots els directors";
	private static final String MSG_6 = "5.Sortim del programa";
	private static final String MSG_7 = "Selecciona una opcio: ";
	 
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	DataManager dbManager = new DataManager();

    	dbManager.connect();

    	boolean continuar = true;
    	while (continuar) {
        	System.out.println(MSG_1);
        	System.out.println(MSG_2);
        	System.out.println(MSG_3);
        	System.out.println(MSG_4);
        	System.out.println(MSG_5);
        	System.out.println(MSG_6);
        	System.out.println(MSG_1);
        	System.out.print(MSG_7);
        	//Variable per escollir les opcions
        	int opcio = scanner.nextInt();
       	 
        	//amb un switch case l'usuari escollira les opcions i cridarem al metode corresponent que hem fet
        	switch (opcio) {
            	case 1 -> {
                	System.out.print("Introdueix el nom del director de la pelicula: ");
                	String nom = scanner.next();
                	System.out.print("Introdueix el cognom del director de la pelicula: ");
                	String cognom = scanner.next();
                	dbManager.afegirDirector(nom, cognom);
            	}
            	case 2 -> {
                	System.out.print("Introdueix el titol de la pelicula: ");
                	String titol = scanner.next();
                	System.out.print("Introdueix l'any de publicacio de la pelicula: ");
                	String anyPublicacio = scanner.next();
                	//li preguntem la id del director de qui ha dirigit la pelicula
                	System.out.print("Introdueix l'ID del director que ha dirigit la pelicula: ");
                	int directorId = scanner.nextInt();
                	dbManager.afegirDirector(titol, anyPublicacio, directorId);
            	}
            	case 3 -> {
                	//li preguntem la id del director de qui ha dirigit la pelicula
                	System.out.print("Introdueix l'ID del director: ");
                	int directorIdLlibre = scanner.nextInt();
                	dbManager.peliculesDirector(directorIdLlibre);
            	}
            	case 4 -> dbManager.mostrarDirector();
            	case 5 -> continuar = false;
            	default -> System.out.println("Opcio no valida, introdueix un número valid");
        	}
    	}

    	dbManager.desconexio();
    	scanner.close();
	}
}
