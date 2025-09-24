public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director1 = new ComputerDirector(gamingBuilder);
        Computer gamingComputer = director1.constructComputer();
        gamingComputer.showConfiguration();


        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector director2 = new ComputerDirector(officeBuilder);
        Computer officeComputer = director2.constructComputer();
        officeComputer.showConfiguration();
    }
}
