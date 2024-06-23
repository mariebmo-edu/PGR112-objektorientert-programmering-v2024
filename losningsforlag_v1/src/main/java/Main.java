import business.FunnFileReader;
import business.Program;
import business.Registration;

public class Main {

    public static void main(String[] args) {

        /*Only needs to run the first time to populate the DB*/

        /*
        FunnFileReader funnFileReader = new FunnFileReader();
        try {
            funnFileReader.readModelsFromFile("src/main/resources/funn.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
                Registration registration = new Registration();
        registration.registerPeople(funnFileReader.getPeople());
        registration.registerMuseums(funnFileReader.getMuseums());
        registration.registerItems(funnFileReader.getItems());
         */

        Program program = new Program();
        program.run();
    }
}
