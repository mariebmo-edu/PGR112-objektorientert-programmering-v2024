package service;

import model.Person;
import repo.PersonRepo;

import java.io.IOException;

public class PersonService extends AbstractService<Person> {

    private static PersonService instance;

    private PersonService() throws IOException {
        super(new PersonRepo());
    }

    public static PersonService getInstance() {
        if(instance == null){
            try {
                instance = new PersonService();
            } catch (IOException e) {
                System.out.printf("Could not create instance of %s\n", PersonService.class.getName());
            }
        }

        return instance;
    }
}
