package robot;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.util.Optional;

public class Robot extends Application {
    // Variables per les posicions
    private int posX = 0;
    private int posY = 0;
    //La direcció d'inici per defecte sera el NORD
    private String direccio = "Nord";
    private Label Label;

    @Override
    public void start(Stage finestraPrincipal) {
        // Creem els botons de control de la direcció del robot
        Button moureEndavant = new Button("🡩(Anar cap Endavant)");
        Button moureEnrere = new Button("🡫(Anar cap Enrere)");
        Button girarEsquerra = new Button("🡨(Girar cap a l'Esquerra)");
        Button girarDreta = new Button("🡪(Girar cap a la Dreta)");
        // Botons para guardar i carregar el estat del robot
        Button guardarEstat = new Button("✍(Guardar Estat)");
        Button carregarEstat = new Button("🔄(Carregar Estat)");

        // Creem un label per mostrar l'estat del robot
        Label = new Label(getEstat());

        // Asignem les accions als botons de direcció, guardar i carregar
        moureEndavant.setOnAction(e -> moureRobot("endavant"));
        moureEnrere.setOnAction(e -> moureRobot("enrere"));
        girarEsquerra.setOnAction(e -> girarRobot("esquerra"));
        girarDreta.setOnAction(e -> girarRobot("dreta"));
        guardarEstat.setOnAction(e -> barraGuardarDialog());
        carregarEstat.setOnAction(e -> barraCarregarDialog());

        // Configurarem el GridPane per la disposició dels botons i mostrar-ho en de forma que cada direcció sigui per un costat
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(moureEndavant, 1, 0); 
        gridPane.add(girarEsquerra, 0, 1); 
        gridPane.add(girarDreta, 2, 1); 
        gridPane.add(moureEnrere, 1, 2); 

        // Configurarem el VBox per l'estat i els botons de guardar i carregar
        VBox vbox = new VBox(20, Label, gridPane);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: #ffa1b7; -fx-padding: 20;");

        HBox hboxEstat = new HBox(10, guardarEstat, carregarEstat);
        hboxEstat.setAlignment(Pos.CENTER);

        vbox.getChildren().add(hboxEstat);

        // Creem la escena i configurarem la finestra principal
        Scene escena = new Scene(vbox, 800, 500);
        finestraPrincipal.setTitle("Control del Robot");
        finestraPrincipal.setScene(escena);
        finestraPrincipal.show();
    }

    //Metode per moure de cordenades al robot cap endavant o cap endarrera
    private void moureRobot(String direccio) {
        switch (direccio) {
            //Fem un switch case amb if per depenen la opcio on vagi les cordenades s'ajustin a l'opcio correcta del moviment
            case "endavant":
                if (this.direccio.equals("Nord")) posY++;
                else if (this.direccio.equals("Sud")) posY--;
                else if (this.direccio.equals("Est")) posX++;
                else if (this.direccio.equals("Oest")) posX--;
                break;
            //Ho fem tant per endavant com per enrere
            case "enrere":
                if (this.direccio.equals("Nord")) posY--;
                else if (this.direccio.equals("Sud")) posY++;
                else if (this.direccio.equals("Est")) posX--;
                else if (this.direccio.equals("Oest")) posX++;
                break;
        }
        actualitzarEstat();
    }
    
    //Metode per moure de cordenades al robot cap dreta o cap esquerra
    private void girarRobot(String direccio) {
        //Fem un switch case amb if per depenen la opcio on vagi les cordenades s'ajustin a l'opcio correcta del moviment
        switch (direccio) {
            case "esquerra":
                if (this.direccio.equals("Nord")) this.direccio = "Oest";
                else if (this.direccio.equals("Sud")) this.direccio = "Est";
                else if (this.direccio.equals("Est")) this.direccio = "Nord";
                else if (this.direccio.equals("Oest")) this.direccio = "Sud";
                break;
        //Ho fem tant per dreta com per esquerra 
            case "dreta":
                if (this.direccio.equals("Nord")) this.direccio = "Est";
                else if (this.direccio.equals("Sud")) this.direccio = "Oest";
                else if (this.direccio.equals("Est")) this.direccio = "Sud";
                else if (this.direccio.equals("Oest")) this.direccio = "Nord";
                break;
        }
        actualitzarEstat();
    }

    //Metode per actualitzar l'estat cada cop que es fa una accio
    private void actualitzarEstat() {
        Label.setText(getEstat());
    }
    
    //Amb el get agafarem les dades de la posicio i la direcció
    private String getEstat() {
        return "Cordenades del robot: (eix X:" + posX + ", eix Y:" + posY + ") Direcció: " + direccio;
    }

    //Fem un metode que mostri una barra per que l'usuari posi el nom del arxiu de com guardar l'estat
    private void barraGuardarDialog() {
        // Posem la barra que de forma predeterminada sugerirem de nom estat_del_robot, l'usuari pot escollir el nom que vulgui
        TextInputDialog dialog = new TextInputDialog("estat_del_robot");
        //Informació que mostrarem
        dialog.setTitle("Guardar Estat del robot");
        dialog.setHeaderText("Guardar l'estat del robot, introdueix el nom de l'arxiu on vols guardar-ho");
        dialog.setContentText("Introdueix el nom del fitxer(no s'ha de posar cap extensio):");

        dialog.showAndWait().ifPresent(filename -> guardarEstat(filename));
    }

    //Fem un metode que mostri una barra per que l'usuari posi el nom del arxiu del estat que vulgui carregar
    private void barraCarregarDialog() {
        //fem un boolear per comprovar si l'arxiu extisteix o posem en false per a que entri al bucle 
        boolean success = false;
        //Amb el while comprovem si l'arxiu existeix
        while (!success) {
            TextInputDialog dialog = new TextInputDialog("estat_del_robot");
            dialog.setTitle("Carregar Estat");
            dialog.setHeaderText("Carregar l'estat del robot, introdueix el nom de l'arxiu del qual vols carregar les dades");
            dialog.setContentText("Introdueix el nom del fitxer(no s'ha de posar cap extensio):");
            
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                String filename = result.get();
                success = carregarEstat(filename);
                //Si no existeix mostrara una alesrta de error dient que torni a posar un nom d'un arxiu que existeixi.
                if (!success) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("El fitxer no s'ha trobat");
                    alert.setHeaderText("El fitxer no existeix");
                    alert.setContentText("Introdueix un nom de fitxer existent.");
                    alert.showAndWait();
                }
            } else {
                // L' usuari cancela la operació
                break; 
            }
        }
    }

    //Metode per guardar l'estat, l'usuari no caldra que posi extensio ho fara de forma sola
    private void guardarEstat(String filename) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename + ".txt"))) {
            out.println(posX);
            out.println(posY);
            out.println(direccio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Metode per carregar l'estat, l'usuari no caldra que posi extensio ho fara de forma sola
    private boolean carregarEstat(String filename) {
        try (BufferedReader in = new BufferedReader(new FileReader(filename + ".txt"))) {
            posX = Integer.parseInt(in.readLine());
            posY = Integer.parseInt(in.readLine());
            direccio = in.readLine();
            actualitzarEstat();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //El main per poder executar el programa 
    public static void main(String[] args) {
        launch(args);
    }
}
