package com.example.database;
import java.util.Scanner;



   	 
public class Main {
    
	private static final String MSG_1 = "********Llibreria********";
	private static final String MSG_2 = "1.Afegeix un  autor";
	private static final String MSG_3 = "2.Afegieix un llibre";
	private static final String MSG_4 = "3.Mostrar tots els llibres d'un autor";
	private static final String MSG_5 = "4.Mostrar tots el autors";
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
                	System.out.print("Introdueix el nom de l'autor del llibre: ");
                	String nom = scanner.next();
                	System.out.print("Introdueix el cognom de l'autor del llibre: ");
                	String cognom = scanner.next();
                	dbManager.afegirAutor(nom, cognom);
            	}
            	case 2 -> {
                	System.out.print("Introdueix el titol del llibre: ");
                	String titol = scanner.next();
                	System.out.print("Introdueix l'any de publicacio del llibre: ");
                	String anyPublicacio = scanner.next();
                	//li preguntem la id del autor de qui ha escrit el llibre
                	System.out.print("Introdueix l'ID de l'autor que ha escrit el llibre: ");
                	int autorId = scanner.nextInt();
                	dbManager.afegirLlibre(titol, anyPublicacio, autorId);
            	}
            	case 3 -> {
                	//li preguntem la id del autor de qui ha escrit el llibre
                	System.out.print("Introdueix l'ID de l'autor: ");
                	int autorIdLlibre = scanner.nextInt();
                	dbManager.llibresAutor(autorIdLlibre);
            	}
            	case 4 -> dbManager.mostrarAutor();
            	case 5 -> continuar = false;
            	default -> System.out.println("Opcio no valida, introdueix un número valid");
        	}
    	}

    	dbManager.desconexio();
    	scanner.close();
	}
}
