package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import exceptions.CapaciteMaxAtteinteException;


public abstract class Evenement {
	protected String id;
    protected String nom;
    protected LocalDateTime date;
    protected String lieu;
    protected int capaciteMax;
    protected List<Participant> participants;

    public Evenement(String id, String nom, LocalDateTime date, String lieu, int capaciteMax) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.capaciteMax = capaciteMax;
        this.participants = new ArrayList<>();
    }

    public void ajouterParticipant(Participant participant) throws CapaciteMaxAtteinteException {
        if (participants.size() >= capaciteMax) {
            throw new CapaciteMaxAtteinteException("Capacité maximale atteinte pour l'événement " + nom);
        }
        participants.add(participant);
    }

    public void annuler() {
        // À notifier via Observer
    }

    public void afficherDetails() {
        System.out.println("Nom: " + nom + ", Date: " + date + ", Lieu: " + lieu);
    }

    public String getId() { return id; }
    public List<Participant> getParticipants() { return participants; }
    public String getNom() { return nom; }
    public LocalDateTime getDate() { return date;}
}
