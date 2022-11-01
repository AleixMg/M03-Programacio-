/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cat.institutmvm;


public class EX1 {

   private static final String MSG_1 = " El meu nom és: Aleix ";
   private static final String MSG_2 = " Els meus cognoms són: Muñoz Gálvez ";
   private static final String MSG_3 = " Quadrat 10*10:  ";
   private static final String MSG_4 = " Triangle de base 10: ";
   
    
    public static void main(String[] args) {
        //a)per imprimir el meu nom 
       System.out.println(MSG_1);
        //b)per imprimir el meu nom i cognoms en la mateixa liniea
       System.out.println(MSG_1+MSG_2);
        //c)per imprimeir el meu nom en una línia i el meu cognom en la següent. 
       System.out.println(MSG_1);
       System.out.println(MSG_2);
       System.out.println("");
        //d)Quadrat 
       System.out.println(MSG_3);
            //Codi linea superior
            for(int i = 0; i < 10; i++) {
                System.out.print("* ");
            }
            System.out.println();
           
            //Codi centre de la forma
            for(int i = 0; i < 10-2; i++) {
                System.out.print("*");
                for(int j = 0; j < 17; j++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
           
            //Codi linea inferior
            for(int i = 0; i < 10; i++) {
                System.out.print("* ");
            }  
            
        System.out.println("");
        
         //e)Triangle 
        System.out.println(MSG_4);
        System.out.println(""); 
        
        for(int i2 = 0; i2<10; i2++){
            //espais en blancs 
                for(int j2 = 0; j2<10-i2; j2++){
                    System.out.print(" ");
                }
            //asterics
                for(int k=1; k<=i2; k++){
                    System.out.print("* ");
                }
                System.out.println("");
    }
  } 
}
   
