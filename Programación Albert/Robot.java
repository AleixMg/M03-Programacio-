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
