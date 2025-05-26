package model;

public class Participant {
	protected String id;
    protected String nom;
    protected String email;

    public Participant(String id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public String getEmail() { return email; }
    public String getNom() { return nom; }
}
