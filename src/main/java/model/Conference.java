package model;

import java.time.LocalDateTime;
import java.util.List;

public class Conference extends Evenement {
	private String theme;
    private List<Intervenant> intervenants;

    public Conference(String id, String nom, LocalDateTime date, String lieu, int capaciteMax, String theme, List<Intervenant> intervenants) {
        super(id, nom, date, lieu, capaciteMax);
        this.theme = theme;
        this.intervenants = intervenants;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Thème: " + theme);
    }

    public String getTheme() { return theme; }
    public List<Intervenant> getIntervenants() { return intervenants;}
}
