/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 *
 * Nom:Aleix
 * Cognoms: Muñoz Gálvez
 * INS Manuel Vázquez Montalbán
 * Data edició: 26/10/2022
 * Nom de cicle formatiu: Administració de sistemes informàtics en xarxa 
 * Nom mòdul: M03 Programació 
 */
package cat.institumvm;

import java.util.Scanner;

//Pre: Demanar a l'usuari un número

public class Ap2Ex4 {
    

    
    private static final String MSG_1 = " Introdueix un número per saber el més de l'any (fet amb if)";
    private static final String MSG_3 = " Introdueix un número per saber el més de l'any (fet amb switch-case)";
    private static final String MSG_2 = " ERROR ";
    private static final String MSG_5 ="Gener";
    private static final String MSG_6 ="Febrer";
    private static final String MSG_7 ="Març";
    private static final String MSG_8 ="Abril";
    private static final String MSG_9 ="Maig";
    private static final String MSG_10 ="Juny";
    private static final String MSG_11="Juliol";
    private static final String MSG_12="Agost";
    private static final String MSG_13 ="Sepetembre";
    private static final String MSG_14 ="Octubre";
    private static final String MSG_15 ="Novembre";
    private static final String MSG_16 ="Decembre";
    
    
    public static void main(String[] args) {
        
        // a) amb if  
        int n1;
        System.out.println(MSG_1);
        Scanner sc = new Scanner(System.in);
        n1= sc.nextInt();
        if(n1==1){
            System.out.println(MSG_5);
        }
         if(n1==2){
            System.out.println(MSG_6);
        }
         if(n1==3){
            System.out.println(MSG_7);
        }
         if(n1==4){
            System.out.println(MSG_8);
        }
         if(n1==5){
            System.out.println(MSG_9);
        }
         if(n1==6){
            System.out.println(MSG_10);
        }
         if(n1==7){
            System.out.println(MSG_11);
        }
         if(n1==8){
            System.out.println(MSG_12);
        }
         if(n1==9){
            System.out.println(MSG_13);
        }
         if(n1==10){
            System.out.println(MSG_14);
        }
         if(n1==11){
            System.out.println(MSG_15);
        }
         if(n1==12){
            System.out.println(MSG_16);
        }
        if((n1<=0)||(n1>12)){
            System.out.println(MSG_2);
        }
       
        // b) amb switch-case 
        int n2;
        System.out.println(MSG_3);
        n2 = sc.nextInt();
        switch (n2){
        case 1:
               System.out.println(MSG_5);
               break;
        case 2:
               System.out.println(MSG_6);
               break;
        case 3:
               System.out.println(MSG_7);
               break;
        case 4:
               System.out.println(MSG_8);
               break;
        case 5:
               System.out.println(MSG_9);
               break;
        case 6:
               System.out.println(MSG_10);
               break;
        case 7:
               System.out.println(MSG_11);
               break;
        case 8:
               System.out.println(MSG_12);
               break;
        case 9: 
               System.out.println(MSG_13);
               break;
        case 10:
               System.out.println(MSG_14);
               break;
        case 11:
               System.out.println(MSG_15);
               break;
        case 12:
               System.out.println(MSG_16);
               break;
        default:
               System.out.println(MSG_2);
        
        }
    }
    
}
//Post: Retornar el més del any equivalent al número escrit 