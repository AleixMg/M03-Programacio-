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
                //Posem el port per on surt,el usuari del nostre postgre,i la contrasenya, també posem la base de dades a la qual ens conectem
        	connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/llibres", "postgres", "yqkb0219");
        	System.out.println("Connexio establerta");
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}


	//Per fer un insert i afegir un llibre amb els seus atributs
	public void afegirLlibre(String titol, String autor , int anyPublicacio ) {
    	String query = "INSERT INTO Llibre (titol, autor, anyPublicacio) VALUES (?, ?, ?)";
    	try {
        	PreparedStatement stmt = connection.prepareStatement(query);
        	stmt.setString(1, titol);
        	stmt.setString(2, autor );
        	stmt.setInt(3, anyPublicacio);
        	stmt.executeUpdate();
        	System.out.println("Llibre afegit");
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}

	//Per fer un select i mostrar tots els llibres amb els seus atributs
        public void mostrarLlibres() {
        String consulta = "SELECT * FROM Llibre";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Titol: " + rs.getString("titol") + ", Autor: " + rs.getString("autor") + ", Any de Publicacio: " + rs.getInt("anyPublicacio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    //Per modificar els atribust d'un llibre 
    public void modificarLlibre(int id, String titol, String autor, int anyPublicacio) {
        String consulta = "UPDATE Llibre SET titol = ?, autor = ?, anyPublicacio = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, titol);
            stmt.setString(2, autor);
            stmt.setInt(3, anyPublicacio);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Llibre actualitzat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Per eliminar un llibre especific que escollirem amb la seva id 
    public void eliminarLlibre(int id) {
        String consulta = "DELETE FROM Llibre WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Llibre eliminat");
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
