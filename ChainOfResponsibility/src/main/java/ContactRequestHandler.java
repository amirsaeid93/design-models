public class ContactRequestHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Handling contact request: " + message.getContent());
            System.out.println("Sender: " + message.getSenderEmail());
        } else {
            super.handle(message);
        }
    }
}