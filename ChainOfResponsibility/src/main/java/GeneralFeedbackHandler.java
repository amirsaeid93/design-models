public class GeneralFeedbackHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("Handling general feedback: " + message.getContent());
            System.out.println("Sender: " + message.getSenderEmail());
        } else {
            super.handle(message);
        }
    }
}