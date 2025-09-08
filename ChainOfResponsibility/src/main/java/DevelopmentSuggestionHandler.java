public class DevelopmentSuggestionHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Handling development suggestion: " + message.getContent());
            System.out.println("Sender: " + message.getSenderEmail());
        } else {
            super.handle(message);
        }
    }
}