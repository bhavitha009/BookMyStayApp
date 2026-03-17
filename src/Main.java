import java.io.*;
import java.util.*;

public class Main {

    static String fileName = "inventory.txt";

    public static void main(String[] args) {

        System.out.println("System Recovery");

        Map<String, Integer> inventory = loadData();

        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.get("Single"));
        System.out.println("Double: " + inventory.get("Double"));
        System.out.println("Suite: " + inventory.get("Suite"));

        saveData(inventory);
    }

    // Load inventory from file
    public static Map<String, Integer> loadData() {

        Map<String, Integer> inventory = new HashMap<>();

        try {
            File file = new File(fileName);

            if (!file.exists()) {
                throw new Exception();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));

            inventory.put("Single", Integer.parseInt(br.readLine()));
            inventory.put("Double", Integer.parseInt(br.readLine()));
            inventory.put("Suite", Integer.parseInt(br.readLine()));

            br.close();

            System.out.println("Inventory loaded successfully.");

        } catch (Exception e) {

            System.out.println("No valid inventory data found. Starting fresh.");

            inventory.put("Single", 5);
            inventory.put("Double", 3);
            inventory.put("Suite", 2);
        }

        return inventory;
    }

    // Save inventory to file
    public static void saveData(Map<String, Integer> inventory) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            bw.write(inventory.get("Single") + "\n");
            bw.write(inventory.get("Double") + "\n");
            bw.write(inventory.get("Suite") + "\n");

            bw.close();

            System.out.println("Inventory saved successfully.");

        } catch (Exception e) {
            System.out.println("Error saving inventory.");
        }
    }
}