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
                //Posem el port per on surt el usuari del nostre postgre i la contrasenya
        	connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/llibreria", "postgres", "yqkb0219");
        	System.out.println("Connexio establerta");
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}

	//Per fer un insert i afegir un autor amn els seus atributs
	public void afegirAutor(String nom, String cognom) {
    	String query = "INSERT INTO Autor (nom, cognom) VALUES (?, ?)";
    	try {
        	PreparedStatement stmt = connection.prepareStatement(query);
        	stmt.setString(1, nom);
        	stmt.setString(2, cognom);
        	stmt.executeUpdate();
        	System.out.println("Autor afegit");
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}

	//Per fer un insert i afegir un llibre amb els seus atributs
	public void afegirLlibre(String titol, String anyPublicacio, int autorId) {
    	String query = "INSERT INTO Llibre (titol, anyPublicacio, autorId) VALUES (?, ?, ?)";
    	try {
        	PreparedStatement stmt = connection.prepareStatement(query);
        	stmt.setString(1, titol);
        	stmt.setString(2, anyPublicacio);
        	stmt.setInt(3, autorId);
        	stmt.executeUpdate();
        	System.out.println("Llibre afegit");
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}

	//Per fer un select i mostrar un llibre del autor amb els seus atributs
	public void llibresAutor(int autorId) {
    	String query = "SELECT Llibre.titol, Llibre.anyPublicacio FROM Llibre WHERE autorId = ?";
    	try {
        	PreparedStatement stmt = connection.prepareStatement(query);
        	stmt.setInt(1, autorId);
        	ResultSet rs = stmt.executeQuery();
        	while (rs.next()) {
            	System.out.println("Llibre del autor");
            	System.out.println("Titol: " + rs.getString("titol") + ", Any de Publicacio: " + rs.getString("anyPublicacio"));
        	}
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}
    
	//Metode unicament per mostrar l'autor
	public void mostrarAutor() {
    	String query = "SELECT id, nom, cognom FROM Autor";
    	try {
        	PreparedStatement stmt = connection.prepareStatement(query);
        	ResultSet rs = stmt.executeQuery();
        	while (rs.next()) {
            	System.out.println("Dades del autor");
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
