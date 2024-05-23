package fx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FX extends Application {
    @Override
    //Fem la finestra on mostrarem el boto per a clicar
    public void start(Stage Finestra1) {
        // Creem un botó amb el text "Clica aquí"
        Button btn = new Button("Clica aquí");

        // Definim l'acció que es farà quan l'usuari premi el botó
        btn.setOnAction(event -> {
            // Creem una alerta de tipus informatiu per mostrar el missatge
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Salutació");
            alert.setHeaderText("Salutació per prendre el botó");
            alert.setContentText("Hola, bon dia! Has premut el botó.");

            // Per mostrar l'alerta
            alert.showAndWait();
        });
        
        // Creem el layout principal i afegim el botó
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Creem una escena amb el layout principal( la caixa amb el boto)
        Scene scene = new Scene(root, 450, 300);

        // Configurem l'escenari principal (la finestra)
        Finestra1.setTitle("Aplicació en JavaFX, salutació");
        Finestra1.setScene(scene);
        Finestra1.show();
    }

    //el main per executar-ho
    public static void main(String[] args) {
        launch(args);
    }
}
