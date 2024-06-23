package service;

import model.Coin;
import repo.AbstractRepo;
import repo.CoinRepo;

import java.io.IOException;

public class CoinService extends AbstractService<Coin>{

    private static CoinService instance;

    public CoinService() throws IOException {
        super(new CoinRepo());
    }

    public static CoinService getInstance() {
        if(instance == null){
            try {
                instance = new CoinService();
            } catch (IOException e) {
                System.out.printf("Could not create instance of %s\n", CoinService.class.getName());
            }
        }

        return instance;
    }
}
