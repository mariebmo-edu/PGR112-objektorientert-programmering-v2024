import business.FunnFileReader;
import business.Registration;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        FunnFileReader funnFileReader = new FunnFileReader();
        try {
            funnFileReader.readModelsFromFile("src/main/resources/funn.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        funnFileReader.PrintEverything();

        Registration registration = new Registration();
        registration.registerPeople(funnFileReader.getPeople());
        registration.registerMuseums(funnFileReader.getMuseums());
        registration.registerItems(funnFileReader.getItems());
    }
}
