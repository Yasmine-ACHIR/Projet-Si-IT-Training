import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FormationTest {

    private Formation formation;

    @BeforeEach
    void setUp() {
        this.formation = new InterEntreprise("Formation Java",
                "Apprenez les bases de la programmation Java",
                500.0, "contact@formation.com",
                "Connaissances de base en programmation", 3);
    }

    @Test
    void testConstructor() {
        String sujet = "Formation Java";
        String contenu = "Apprenez les bases de la programmation Java";
        double prix = 500.0;
        String lienResponsable = "contact@formation.com";
        String prequis = "Connaissances de base en programmation";
        int nombreInscritMin = 3;

        InterEntreprise formation = new InterEntreprise(sujet, contenu, prix, lienResponsable, prequis, nombreInscritMin);

        assertEquals(sujet, formation.getSujet());
        assertEquals(contenu, formation.getContenu());
        assertEquals(prix, formation.getPrix(), 0.001);
        assertEquals(lienResponsable, formation.getLienResponsable());
        assertEquals(prequis, formation.getPrequis());
        assertEquals(nombreInscritMin, formation.getNombreInscritMin());
    }

    @Test
    void testAjouterSession() {
        Session session = new Session(LocalDate.of(2022, 1, 1), "Paris", 500.0, 10, formation);
        assertFalse(formation.getSessions().isEmpty());
        assertTrue(formation.getSessions().contains(session));
    }

    @Test
    void testProchaineSession() {
        Optional<Session> prochaineSession = formation.prochaineSession();
        assertFalse(prochaineSession.isPresent());

        Session session0 = new Session(LocalDate.now().minusDays(1), "Paris", 500.0, 10, formation);
        Session session1 = new Session(LocalDate.now().plusDays(1), "Paris", 500.0, 10, formation);
        Session session2 = new Session(LocalDate.now().plusDays(2), "Paris", 500.0, 10, formation);


        prochaineSession = formation.prochaineSession();
        assertTrue(prochaineSession.isPresent());
        assertEquals(session1, prochaineSession.get());

    }

    @Test
    void testAttachToTheme() {
        Theme theme = new Theme();
        formation.attachToTheme(theme);
        assertTrue(formation.getThemes().contains(theme));
        assertTrue(theme.getToutesFormations().contains(formation));
    }


}