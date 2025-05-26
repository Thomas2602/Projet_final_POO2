package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class MainApp extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception {
        // Charge le fichier FXML principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dashboard.fxml"));
        Parent root = loader.load();

        // Paramètres de la fenêtre
        primaryStage.setTitle("Système de Gestion d'Événements");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Lancement de l'application JavaFX
    }
}
