package controleur;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import model.Evenement;
import manager.GestionEvenements;

import java.io.IOException;


public class DashboardControleur {
	 @FXML
	    private ListView<String> evenementListView;

	    @FXML
	    private TextArea notificationArea;

	    private final GestionEvenements gestionnaire = GestionEvenements.getInstance();

	    @FXML
	    public void initialize() {
	        rafraichirListeEvenements();
	    }

	    private void rafraichirListeEvenements() {
	        evenementListView.getItems().clear();
	        for (Evenement e : gestionnaire.getTousLesEvenements().values()) {
	            evenementListView.getItems().add(e.getNom() + " | " + e.getDate());
	        }
	    }

	    @FXML
	    private void onAjouterEvenement(ActionEvent event) {
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/evenement_form.fxml"));
	            Parent root = loader.load();
	            Stage stage = new Stage();
	            stage.setTitle("Ajouter un Événement");
	            stage.setScene(new Scene(root));
	            stage.showAndWait();

	            // Refresh après ajout
	            rafraichirListeEvenements();
	            afficherNotification("Un événement a été ajouté avec succès.");

	        } catch (IOException e) {
	            showError("Erreur lors de l'ouverture du formulaire : " + e.getMessage());
	        }
	    }

	    @FXML
	    private void onInscrireParticipant(ActionEvent event) {
	        afficherNotification("Module d’inscription à implémenter.");
	    }

	    public void afficherNotification(String message) {
	        notificationArea.appendText(message + "\n");
	    }

	    private void showError(String message) {
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Erreur");
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.showAndWait();
	    }
}
