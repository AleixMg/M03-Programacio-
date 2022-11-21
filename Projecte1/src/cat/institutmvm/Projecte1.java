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


public class Projecte1 {

    private static final String MSG_1 = "Id?:"; 
    private static final String MSG_2 = "Edat?: "; 
    private static final String MSG_3 = "tipus de venda?:"; 
    private static final String MSG_4 = "venda lliure (0)";
    private static final String MSG_5 = "pensionista(1)";
    private static final String MSG_6 = "carnet jove(2)";
    private static final String MSG_7 = "soci(3)";
    private static final String MSG_8 = "import de la compra?: ";
    private static final String MSG_9 = "telèfon de contacte?:";  
    private static final String MSG_10 = "Error en dades";
    
                       
    public static void main(String[] args) {
        int id=0,edat=0,tipusVenda=0,importCompra=0,telèfonContacte=0; 
        //posem String venda per a que després amb el switch case guardarem a venda amb el seu tipus
        String venda=" ";
        boolean correcte;
        int error=0; 
        Scanner sc = new Scanner(System.in); 
        
        //Per comprobar la id 
        do{
            System.out.print(MSG_1);
            //per comprobar que posi un carracter 
            correcte= sc.hasNextInt();
            if(correcte){
                id = sc.nextInt();  
                //per comprobar que el id no posi un nombre més gran que 999 ni més petit que 111
                if(id<111||id>999){
                    correcte = false;
                    System.out.println(MSG_10); 
                } 
            //sino introduim bé el càrracter dona un error
            }else{
                sc.next();
                System.out.println(MSG_10); 
            }
            error++;
        }while((!correcte)&&(error<3));
        
        //Per comprobar la edat 
        if( error<=3 && correcte){
            //reiniciem la compta de errors a 0 
            error=0;
            do{
                System.out.print(MSG_2);
                //per comprobar que posi un carracter 
                correcte= sc.hasNextInt();
                if(correcte){
                     edat = sc.nextInt();  
                    //per comprobar que l'edat no posi un nombre més gran que 120 ni més petit que 14
                    if(edat<14||edat>120){
                        correcte= false;
                        System.out.println(MSG_10); 
                    }
                //sino introduim bé el càrracter dona un error    
                }else{
                    sc.next();
                    System.out.println(MSG_10); 
                }      
                error++;  
            }while((!correcte)&&(error<3));
        }
        
        //Per al tipus de venda 
        if( error<=3 && correcte){
            //reiniciem la compta de errors a 0 
            error=0;
            do{
                System.out.println(MSG_3);
                System.out.println(MSG_4);
                System.out.println(MSG_5);
                System.out.println(MSG_6);
                System.out.println(MSG_7);
                //per comprobar que posi un carracter 
                correcte= sc.hasNextInt();
                if(correcte){
                    tipusVenda = sc.nextInt();  
                    //per comprobar que introduim un número entre 0 i 3 inclosus els dos 
                    if(tipusVenda<0||tipusVenda>3){
                        correcte= false;
                        System.out.println(MSG_10); 
                    }
                //sino introduim bé el càrracter dona un error    
                }else{
                    sc.next();
                    System.out.println(MSG_10); 
                }      
                error++;     
            }while((!correcte)&&(error<3)); 
            
            //per emmagatzemar els tipus amb els números per després mostrar-ho 
            switch(tipusVenda){
                case 0: 
                    venda = "venda libre";
                break;
                case 1: 
                    venda = "pensionista";
                break;
                case 2: 
                    venda = "jove";
                break;
                case 3:
                    venda = " soci";
                break;
                
            }
        }
             
        //per a l'import de compra 
         if( error<=3 && correcte){
            //reiniciem la compta de errors a 0 
            error=0;
            do{
                System.out.print(MSG_8);
                //per comprobar que posi un carracter 
                correcte= sc.hasNextInt();
                if(correcte){
                    importCompra= sc.nextInt();  
                    //per comprobar que l'edat no posi un nombre més gran que 120 ni més petit que 14
                    if(importCompra<0||importCompra>1000){
                        correcte= false;
                        System.out.println(MSG_10); 
                    }
                //sino introduim bé el càrracter dona un error    
                }else{
                    sc.next();
                    System.out.println(MSG_10); 
                }      
                error++;
            }while((!correcte)&&(error<3)); 
      
         }
           
   
        //per al número de telèfon de contacte 
        if( error<=3 && correcte){
            //reiniciem la compta de errors a 0 
            error=0;
            do{
                System.out.print(MSG_9);
                correcte= sc.hasNextInt();
                if(correcte){
                    telèfonContacte = sc.nextInt();  
                    //per comprobar que l'edat no posi un nombre més gran que 120 ni més petit que 14
                    if( telèfonContacte <111111111||telèfonContacte >999999999){
                        correcte= false;
                        System.out.println(MSG_10); 
                    }
                //sino introduim bé el càrracter dona un error    
                }else{
                    sc.next();
                    System.out.println(MSG_10); 
                }      
                error++;
                 
            }while((!correcte)&&(error<3));        
        }
        //printem tots els resultats 
        if( error<=3 && correcte){
            System.out.println("ID "+" "+"EDAT "+" "+"TIPUS VENDA "+" "+" IMPORT COMPRA "+" "+" TELÈFON");
            System.out.println(id+"  "+edat+"     "+venda+"            "+importCompra+"         "+telèfonContacte);
            
        }
            
    }
    
}
