package service;

import model.Museum;
import repo.MuseumRepo;

import java.io.IOException;

public class MuseumService extends AbstractService<Museum>{

    private static MuseumService instance;

    private MuseumService() throws IOException {
        super(new MuseumRepo());
    }

    public static MuseumService getInstance() {
        if(instance == null){
            try {
                instance = new MuseumService();
            } catch (IOException e) {
                System.out.printf("Could not create instance of %s\n", MuseumService.class.getName());
            }
        }

        return instance;
    }
}
