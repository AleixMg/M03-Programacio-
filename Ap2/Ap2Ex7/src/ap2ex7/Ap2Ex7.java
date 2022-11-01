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
package ap2ex7;

//Pre: Utilitzar la sentenica while 

public class Ap2Ex7 {


    

    public static void main(String[] args) {
        
        // a) escriure per pantalla els 10 primers números començant pel 0
        System.out.println("Apartat a");
        int i=0;
        while(i<11){
              System.out.println(i);
              i++;
         }
        System.out.println("");
        
        // b) escriure per pantalla els 100 primers números començant pel 0
        System.out.println("Apartat b");
        int j=0;
          while(j<101){
              System.out.println(j);
              j++;
         }
        System.out.println("");
        
        // c) escriure els 100 primers números parells començant pel 0
        System.out.println("Apartat c");
        int k=0;
        while(k<101){
           if (k%2==0){
              System.out.println(k);  
           }
        k++; 
         }  
        System.out.println("");
        
        // d) escriure els números del 0 al 100 en ordre descendent. 
        System.out.println("Apartat d");
        int l=100;
          while(l>=0){
              System.out.println(l);
              l--;
         }
    }
    
}
//Post: Mostrar per pantalla amb la sentencia while 