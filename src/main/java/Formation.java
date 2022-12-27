import java.time.LocalDate;
import java.util.*;

public abstract class Formation {

    private String sujet;
    private String contenu;
    private double prix;
    private String lienResponsable;
    private String prequis;

    private List<Theme> themes = new ArrayList<>();

    public String getSujet() {
        return sujet;
    }

    public String getContenu() {
        return contenu;
    }

    public double getPrix() {
        return prix;
    }

    public String getLienResponsable() {
        return lienResponsable;
    }

    public String getPrequis() {
        return prequis;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    private List<Session> sessions = new ArrayList<>();

    public Formation(String sujet, String contenu, double prix, String lienResponsable, String prequis) {
        this.sujet = sujet;
        this.contenu = contenu;
        this.prix = prix;
        this.lienResponsable = lienResponsable;
        this.prequis = prequis;
    }

    public void attachToTheme(Theme theme) {
        Objects.requireNonNull(theme, "session");
        this.themes.add(theme);
        theme.ajouterFormation(this);
    }

    public void ajouterSession(Session session) {
        Objects.requireNonNull(session, "session");
        this.sessions.add(session);
    }

    abstract boolean peutEnregistrer(Session session);
    public Optional<Session> prochaineSession() {
        return this.sessions.stream().sorted(Comparator.comparing(Session::getDate))
                .filter(session -> session.getDate().isAfter(LocalDate.now()))
                .findFirst();
    }
}
