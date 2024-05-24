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
