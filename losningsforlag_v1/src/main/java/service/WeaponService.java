package service;

import model.Weapon;
import repo.WeaponRepo;

import java.io.IOException;

public class WeaponService extends AbstractService<Weapon>{

    private static WeaponService instance;

    private WeaponService() throws IOException {
        super(new WeaponRepo());
    }

    public static WeaponService getInstance() {
        if(instance == null){
            try {
                instance = new WeaponService();
            } catch (IOException e) {
                System.out.printf("Could not create instance of %s\n", WeaponService.class.getName());
            }
        }

        return instance;
    }
}
