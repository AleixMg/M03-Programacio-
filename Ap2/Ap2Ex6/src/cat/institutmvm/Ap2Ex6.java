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

//Pre: Demanar a l'usuari un any i un mes

public class Ap2Ex6 {

    
       private static final String MSG_1 = "Introdueix un any i un mes (fet amb if else) ";
       private static final String MSG_5 = "Introdueix un any i un mes (fet amb switch-case) ";
       private static final String MSG_2 = "any=";
       private static final String MSG_3 = " ERROR";
       private static final String MSG_4 = " mes=";
        
       
       
       public static void main(String[] args) {
       
        //a) donat un any i un mes, dir quants dies té el més
        int any,mes,diesfeb,diesmesos;
        System.out.println(MSG_1);
        Scanner sc = new Scanner(System.in);
        any= sc.nextInt();
        mes= sc.nextInt();
        // per calcular si l'any és de traspás
        if ((any%4==0)&&(any%100 != 0)||(any%400 == 0)){
            diesfeb=29;
        }else{
            diesfeb=28;
        // per calcular els mesos amb 31 i 30 dies
        }
        if ((mes==1)||(mes==3)||(mes==5)||(mes==7)||(mes==8)||(mes==10)||(mes==12)){
            diesmesos=31;
            
        }else{
         
             diesmesos=30;  
        }
        //utilitzem el if else 
        if(mes==2){
            System.out.println(MSG_2+any+MSG_4+mes+" resultat="+diesfeb);
        }else{
             if((mes>0)&&(mes<=12)){
                    System.out.println(MSG_2+any+MSG_4+mes+" resultat="+ diesmesos);
             }else{
                    System.out.println(MSG_3);   
             }        
        }
        
        //b)fer l'apartatat amb switch-case però en aquest cas només pot tenir quatre sentències System.out.println() 
        int any2,mes2,diesfeb2,diesmesos2;
        System.out.println(MSG_5);
        any2= sc.nextInt();
        mes2= sc.nextInt();
        // per calcular si l'any és de traspás
        if ((any2%4==0)&&(any2%100 != 0)||(any2%400 == 0)){
            diesfeb2=29;
        }else{
            diesfeb2=28;
        // per calcular els mesos amb 31 i 30 dies
        }
        if ((mes2==1)||(mes2==3)||(mes2==5)||(mes2==7)||(mes2==8)||(mes2==10)||(mes2==12)){
            diesmesos2=31;
            
        }else{
            diesmesos2=30;
        }
        //utilitzem el switch-case
        switch (mes2){
        case 1:
               System.out.println(MSG_2+any2+MSG_4+mes2+" resultat="+diesmesos2);
               break;
        case 2:
               System.out.println(MSG_2+any2+MSG_4+mes2+" resultat="+diesfeb2);
               break;
        case 3:
               
        case 4:
               
        case 5:
               
        case 6:
               
        case 7:
               
        case 8:
               
        case 9: 
               
        case 10:
               
        case 11:
               
        case 12:
               System.out.println(MSG_2+any2+MSG_4+mes2+" resultat="+diesmesos2);
               break;
        default:
               System.out.println(MSG_3);
        }
        
    }
    
}
//Post: Retornar cuants dies té aquest mes tenint en compte els anys de traspàs