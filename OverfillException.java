public class OverfillException extends Exception {
    private int limitValue;
    public OverfillException(String message) {
        super(message);
        this.limitValue = limitValue;
    }
}
