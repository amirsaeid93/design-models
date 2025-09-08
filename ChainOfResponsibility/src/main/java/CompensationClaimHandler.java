public class CompensationClaimHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("Handling compensation claim: " + message.getContent());
            System.out.println("Sender: " + message.getSenderEmail());
        } else {
            super.handle(message);
        }
    }
}