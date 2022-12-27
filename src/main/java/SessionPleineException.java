public class SessionPleineException extends RuntimeException {
    public SessionPleineException(Session session) {
        super("La session : " + session + " est pleine");
    }
}
