package com.example.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataManager {
	private Connection connection;

	public void connect() {
    	try {
                //Posem el port per on surt el usuari del nostre postgre i la contrasenya del usuari, també a la base de dades on ens conectem
        	connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/cine", "postgres", "yqkb0219");
        	System.out.println("Connexio establerta");
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}

	//Per fer un insert i afegir un director amb els seus atributs
	public void afegirDirector(String nom, String cognom) {
    	String query = "INSERT INTO Director (nom, cognom) VALUES (?, ?)";
    	try {
        	PreparedStatement stmt = connection.prepareStatement(query);
        	stmt.setString(1, nom);
        	stmt.setString(2, cognom);
        	stmt.executeUpdate();
        	System.out.println("Director afegit correctament");
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}

	//Per fer un insert i afegir un llibre amb els seus atributs
	public void afegirDirector(String titol, String anyPublicacio, int directorId) {
    	String query = "INSERT INTO Pelicula (titol, anyPublicacio, directorId) VALUES (?, ?, ?)";
    	try {
        	PreparedStatement stmt = connection.prepareStatement(query);
        	stmt.setString(1, titol);
        	stmt.setString(2, anyPublicacio);
        	stmt.setInt(3, directorId);
        	stmt.executeUpdate();
        	System.out.println("Llibre afegit correctament");
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}

	//Per fer un select i mostrar una pelicula del director amb els seus atributs
	public void peliculesDirector(int directorId) {
    	String query = "SELECT Pelicula.titol, Pelicula.anyPublicacio FROM Pelicula WHERE directorId = ?";
    	try {
        	PreparedStatement stmt = connection.prepareStatement(query);
        	stmt.setInt(1, directorId);
        	ResultSet rs = stmt.executeQuery();
        	while (rs.next()) {
            	System.out.println("Pelicula del director");
            	System.out.println("Titol: " + rs.getString("titol") + ", Any de Publicacio: " + rs.getString("anyPublicacio"));
        	}
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}
    
	//Metode unicament per mostrar les dades del director
	public void mostrarDirector() {
    	String query = "SELECT id, nom, cognom FROM Director";
    	try {
        	PreparedStatement stmt = connection.prepareStatement(query);
        	ResultSet rs = stmt.executeQuery();
        	while (rs.next()) {
            	System.out.println("Dades del director");
            	System.out.println("ID: " + rs.getInt("id") + ", Nom: " + rs.getString("nom") + ", Cognom: " + rs.getString("cognom"));
        	}
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}
    
	//Metode per desconectarnos del servidor
	public void desconexio() {
    	try {
        	if (connection != null && !connection.isClosed()) {
            	connection.close();
            	System.out.println("Connexio tancada");
        	}
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}
}
