import java.util.ArrayList;
import java.util.List;

public class Client extends Personne{

    private final List<Session> sessions = new ArrayList<>();

    // getters & setters


    public void enregistrer(Session session) {
        session.enregistrerClient(this);
        this.sessions.add(session);
    }

}
