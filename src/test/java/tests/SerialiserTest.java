package tests;

import model.Concert;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import model.Evenement;
import serialisation.EvenementSerialise;


public class SerialiserTest {
	@Test
    public void testSerializationEtDeserialization() throws Exception {
        Concert concert = new Concert("E123", "Concert Test", LocalDateTime.now(), "Paris", 100, "Daft Punk", "Electro");

        EvenementSerialise.sauvegarder(java.util.List.of(concert), "test_event.json");

        Evenement[] loaded = EvenementSerialise.charger("test_event.json");

        assertEquals(1, loaded.length);
        assertEquals("Concert Test", loaded[0].getNom());

        // Nettoyage
        new File("test_event.json").delete();
    }
}