package business;

import model.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

public class FunnFileReader {

    ArrayList<Person> people = new ArrayList<>();
    ArrayList<Museum> museums = new ArrayList<>();

    //this can contain all types of items
    ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Person> getPeople() {
        return people;
    }

    public ArrayList<Museum> getMuseums() {
        return museums;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void readModelsFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(filename));

        ArrayList<String> lines = new ArrayList<>();
        int amount = 0;

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();

            switch(currentLine){
                case "Personer:" -> {
                    amount = Integer.parseInt(scanner.nextLine());
                    AddPeople(scanner, amount);
                }
                case "Museer:" -> {
                    amount = Integer.parseInt(scanner.nextLine());
                    AddMuseums(scanner, amount);
                }
                case "Funn:" -> {
                    AddItems(scanner);
                }
            }
        }
    }

    public void AddPeople(Scanner scanner, int amount){
        for (int i = 0; i < amount; i++) {
            ArrayList<String> lines = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                lines.add(scanner.nextLine());
            }
            people.add(createPerson(lines));
        }
    }

    public void AddMuseums(Scanner scanner, int amount){
        for (int i = 0; i < amount; i++) {

            ArrayList<String> lines = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                lines.add(scanner.nextLine());
            }
            museums.add(createMuseum(lines));
        }
    }

    public void AddItems(Scanner scanner){
        while (scanner.hasNextLine()) {
            ArrayList<String> lines = new ArrayList<>();

            String line = scanner.nextLine();

            while(!line.equals("-------")){
                lines.add(line);
                line = scanner.nextLine();
            }

            switch(lines.get(6)){
                case "Mynt" -> items.add(createCoin(lines));
                case "Smykke" -> items.add(createJewelry(lines));
                case "Våpen" -> items.add(createWeapon(lines));
            }
        }
    }

    public Person createPerson(ArrayList<String> lines) {
        int id = Integer.parseInt(lines.get(0));
        String name = lines.get(1);
        String phone = lines.get(2);
        String email = lines.get(3);

        return new Person(id, name, phone, email);
    }

    public Museum createMuseum(ArrayList<String> lines) {
        int id = Integer.parseInt(lines.get(0));
        String name = lines.get(1);
        String address = lines.get(2);

        return new Museum(id, name, address);
    }

    public Coin createCoin(ArrayList<String> lines) {
        int id = Integer.parseInt(lines.get(0));
        String coordinates = lines.get(1);
        int finderId = Integer.parseInt(lines.get(2));
        LocalDate foundDate = FormatDate(lines.get(3));
        int estimatedYear = Integer.parseInt(lines.get(4));

        String museumIdString = lines.get(5);
        int museumId = museumIdString.isEmpty() ? -1 : Integer.parseInt(museumIdString);

        int diameter = Integer.parseInt(lines.get(7));
        String metal = lines.get(8);

        return new Coin(id, coordinates, finderId, foundDate, estimatedYear, museumId, diameter, metal);
    }

    public Jewelry createJewelry(ArrayList<String> lines) {
        int id = Integer.parseInt(lines.get(0));
        String coordinates = lines.get(1);
        int finderId = Integer.parseInt(lines.get(2));
        LocalDate foundDate = FormatDate(lines.get(3));
        int estimatedYear = Integer.parseInt(lines.get(4));

        String museumIdString = lines.get(5);
        int museumId = museumIdString.isEmpty() ? -1 : Integer.parseInt(museumIdString);

        String category = lines.get(7);
        int valueEstimate = Integer.parseInt(lines.get(8));
        String imgName = lines.get(9);

        return new Jewelry(id, coordinates, finderId, foundDate, estimatedYear, museumId, category, valueEstimate, imgName);
    }

    public Weapon createWeapon(ArrayList<String> lines) {
        int id = Integer.parseInt(lines.get(0));
        String coordinates = lines.get(1);
        int finderId = Integer.parseInt(lines.get(2));
        LocalDate foundDate = FormatDate(lines.get(3));
        int estimatedYear = Integer.parseInt(lines.get(4));

        String museumIdString = lines.get(5);
        int museumId = museumIdString.isEmpty() ? -1 : Integer.parseInt(museumIdString);

        String type = lines.get(7);
        String material = lines.get(8);
        int weight = Integer.parseInt(lines.get(9));

        return new Weapon(id, coordinates, finderId, foundDate, estimatedYear, museumId, type, material, weight);
    }

    public LocalDate FormatDate(String dateString){
        String[] dateParts = dateString.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        return LocalDate.of(year, month, day);
    }

    public void PrintEverything(){
        for (Person person : people) {
            System.out.println(person);
        }

        for (Museum museum : museums) {
            System.out.println(museum);
        }

        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void AddPersonToDatabase(Person person){

    }
}
