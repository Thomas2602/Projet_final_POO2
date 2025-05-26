package tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import exceptions.CapaciteMaxAtteinteException;
import model.Concert;
import model.Participant;

public class EvenementTest {
	@Test
    public void testAjoutParticipant() throws CapaciteMaxAtteinteException {
        Concert concert = new Concert("001", "Rock Night", LocalDateTime.now(), "Stade", 2, "Metallica", "Rock");
        Participant p1 = new Participant("p1", "Alice", "alice@email.com");
        Participant p2 = new Participant("p2", "Bob", "bob@email.com");

        concert.ajouterParticipant(p1);
        concert.ajouterParticipant(p2);

        assertEquals(2, concert.getParticipants().size());
    }

    @Test
    public void testDepassementCapacite() {
        Concert concert = new Concert("002", "Jazz Night", LocalDateTime.now(), "Club", 1, "John Doe", "Jazz");
        Participant p1 = new Participant("p1", "Alice", "alice@email.com");
        Participant p2 = new Participant("p2", "Bob", "bob@email.com");

        assertDoesNotThrow(() -> concert.ajouterParticipant(p1));
        assertThrows(CapaciteMaxAtteinteException.class, () -> concert.ajouterParticipant(p2));
    }
}
