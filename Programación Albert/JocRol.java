//Vaig comecar-ho un dia abans i el codi esta mig fet en catala i castella
package jocrol;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

 class Personaje {
         
    // Anem a declarar cada variable del personatge.
    //<editor-fold defaultstate="collapsed" desc="Atributs">
    private String nom, arma, armadura;
    private int nivell;
    private int puntsVida;
    private int puntsMana;
    //</editor-fold>
