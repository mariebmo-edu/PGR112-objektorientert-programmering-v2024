package business;

import model.*;
import repo.*;

import java.util.ArrayList;

public class Registration {

    PersonRepo personRepo;
    MuseumRepo museumRepo;
    JewelryRepo jewelryRepo;
    CoinRepo coinRepo;
    WeaponRepo weaponRepo;

    public Registration() {
        try {
            personRepo = new PersonRepo();
            museumRepo = new MuseumRepo();
            jewelryRepo = new JewelryRepo();
            coinRepo = new CoinRepo();
            weaponRepo = new WeaponRepo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void registerPeople(ArrayList<Person> people) {
        for (Person person : people) {
            personRepo.insert(person);
        }
    }

    public void registerMuseums(ArrayList<Museum> museums) {
        for (Museum museum : museums) {
            museumRepo.insert(museum);
        }
    }

    public void registerItems(ArrayList<Item> items) {
        for (Item item : items) {
            if (item instanceof Coin) {
                coinRepo.insert((Coin) item);
            } else if (item instanceof Jewelry) {
                jewelryRepo.insert((Jewelry) item);
            } else if (item instanceof Weapon) {
                weaponRepo.insert((Weapon) item);
            }
        }
    }
}
