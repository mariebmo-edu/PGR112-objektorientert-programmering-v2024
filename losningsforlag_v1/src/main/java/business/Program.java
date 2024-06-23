package business;

import model.Item;
import model.Museum;
import model.Person;
import service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    // class for a menu
    PersonService personService;
    MuseumService museumService;
    CoinService coinService;
    JewelryService jewelryService;
    WeaponService weaponService;

    ArrayList<Person> people = new ArrayList<>();
    ArrayList<Museum> museums = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();

    public Program() {
        personService = PersonService.getInstance();
        museumService = MuseumService.getInstance();
        coinService = CoinService.getInstance();
        jewelryService = JewelryService.getInstance();
        weaponService = WeaponService.getInstance();

        getAllFromDatabase();
    }

    public void getAllFromDatabase(){
        people = personService.getAll();
        museums = museumService.getAll();

        items.addAll(coinService.getAll());
        items.addAll(jewelryService.getAll());
        items.addAll(weaponService.getAll());
    }

    public void printMenu(){
        System.out.println("1. Se informasjon om alle funngjenstander.");
        System.out.println("2. Se informasjon om alle funngjenstander eldre enn <årstall>.");
        System.out.println("3. Få informasjon om antall funngjenstander registrert.");
        System.out.println("Q. Avslutte programmet.");
    }

    public void run(){
        printMenu();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while(!input.equalsIgnoreCase("Q")){
            switch(input){
                case "1" -> {
                    printAllItems();
                }
                case "2" -> {
                    printItemsOlderThanMenuHandler(scanner);
                }
                case "3" -> {
                    printNumberOfItems();
                }
                default -> {
                    System.out.println("Ugyldig input. Prøv igjen.");
                }
            }
            printMenu();
            input = scanner.nextLine();
        }
    }

    public void printAllItems(){
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void printItemsOlderThanMenuHandler(Scanner scanner){
        System.out.println("Skriv inn årstall:");
        String yearInput = scanner.nextLine();

        while(Integer.parseInt(yearInput) < 0 || Integer.parseInt(yearInput) > 2024){
            System.out.println("Ugyldig input. Prøv igjen.");
            yearInput = scanner.nextLine();
        }

        printItemsOlderThan(Integer.parseInt(yearInput));
    }

    public void printItemsOlderThan(int year){
        for (Item item : items) {
            if(item.getEstimatedYear() < year){
                System.out.println(item);
            }
        }
    }

    public void printNumberOfItems(){
        System.out.println("Antall funngjenstander: " + items.size());
    }
}
