package gseminar;

public class RequiredValueMissingException extends RuntimeException {
    public RequiredValueMissingException(String message) {
        super(message);
    }
}
