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

//Pre: Demanar a l'usuari un any

public class Ap2Ex5 {


    
    private static final String MSG_1 = " Introdueix un any ";
    private static final String MSG_2 = " Aquest any és de traspàs ";
    private static final String MSG_3 = " Aquest any no és de traspàs ";
    
    public static void main(String[] args) {
        int n;
        System.out.println(MSG_1);
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        if ((n%4==0)&&(n%100 != 0)||(n%400 == 0)){
            System.out.println(MSG_2);
        }else{
            System.out.println(MSG_3);
        }
    }
    
}
//Post: Retornar si l'any és de traspàs o no 