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

//Pre: Utilitzar la sentenciá if else 

public class Ap2Ex3 {


    private static final String MSG_1 = " Introdueix un número ";
    private static final String MSG_17 = " Introdueix dos números "; 
    private static final String MSG_24 = " Introdueix tres números "; 
    //a
    private static final String MSG_2 = " Aquest número és negatiu ";
    private static final String MSG_3 = " Aquest número no és negatiu ";
    //b
    private static final String MSG_4 = " Aquest número és més gran que 35 ";
    private static final String MSG_5 = " Aquest número no és més gran que 35 ";
    //c
    private static final String MSG_6 = " Aquest número és més gran que 100 ";
    private static final String MSG_7 = " Aquest número no és més gran que 100 però és positiu";
    private static final String MSG_8 = " Aquest número no és més gran que 100 ni positiu";
    //d
    private static final String MSG_9 = " Aquest número no pertany al interval [-3,27] ";
    private static final String MSG_10 = " Aquest número pertany al interval [-3,27] ";
    //e
    private static final String MSG_11 = " Aquest número no pertany al interval [25,50] ";
    private static final String MSG_12 = " Aquest número pertany al interval [25,50] ";
    //f
    private static final String MSG_13 = " El mòdul del  primer nombre entre el segon és més petit que 15 mòdul dels nombres: ";
    private static final String MSG_14 = " El mòdul del  primer nombre entre el segon és més gran que 15 mòdul dels nombres: ";
    private static final String MSG_22 = " El segon nombre no pot ser 0 introdueix un altre ";
    //g 
    private static final String MSG_15 = " Aquest número enter és sennar ";
    private static final String MSG_16 = " Aquest número enter no és sennar ";
    //h
    private static final String MSG_18 = " Aquest número és parell ho elevem al quadrat: ";
    private static final String MSG_19 = " Aquest número és sennar ho elevem al cub: ";
    //i
    private static final String MSG_20 = " El número més gran és: ";
    private static final String MSG_30 = " No hi ha màxim, els dos números són iguals";
    //j
    private static final String MSG_31 = " No hi ha màxim, els tres números són iguals";
    //k
    private static final String MSG_25 = " El primer nombre te que ser més gran que el segón introdueix un altre cop el primer número ";
    private static final String MSG_26 = " El segón número és múltiple del primer ";
    private static final String MSG_27 = " El segón número no és múltiple del primer ";
    //L
    private static final String MSG_28 = " Introdueix els litres d'aigua utilitzats ";
    private static final String MSG_29 = " La factura del aigua és: ";
    
    
    
    
    public static void main(String[] args) {
        
        // a) per determinar si un nombre és negatiu
        System.out.println(MSG_1);
        int n1;
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        if (n1>=0){
            System.out.println(MSG_3);
        }else{
            System.out.println(MSG_2);
        }
        System.out.println("");
        
    
        // b) per determinar si un nombre és més gran que 35 
        System.out.println(MSG_1);
        int n2;
        n2 = sc.nextInt();
        if (n2>35){
            System.out.println(MSG_4);
        }else{
            System.out.println(MSG_5);
        }
        System.out.println("");
        
        
        // c)per determinar si un nombre és positiu i menor que 100
        System.out.println(MSG_1);
        int n3;
        n3= sc.nextInt();
        if (n3>100){
            System.out.println(MSG_6);
        }else{
            if (n3<0){
                System.out.println(MSG_8);
            }else{
                System.out.println(MSG_7);
            }    
        }
        System.out.println("");
        
        
        // d)per determinar si un nombre per pertany a l'interval [-3,27]
         System.out.println(MSG_1);
        int n4;
        n4= sc.nextInt();
        if((n4>=-3)&&(n4<=27)){
            System.out.println(MSG_10);
        }else{
            System.out.println(MSG_9);
        }
        System.out.println("");
        
        
        // e)per determinar si un nombre no pertany al interval [25,50]
        System.out.println(MSG_1);
        int n5;
        n5= sc.nextInt();
        if((n5>=25)&&(n5<=50)){
            System.out.println(MSG_12);
        }else{
            System.out.println(MSG_11);
        }
        System.out.println("");
        
        
        // f)per determinar si el mòdul d'un nombre és menor que 15
          System.out.println(MSG_17);
        int n6,n7;
        n6 = sc.nextInt();
        n7 = sc.nextInt();
            //posem aquesta sentència per a que l'usuari no posi 0 al segón número 
        while(n7==0){
           System.out.println(MSG_22); 
           n7= sc.nextInt(); 
        }
        if (n6%n7<15){
            System.out.println(MSG_13+(n6%n7));
        }else{
            System.out.println(MSG_14+(n6%n7));
        }
        System.out.println("");
        
        
        // g)per determinar si un enter és senar
        System.out.println(MSG_1);
        int n8;
        n8 = sc.nextInt();
        if (n8%2==0){
            System.out.println(MSG_16);
        }else{
            System.out.println(MSG_15);
        }
        System.out.println("");
        
        
        // h) si un nombre és parell ho elevem al quadrat si és sennar ho elevem al cub 
        System.out.println(MSG_1);
        int n9;
        n9 = sc.nextInt();
        if (n9%2==0){
            System.out.println(MSG_18+(n9*n9));
        }else{
            System.out.println(MSG_19+(n9*n9*n9));
        }
        System.out.println("");
        
        // i) calcular el màxim de dos nombres donats
        System.out.println(MSG_17);
        int n10,n11;
        n10 = sc.nextInt();
        n11= sc.nextInt();
        if (n11>n10){
            System.out.println(MSG_20+n11);
        }else{
            if(n11==n10){
                System.out.println(MSG_30);
            }else{
                System.out.println(MSG_20+n10);   
            }  
        }
        System.out.println("");
        
        
        // j) calcular el màxim de tres nombres
        System.out.println(MSG_24);
        int n12,n13,n14;
        n12 = sc.nextInt();
        n13= sc.nextInt();
        n14 = sc.nextInt();
        if ((n12>n13)&&(n12>n14)){
            System.out.println(MSG_20+n12);
        }else{
            if (n13<n14){
                System.out.println(MSG_20+n14);
            }else{
                if((n12==n13)&&(n12==n14)){
                    System.out.println(MSG_31);
                }else{
                    System.out.println(MSG_20+n13);
                }  
            }  
        }      
        System.out.println("");
        
        
        // k) donats dos nombres mostrar si un d'ells és múltiple d'altre 
         System.out.println(MSG_17);
        int n15,n16;
        n15 = sc.nextInt();
        n16 = sc.nextInt();
            //Per a que l'usuari no posi 0 com a segón número
         while(n16==0){
           System.out.println(MSG_22); 
           n16= sc.nextInt(); 
        }
        while(n15<n16){
           System.out.println(MSG_25); 
           n15 = sc.nextInt();
        }
        if (n15%n16==0){
            System.out.println(MSG_26);
        }else{
            System.out.println(MSG_27);
        }
        System.out.println("");
        
        
        // L)Calcula la factura d’aigua tenint en compte les següents dades:
         //La quota fixa és de 6€.
         //Els primers 50 litres d’aigua són de franc.
         //Entre 50 i 200 litres, el litre costa 0,1€
         //A partir de 200 el litre costa 0,3€.
        System.out.println(MSG_28);
        int n17;
        n17 = sc.nextInt();
        if ((n17>50)&&(n17<200)){
            System.out.println(MSG_29+(6+(n17*0.1)));
        }else{
            if (n17<50){
              System.out.println(MSG_29+6);
            }else{
              System.out.println(MSG_29+(6+(n17*0.3)));
            }   
        }
        System.out.println("");

    }
    
}
//Post: Retornar els valors utilitzant bè la sentència if else 