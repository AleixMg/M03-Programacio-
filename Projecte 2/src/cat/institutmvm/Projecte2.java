/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cat.institutmvm;

import java.util.Scanner;

/**
 *
 * @author alumne_1r
 */
public class Projecte2 {
    
    private static final String MSG_1 = "Id?:"; 
    private static final String MSG_2 = "Edat?: "; 
    private static final String MSG_3 = "tipus de venda?:"; 
    private static final String MSG_4 = "venda lliure (0)";
    private static final String MSG_5 = "pensionista(1)";
    private static final String MSG_6 = "carnet jove(2)";
    private static final String MSG_7 = "soci(3)";
    private static final String MSG_8 = "Import de la compra?: ";
    private static final String MSG_9 = "Telèfon de contacte?:";  
    private static final String MSG_10 = "Error en dades";
    private static final String MSG_11 = "Introdueix quants clients vols: ";
    private static final String MSG_12 = "Client número ";
    private static final String MSG_13 = "T'has equivocat torna a escriure les dades del client: ";
    private static final String MSG_14 = "Vols consultar per tipus de client?(si: 1/ no:0): ";
    private static final String MSG_15 = "Quin tipus de client(0,1,2,3)? ";
    private static final String MSG_16 = "El número de clients introduits són: ";
    private static final String MSG_17 = "Error, introdueix(si: 1/ no:0): ";
    private static final String MSG_18 = "Error, introdueix el tipus de client un altre cop(0,1,2,3):  ";
    private static final String MSG_19 = "Vols consultar el resum estadístic?(si: 1/ no:0): ";
    private static final String MSG_20 = "El número de registres de clients introduits són: ";
    private static final String MSG_21 = "Mitjana d’edat: ";
    private static final String MSG_22 = "Dades de clients de tipus";
    private static final String MSG_23 = "Número de clients per tipus: ";
    private static final String MSG_24 = "Histograma de número de clients per tipus : " ; 
    private static final String MSG_25 = "-----------------------------";
    private static final String MSG_26 = "Import total acumulat: ";
    private static final String MSG_27 = "ID "+" "+"EDAT "+" "+"TIPUS VENDA "+" "+" IMPORT COMPRA "+" "+" TELÈFON";
    private static final String TXT_LLIURE = " venda lliure";
    private static final String TXT_PENSION = " pensionista";
    private static final String TXT_JOVE = " jove";
    private static final String TXT_SOCI = " soci";
    private static final String TXT_ESTRELLA = "*";
    
