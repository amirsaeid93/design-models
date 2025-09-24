public class Computer {
    private String processor;
    private int ramSize; // in GB
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;


    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }


    public void showConfiguration() {
        System.out.println("Computer Configuration:");
        System.out.println("Processor: " + processor);
        System.out.println("RAM: " + ramSize + " GB");
        System.out.println("Hard Drive: " + hardDrive);
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println("Operating System: " + operatingSystem);
        System.out.println("------------------------");
    }
}
