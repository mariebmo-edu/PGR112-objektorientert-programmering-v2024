package service;

import model.Jewelry;
import repo.JewelryRepo;

import java.io.IOException;

public class JewelryService extends AbstractService<Jewelry>{

    private static JewelryService instance;

    private JewelryService() throws IOException {
        super(new JewelryRepo());
    }

    public static JewelryService getInstance() {
        if(instance == null){
            try {
                instance = new JewelryService();
            } catch (IOException e) {
                System.out.printf("Could not create instance of %s\n", JewelryService.class.getName());
            }
        }

        return instance;
    }
}
