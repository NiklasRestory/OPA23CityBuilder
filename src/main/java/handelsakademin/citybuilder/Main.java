package handelsakademin.citybuilder;

// To use a class of an object that is in a different package,
// I must import it. Like this.
import handelsakademin.citybuilder.buildings.Building;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("hello.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Hello!");
            bufferedWriter.write("Hello!\n");
            bufferedWriter.write("Hello!");
            bufferedWriter.write("Hello!");
            bufferedWriter.newLine();
            bufferedWriter.write("Hello!");
            bufferedWriter.write("Hello!");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader fileReader = new FileReader("hello.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        }
        catch (IOException e) {

        }


        CityBuilder cityBuilder = new CityBuilder();
        cityBuilder.menu();

        Building home = new Building( "gusgatan 2", 20, 1);
        // Using getters and setters instead of public variables.
        home.setFloorCount(3); // instead of home.floorCount = 3;
        System.out.println("Home floor count is " + home.getFloorCount()); // instead of home.floorCount;
        home.printInfo();
        Building home2 = new Building("gammelgatan 4", 30, 1);
        home2.printInfo();
    }
}