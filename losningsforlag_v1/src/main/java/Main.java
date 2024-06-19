import business.FunnFileReader;

import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        FunnFileReader funnFileReader = new FunnFileReader();
        try {
            funnFileReader.read("src/main/resources/funn.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        funnFileReader.PrintEverything();
    }
}