    public static void main(String[] args) {
        // per a guardar solament els números en l'array que entrin al rang fem variables per a cada tipus de dada
        int idNum=0,edatNum=0,tipusVendaNum=0,importCompraNum=0,telefonContacteNum=0; 
        //per saber quants clients vols introduir
        int numClie=0;
        // el boolean correcte es per validar que s'hi introdueixin números
        boolean correcte;
        //l'error és per a que una vegada arribi a 3 errors s'aturi el programa 
        int error=0; 
        //per saber si el client vol consultar per tipus de client
        int consulta=0;
        //per saber quin tipus de client introdueix 
        int tipusClient = 0;
        //fem una variable per emagatzemar el total de l'edat i del presupost
        int edatTotal=0, importTotal=0;
        //per comptar el número que hi ha de cada tipus de client
        int cont0=0, cont1=0, cont2=0, cont3=0;
        // per canviar les posicions i ordenar per edats fem una nova variable
        int ordenar=0;
       
        Scanner sc = new Scanner(System.in); 
        
        //per saber el número de clients si ho introdueix malament torna a demar-ho    
        do{
            System.out.println(MSG_11);
            correcte=sc.hasNextInt();
            if(correcte){
                numClie=sc.nextInt();
            }else{
                sc.next();
                System.out.println(MSG_10);
            }
        }while(!correcte);
        
        //les arrays per guaradar els valors 
        int[]id=new int[numClie];
        int[]edat= new int[numClie];
        int[]tipusVenda= new int[numClie];
        int[]importCompra= new int[numClie];
        int[]telefonContacte= new int[numClie];
        //per guardar després el tipus de venta que ha escollit l'usuari i prinatr-les 
        String[]Venta=new String[numClie];
        //per fer l'histograma fem una nova array, ho fem  de mida 4 perque hi ha 4 tipus de client
        int[]histograma= new int [4];
        
        //posem un for per saber quants clients vol introduir 
        for(int i=0;i<numClie;i++){
        //reiniciem els errors
        error=0;
        //Per comprobar la id 
        do{
            System.out.print(MSG_12+(i+1)+" "+MSG_1);
            //per comprobar que posi un carracter 
            correcte= sc.hasNextInt();
            if(correcte){
                idNum = sc.nextInt();  
                //per comprobar que el id no posi un nombre més gran que 999 ni més petit que 111
                if(idNum<111||idNum>999){
                    correcte = false;
                    System.out.println(MSG_10); 
                //si esta bé guardem el número a l'array
                }else{
                    id[i]=idNum;
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
                System.out.print(MSG_12+(i+1)+" "+MSG_2);
                //per comprobar que posi un carracter 
                correcte= sc.hasNextInt();
                if(correcte){
                     edatNum = sc.nextInt();  
                    //per comprobar que l'edat no posi un nombre més gran que 120 ni més petit que 14
                    if(edatNum<14||edatNum>120){
                        correcte= false;
                        System.out.println(MSG_10); 
                    //si esta bé guardem el número a l'array
                    }else{
                        edat[i]=edatNum;
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
                System.out.println(MSG_12+(i+1)+" "+MSG_3);
                System.out.println(MSG_4);
                System.out.println(MSG_5);
                System.out.println(MSG_6);
                System.out.println(MSG_7);
                //per comprobar que posi un carracter 
                correcte= sc.hasNextInt();
                if(correcte){
                    tipusVendaNum = sc.nextInt();  
                    //per comprobar que introduim un número entre 0 i 3 inclosus els dos 
                    if(tipusVendaNum<0||tipusVendaNum>3){
                        correcte= false;
                        System.out.println(MSG_10); 
                    //si esta bé guardem el número a l'array
                    }else{
                        tipusVenda[i]=tipusVendaNum;
                    }
                //sino introduim bé el càrracter dona un error    
                }else{
                    sc.next();
                    System.out.println(MSG_10); 
                }      
                error++;     
            }while((!correcte)&&(error<3)); 
            
            //per emmagatzemar els tipus amb els números per després mostrar-ho 
            switch(tipusVenda[i]){
                case 0: 
                    Venta[i]= TXT_LLIURE;            
                break;
                case 1: 
                    Venta[i]=TXT_PENSION;
                break;
                case 2: 
                    Venta[i]=TXT_JOVE;
                break;
                case 3:
                    Venta[i]=TXT_SOCI;
                break;
                
            }
        }
             
        //per a l'import de compra 
         if( error<=3 && correcte){
            //reiniciem la compta de errors a 0 
            error=0;
            do{
                System.out.print(MSG_12+(i+1)+" "+MSG_8);
                //per comprobar que posi un carracter 
                correcte= sc.hasNextInt();
                if(correcte){
                    importCompraNum= sc.nextInt();  
                    //per comprobar que l'edat no posi un nombre més gran que 120 ni més petit que 14
                    if(importCompraNum<0||importCompraNum>1000){
                        correcte= false;
                        System.out.println(MSG_10); 
                    //si esta bé guardem el número a l'array
                    }else{
                        importCompra[i]=importCompraNum;
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
                System.out.print(MSG_12+(i+1)+" "+MSG_9);
                correcte= sc.hasNextInt();
                if(correcte){
                    telefonContacteNum = sc.nextInt();  
                    //per comprobar que l'edat no posi un nombre més gran que 120 ni més petit que 14
                    if( telefonContacteNum<111111111||telefonContacteNum>999999999){
                        correcte= false;
                        System.out.println(MSG_10); 
                    //si esta bé guardem el número a l'array
                    }else{
                        telefonContacte[i]=telefonContacteNum;
                    }
                //sino introduim bé el càrracter dona un error    
                }else{
                    sc.next();
                    System.out.println(MSG_10); 
                }      
                error++;
                 
            }while((!correcte)&&(error<3)); 
            
        }
        System.out.println();
        // per si falles el programa et torna a demanar el mateix client
        if (error>=3){
            System.out.println(MSG_13+ (i+1));
            i--;
        }        
        }
        //Fem  dos for per comprovar dos posicions seguides de l'array edat, si un valor és més gran que el següent intercanvibiem les posicinons.
        for(int i = 0; i < edat.length - 1; i++){ 
            for(int j = i + 1; j < edat.length; j++){ 
                if(edat[i] > edat[j]){
                    //per ordenar la id 
                    ordenar = id[i];
                    id[i] = id[j];
                    id[j] = ordenar;
                    // per ordenar la edat 
                    ordenar = edat[i];
                    edat[i] = edat[j];
                    edat[j] = ordenar;
                    //per ordenar el tipus de venta
                    ordenar = tipusVenda[i];
                    tipusVenda[i] = tipusVenda[j];
                    tipusVenda[j] = ordenar;
                    //per l'import de la compra
                    ordenar = importCompra[i];
                    importCompra[i] = importCompra[j];
                    importCompra[j] = ordenar;
                    //per ordenar el telefon 
                    ordenar = telefonContacte[i];
                    telefonContacte[i] = telefonContacte[j];
                    telefonContacte[j] = ordenar;
                }
            }
        }
        //printem tots els resultats 
        if( error<=3 && correcte){
            System.out.println(MSG_27);
            for(int i=0;i<numClie;i++){
                System.out.println(id[i]+"  "+edat[i]+"     "+Venta[i]+"            "+importCompra[i]+"€"+"         "+telefonContacte[i]);
            }
        
        }
        //per mostrar quants clients a introduït
        System.out.println();
        System.out.println(MSG_20+" "+numClie);
        //per demanar si vol consultar els tipus de client comprovem que el número de clients sigui més gran que 0 
        System.out.println();
        if(numClie>0){
            System.out.print(MSG_14);
            //per a que el número que introdueïxi sigui 1 o 0
            do{
                correcte=sc.hasNextInt();
                if(correcte){
                    consulta = sc.nextInt(); 
                    if((consulta < 0) || (consulta > 1)){
                        correcte = false;
                        System.out.println(MSG_17);
                    }    
                }else{
                    sc.next();
                    System.out.print(MSG_17);
                }
            }while(!correcte);
            //per a que esculli quin tipus de client vol saber les dades 
            if(consulta==1){
                System.out.println();
                System.out.print(MSG_15);
                do{  
                    //posem el if de correcte per a que l'usuari no escrigui una lletra
                    correcte=sc.hasNextInt();
                    if(correcte){
                        tipusClient = sc.nextInt();
                        if((tipusClient<0)||(tipusClient>3)){
                            correcte = false;
                            System.out.println(MSG_18);
                        }
                    }else{
                        sc.next();
                        System.out.println(MSG_10); 
                    }
                }while(!correcte); 
                //ahora printem els resultats per fer-ho fem un if per a cada tipus de client 
                //printem els resultats del client 0 si l'usuari vol 
                if (tipusClient==0){
                    System.out.println();
                    System.out.println(MSG_22+TXT_LLIURE);
                    for(int i=0; i<tipusVenda.length;i++){
                        if(tipusVenda[i]==0){
                            System.out.println();
                            System.out.println(MSG_27);
                            System.out.println(id[i]+"  "+edat[i]+"     "+Venta[i]+"            "+importCompra[i]+"€"+"         "+telefonContacte[i]);
                        }
                    }   
                } 
                //printem els resultats del client 1 si l'usuari vol 
                if (tipusClient==1){
                    System.out.println();
                    System.out.println(MSG_22+TXT_PENSION);
                    for(int i=0; i<tipusVenda.length;i++){
                        if(tipusVenda[i]==1){
                            System.out.println();
                            System.out.println(MSG_27);
                            System.out.println(id[i]+"  "+edat[i]+"     "+Venta[i]+"            "+importCompra[i]+"€"+"         "+telefonContacte[i]);
                        }
                    }   
                } 
                //printem els resultats del client 2 si l'usuari vol 
                if (tipusClient==2){
                    System.out.println();
                    System.out.println(MSG_22+TXT_JOVE);
                    for(int i=0; i<tipusVenda.length;i++){
                        if(tipusVenda[i]==2){
                            System.out.println();
                            System.out.println(MSG_27);
                            System.out.println(id[i]+"  "+edat[i]+"     "+Venta[i]+"            "+importCompra[i]+"€"+"         "+telefonContacte[i]);
                        }
                    }   
                } 
                //printem els resultats del client 3 si l'usuari vol 
                if (tipusClient==3){
                    System.out.println();
                    System.out.println(MSG_22+TXT_SOCI);
                    for(int i=0; i<tipusVenda.length;i++){
                        if(tipusVenda[i]==3){
                            System.out.println();
                            System.out.println(MSG_27);
                            System.out.println(id[i]+"  "+edat[i]+"     "+Venta[i]+"            "+importCompra[i]+"€"+"         "+telefonContacte[i]);
                        }
                    }   
                } 
            } 
        }
        //demanem al client si vol el resum estadístic
        System.out.println();
        if(numClie>0){
            System.out.print(MSG_19);
            //per a que el número que introdueïxi sigui 1 o 0
            do{
                //comprobem que l'usuari no posi una lletra o un número que es pasi dels parametres
                correcte=sc.hasNextInt();
                if(correcte){
                    consulta = sc.nextInt(); 
                    if((consulta < 0) || (consulta > 1)){
                        correcte = false;
                        System.out.println(MSG_17);
                    }    
                }else{
                    sc.next();
                    System.out.print(MSG_17);
                }
            }while(!correcte);
            //si l'usuari vol fem que posi un 1 
            if(consulta==1){
                System.out.println();
                //printem quants clients ha introduit l'usuari 
                System.out.println(MSG_16+""+numClie);
                //calculme l'edat total dels clients
                System.out.println();
                for(int i=0; i<edat.length;i++){
                    edatTotal= edatTotal+edat[i];
                }
                //calculem la mitjana 
                System.out.println(MSG_21+" "+(edatTotal/numClie));
                // mostrem quants clients ha escollit de cada tipus
                System.out.println();
                System.out.println(MSG_23);
                //per fer-ho fem un for per recorre l'array i sumar respectivament la quantitat que hi ha de cada tipus
                for(int i=0; i<tipusVenda.length;i++){
                    if(tipusVenda[i] == 0){                 
                        cont0++;        
                    }
                    if(tipusVenda[i] == 1){
                        cont1++;
                    }
                    if(tipusVenda[i] == 2){
                        cont2++;
                    }
                    if(tipusVenda[i] == 3){
                        cont3++;
                    }
                }
                //mostrem el número de cada tipus de client sempre que el seu comptador sigui més gran que 0
                if (cont0 >0){
                    System.out.println();
                    System.out.println(TXT_LLIURE+":"+" "+cont0);
                }
                if (cont1 >0){
                    System.out.println();
                    System.out.println(TXT_PENSION+":"+" "+cont1);
                }
                if (cont2 >0){
                    System.out.println();
                    System.out.println(TXT_JOVE+":"+" "+cont2);
                }
                if (cont3 >0){
                    System.out.println();
                    System.out.println(TXT_SOCI+":"+" "+cont3);
                }
                //guardem els resultats del contadors a la nova array del hsitograma 
                histograma[0]= cont0;
                histograma[1]= cont1;
                histograma[2]= cont2;
                histograma[3]= cont3;               
                //fem l'histograma comencem amb un for i mostrarem unicament els tipus de clients introduïts 
                System.out.println();
                System.out.println(MSG_24);
                System.out.println(MSG_25);
                for(int i=0; i<histograma.length;i++){
                    //amb el swicth case posem el nombre del tipus de client
                    switch(i) {
                        case 0:
                            System.out.print(TXT_LLIURE+": ");
                            break;
                        case 1:
                            System.out.print(TXT_PENSION+": ");
                            break;
                        case 2:
                            System.out.print(TXT_JOVE+": ");
                            break;
                        case 3:
                            System.out.print(TXT_SOCI+": ");
                        break;
                    }
                    //imprimim tantes estrelles com el valor del comptador.
                    for (int j = 0; j < histograma[i]; j++) {
                        System.out.print(TXT_ESTRELLA);
                    }
                    System.out.println();  
                }  
                //calculme l'import total dels clients
                System.out.println();
                for(int i=0; i<importCompra.length;i++){
                    importTotal= importTotal+edat[i];
                }
                //Printem el resultat
                System.out.println(MSG_26+" "+importTotal+"€");
            }    
        }
    }
    
}
