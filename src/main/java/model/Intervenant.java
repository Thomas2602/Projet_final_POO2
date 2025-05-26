package model;

public class Intervenant {
	private String nom;
    private String specialiste;

    public Intervenant(String nom, String specialite) {
        this.nom = nom;
        this.specialiste = specialite;
    }

    public String getNom() { return nom;}
    public String getSpecialiste() { return specialiste;}
}
