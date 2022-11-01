/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 * Nom:Aleix
 * Cognoms: Muñoz Gálvez
 * INS Manuel Vázquez Montalbán
 * Data edició: 26/10/2022
 * Nom de cicle formatiu: Administració de sistemes informàtics en xarxa 
 * Nom mòdul: M03 Programació 
 */
package cat.institutmvm;

import java.util.Scanner;

//Pre: Demanar a l'usuari introduir números 

public class Ap2Ex8 {


    
    private static final String MSG_1 = " Introdueix números enters amb el 0 parem d'introduir ";
    private static final String MSG_2 = " Digues quants números vols introduir ";
    private static final String MSG_3 = " Introdueix un número";
    private static final String MSG_4 = " Ja no pots introduir més números ";
    
    public static void main(String[] args) {
        
        // a) demanar números enters a l’usuari fins que aquest escrigui el número 0
        int n1;
        Scanner sc = new Scanner(System.in);
        System.out.println(MSG_1);
        n1=sc.nextInt();
        while (n1!=0){
            n1=sc.nextInt();            
        }
        
        // b) demanar números enters a l’usuari però fer que el primer número a demanar sigui el nombre de números que demanarà
        int i=0;
        int n2,n3;
        System.out.println(MSG_2);
        n2=sc.nextInt();
        while(i<n2){
            System.out.println(MSG_3);
            n3=sc.nextInt();
            i++;
        }
        System.out.println(MSG_4);
    }
    
}
//Post: Retonar els números introduits i fer que l'usuari pari quan posi 0(ex a) o quan es superi el número d'intents introduits per l'usuari(ex b) 