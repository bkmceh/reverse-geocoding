package inforest.reversegeocoding.server.exception;

public class ResponseException {

    private final String message;

    public ResponseException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
