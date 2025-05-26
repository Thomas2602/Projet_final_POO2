package controleur;

import model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import exceptions.EvenementDejaExistantException;
import manager.GestionEvenements;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class EvenementFormControleur {
	 @FXML private TextField idField;
	    @FXML private TextField nomField;
	    @FXML private TextField lieuField;
	    @FXML private TextField capaciteField;
	    @FXML private TextField dateField; // format : yyyy-MM-dd HH:mm
	    @FXML private ComboBox<String> typeCombo;
	    @FXML private TextField champSpecifique1;
	    @FXML private TextField champSpecifique2;
	    @FXML private Label labelSpecifique1;
	    @FXML private Label labelSpecifique2;
	    @FXML private Button enregistrerButton;

	    private final GestionEvenements gestionnaire = GestionEvenements.getInstance();

	    @FXML
	    public void initialize() {
	        typeCombo.getItems().addAll("Conference", "Concert");
	        typeCombo.setOnAction(e -> ajusterChampsSpecifiques());
	    }

	    private void ajusterChampsSpecifiques() {
	        String type = typeCombo.getValue();
	        if ("Conference".equals(type)) {
	            labelSpecifique1.setText("Thème");
	            labelSpecifique2.setText("Intervenants (non utilisé ici)");
	            champSpecifique1.setPromptText("Thème de la conférence");
	            champSpecifique2.setPromptText("Liste d'intervenants");
	        } else if ("Concert".equals(type)) {
	            labelSpecifique1.setText("Artiste");
	            labelSpecifique2.setText("Genre musical");
	            champSpecifique1.setPromptText("Nom de l'artiste");
	            champSpecifique2.setPromptText("Genre musical");
	        }
	    }

	    @FXML
	    private void onEnregistrer() {
	        try {
	            String id = idField.getText();
	            String nom = nomField.getText();
	            String lieu = lieuField.getText();
	            int capacite = Integer.parseInt(capaciteField.getText());
	            LocalDateTime date = LocalDateTime.parse(dateField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

	            String type = typeCombo.getValue();
	            Evenement e = null;

	            if ("Conference".equals(type)) {
	                e = new Conference(id, nom, date, lieu, capacite, champSpecifique1.getText(), null);
	            } else if ("Concert".equals(type)) {
	                e = new Concert(id, nom, date, lieu, capacite, champSpecifique1.getText(), champSpecifique2.getText());
	            }

	            if (e != null) {
	                gestionnaire.ajouterEvenement(e);
	                fermerFenetre();
	            }

	        } catch (NumberFormatException ex) {
	            showError("Capacité invalide !");
	        } catch (EvenementDejaExistantException ex) {
	            showError("Événement déjà existant !");
	        } catch (Exception ex) {
	            showError("Erreur : " + ex.getMessage());
	        }
	    }

	    private void fermerFenetre() {
	        Stage stage = (Stage) enregistrerButton.getScene().getWindow();
	        stage.close();
	    }

	    private void showError(String message) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Erreur");
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.showAndWait();
	    }
}
