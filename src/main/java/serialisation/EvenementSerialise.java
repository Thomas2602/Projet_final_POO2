package serialisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Evenement;

import java.io.File;
import java.io.IOException;
import java.util.Collection;


public class EvenementSerialise {
	private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static void sauvegarder(Collection<Evenement> evenements, String cheminFichier) throws IOException {
        mapper.writeValue(new File(cheminFichier), evenements);
    }

    public static Evenement[] charger(String cheminFichier) throws IOException {
        return mapper.readValue(new File(cheminFichier), Evenement[].class);
    }
}
