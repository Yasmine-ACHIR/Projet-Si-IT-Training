public class InterEntreprise extends Formation {

    private int nombreInscritMin;

    public InterEntreprise(String sujet, String contenu, double prix, String lienResponsable, String prequis, int nombreInscritMin) {
        super(sujet, contenu, prix, lienResponsable, prequis);
        this.nombreInscritMin = nombreInscritMin;
    }

    public int getNombreInscritMin() {
        return nombreInscritMin;
    }

    @Override
    boolean peutEnregistrer(Session session) {
        return session.getMaxParticipants() < nombreInscritMin;
    }
}
