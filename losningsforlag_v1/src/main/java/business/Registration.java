package business;

import model.*;
import repo.*;
import service.*;

import java.util.ArrayList;

public class Registration {

    PersonService personService;
    MuseumService museumService;
    CoinService coinService;
    JewelryService jewelryService;
    WeaponService weaponService;

    public Registration() {
        personService = PersonService.getInstance();
        museumService = MuseumService.getInstance();
        coinService = CoinService.getInstance();
        jewelryService = JewelryService.getInstance();
        weaponService = WeaponService.getInstance();
    }

    public void registerPeople(ArrayList<Person> people) {
        personService.insertList(people);
    }

    public void registerMuseums(ArrayList<Museum> museums) {
        museumService.insertList(museums);
    }

    public void registerItems(ArrayList<Item> items) {
        for (Item item : items) {
            if (item instanceof Coin) {
                coinService.insert((Coin) item);
            } else if (item instanceof Jewelry) {
                jewelryService.insert((Jewelry) item);
            } else if (item instanceof Weapon) {
                weaponService.insert((Weapon) item);
            }
        }
    }
}
