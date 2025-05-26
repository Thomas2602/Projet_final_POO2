package observer;

import model.Participant;

public class  ParticipantNotifiable extends Participant implements ParticipantObserver {
	public ParticipantNotifiable(String id, String nom, String email) {
        super(id, nom, email);
    }

    @Override
    public void recevoirNotification(String message) {
        System.out.println("Notification reçue par " + nom + ": " + message);
    }
}
