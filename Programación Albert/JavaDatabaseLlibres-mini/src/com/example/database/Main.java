package com.example.database;
import java.util.Scanner;



   	 
public class Main {
    
	private static final String MSG_1 = "********Llibreria********";
	private static final String MSG_2 = "1.Afegieix un llibre";
	private static final String MSG_3 = "2.Mostrar els llibres";
	private static final String MSG_4 = "3.Modificar un llibres ja existent";
	private static final String MSG_5 = "4.Eliminar un llibre";
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
                	System.out.print("Introdueix el titol del llibre: ");
                	String titol = scanner.next();
                	System.out.print("Introdueix l'any de publicacio del llibre: ");
                	int anyPublicacio = scanner.nextInt();
                	//li preguntem la id del autor de qui ha escrit el llibre
                	System.out.print("Introdueix el nom de l'autor que ha escrit el llibre: ");
                	String autor = scanner.next();
                	dbManager.afegirLlibre(titol,autor, anyPublicacio);
                }
            	case 2 -> {
                	dbManager.mostrarLlibres();
                }
            	case 3 -> {
                	//li preguntem la id del llibre que vol modificar
                	System.out.print("Introdueix l'ID del llibre que vols modificar: ");
                        int idLlibre = scanner.nextInt();
                        System.out.print("Introdueix el nou titol: ");
                        String nouTitol = scanner.next();
                        System.out.print("Introdueix el nou autor: ");
                        String nouAutor = scanner.next();
                        System.out.print("Introdueix el nou any de publicació: ");
                        int nouAnyPublicacio = scanner.nextInt();
                        dbManager.modificarLlibre(idLlibre, nouTitol, nouAutor, nouAnyPublicacio);
                }
            	case 4 ->{
                        //Fem que introdueixi la id del llibre que vol eliminar 
                        System.out.print("Introdueix l'ID del llibre que vols eliminar: ");
                        int idEliminar = scanner.nextInt();
                        dbManager.eliminarLlibre(idEliminar);
                }
            	case 5 -> continuar = false;
            	default -> System.out.println("Opcio no valida, introdueix un número valid");
        	}
    	}

    	dbManager.desconexio();
    	scanner.close();
	}
}
