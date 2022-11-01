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

//Pre: Demanar a l'usuari introduir un seguit de nombres 

public class Ap2Ex9 {


   
    private static final String MSG_1 = "Introdueix un seguit de nombres  per no introduir més posa 0"; 
    private static final String MSG_2 = "La mitjana dels nombres és: "; 
    
    public static void main(String[] args) {
        int suma = 0;
        int count=0;
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println(MSG_1);
        do{
            n= sc.nextInt();
            suma += n;
            count++;    
        }while(n!=0);
        System.out.println(MSG_2+(suma/(count-1)));
    }
    
}
//Post: Retornar la mitjana dels nombres introduits