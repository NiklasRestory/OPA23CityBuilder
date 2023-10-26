package handelsakademin.citybuilder;

import com.google.gson.Gson;
import handelsakademin.citybuilder.buildings.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CityBuilder {

    ArrayList<Building> buildingList = new ArrayList<>();
    // Scanner on the outside here lets all functions in this class use it.
    Scanner scanner = new Scanner(System.in);

    public CityBuilder() {
        // buildingList = databaseContext.getBuildings();
        buildingList.add(new Building("Husgatan 2", 50, 2));
        buildingList.add(new Building("Liljevägen 6", 500, 10));
        buildingList.add(new Building("Guldgatan 3", 76, 1));

        Appartment appartment = new Appartment("Liljevägen 1", 25, 2);
        appartment.printInfo();
        System.out.println("Appartment number: " + appartment.getAppartmentNumber());
        Building b = appartment;

        buildingList.add(appartment);
        buildingList.add(new Appartment("Liljevägen 1", 27, 3));

        try {
            FileWriter fileWriter = new FileWriter("buildings");
            BufferedWriter bf = new BufferedWriter(fileWriter);
            for (Building building : buildingList) {
                Gson gson = new Gson();
                System.out.println(gson.toJson(building));
                Building building1 = gson.fromJson(gson.toJson(building), Building.class);
                building1.printInfo();
            }
            bf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
    boolean running = true;
    public void menu() {
        while (running) {
            System.out.println("What would you like to do?");
            System.out.println("1. List all buildings.");
            System.out.println("2. Add building.");
            System.out.println("3. Add appartment.");
            System.out.println("4. Remove building.");
            System.out.println("5. Quit.");
            String input = scanner.nextLine();

            // switch case goes to a case that matches the value of
            // the variable we send into the switch-statement.
            switch (input) {
                case "1":
                    listBuildings();
                    break;
                case "2":
                    addBuilding();
                    break;
                case "3":
                    addAppartmentBuilding();
                    break;
                case "4":
                    deleteBuilding();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("That was not an option.");
                    break;
            }
        }
    }



    // To add a new object, we need to insert all the variables. This could likely be done in a form
    // if we had graphics, but we don't have that in a console application.
    // I'm using scanner to read in all the values. Now, I needed to write two numbers. After
    // writing the code to obtain the numbers, I noticed that the code for them was very similar.
    // When we find code that is very similar, we want to make a function out of it. Reuse code.
    private void addBuilding() {
        System.out.println("What address?");
        String address = scanner.nextLine();

        // I send along the message as well as the name of my variable,
        // because I found those to be the two things that was different between
        // the two times I did the code.
        int area = getPositiveNumberFromUser("What area in square meters?","Area");
        int floorCount = getPositiveNumberFromUser("How many floors?", "Floor Count");

        // After obtaining all the variables, I can finally create the object.
        buildingList.add(new Building(address, area, floorCount));
        System.out.println("Building successfully added.");
    }

    private void addAppartmentBuilding() {
        System.out.println("What address?");
        String address = scanner.nextLine();
        int area = getPositiveNumberFromUser("What area in square meters?","Area");
        int appartmentNumber = getPositiveNumberFromUser("What appartment number?", "AppartmentNr");

        buildingList.add(new Appartment(address, area, appartmentNumber));
        System.out.println("Building successfully added.");
    }

    // When extracting code into functions, do take a careful look what parts
    // do differ. In my case, it was simply what I printed for messages to
    // the user. Those are things that can be sent along as parameters.
    public int getPositiveNumberFromUser(String message, String varName) {
        int number = -1;
        System.out.println(message);

        // I trap the user in a loop until they can give me a valid number.
        while (number < 0) {
            // Because parseInt can crash, I put them in a try-catch.
            // It will first attempt to execute the code inside the try.
            // If the contents of try crashes, the code in catch will be executed instead.
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input); // turns a string into an int. Crashes if the string isn't numbers.
                if (number < 0) { // I did make negative values unacceptable. Only fair I tell the user.
                    System.out.println(varName + " cannot be negative.");
                }
            }
            catch (Exception ex) {
                System.out.println(varName + " in numbers, please.");
            }
        }
        return number;
    }

    // Loops through the buildings in buildingList and prints their info.
    private void listBuildings() {
        for (Building building : buildingList) {
            building.printInfo();
        }
    }

    private void deleteBuilding() {
        boolean found = false;
        listBuildings();
        int idToRemove = getPositiveNumberFromUser("What building would you like to delete? Give its id.", "id");

        // for-loop. Creates an iterator i. It will loop as long as i is less than the
        // number of items inside buildingList, found out with the size() function.
        // At the end of each loop, i will increase by one via i++.
        for (int i = 0; i < buildingList.size(); i++) {
            // Building building = buildingList.get(i);
            // if (building.getId() == idToRemove) {
            if (buildingList.get(i).getId() == idToRemove) { // This is identical to the two rows above. First get the building at that index, then check if it has the id we want to remove.
                buildingList.remove(i); // If so, remove it.
                System.out.println("Building " + idToRemove + " successfully removed.");
                found = true;
                break;
            }
        }
        // if (found == false) {
        if (!found) { // This is an alternative to the above row. ! before a boolean flips its value. true becomes false, vice versa.
            System.out.println("No building with that id found.");
        }
    }
}
