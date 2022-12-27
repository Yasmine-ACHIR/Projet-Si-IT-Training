import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Session {
    private LocalDate date;
    private String lieu;
    private double prix;
    private int maxParticipants;

    private final Formation formation;
    private List<Client> clients = new ArrayList<>();

    private Formateur formateur;
    public Session(LocalDate date, String lieu, double prix, int maxParticipants, Formation formation) {
        this.date = date;
        this.lieu = lieu;
        this.prix = prix;
        this.maxParticipants = maxParticipants;

        //
        this.formation = formation;
        this.formation.ajouterSession(this);
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void enregistrerClient(Client client) {
        if (maxParticipants < this.clients.size()) {
            throw new SessionPleineException(this);
        }
        this.clients.add(client);
    }

    public void annuler() {
        this.clients.forEach(this::prevenir);
        prevenir(this.formateur);
        System.out.println("la reservation est annuler !!");
    }

    private void prevenir(Object obj) {
        System.out.println("dest : " + obj + " La formation est annuler");
    }
}
