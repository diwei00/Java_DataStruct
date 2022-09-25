public class NullQueueExpection extends RuntimeException{
    public NullQueueExpection() {
        super();
    }

    public NullQueueExpection(String message) {
        super(message);
    }
}
