package manager;

import model.Evenement;
import exceptions.EvenementDejaExistantException;

import java.util.HashMap;
import java.util.Map;



public class GestionEvenements {
	private static GestionEvenements instance;
    private Map<String, Evenement> evenements;

    private GestionEvenements() {
        evenements = new HashMap<>();
    }

    public static GestionEvenements getInstance() {
        if (instance == null) {
            instance = new GestionEvenements();
        }
        return instance;
    }

    public void ajouterEvenement(Evenement e) throws EvenementDejaExistantException {
        if (evenements.containsKey(e.getId())) {
            throw new EvenementDejaExistantException("Événement déjà existant : " + e.getId());
        }
        evenements.put(e.getId(), e);
    }

    public void supprimerEvenement(String id) {
        evenements.remove(id);
    }

    public Evenement rechercherEvenement(String id) {
        return evenements.get(id);
    }

    public Map<String, Evenement> getTousLesEvenements() {
        return evenements;
    }
}
