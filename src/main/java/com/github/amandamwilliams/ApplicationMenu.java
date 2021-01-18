package com.github.amandamwilliams;

import java.util.Scanner;

public class ApplicationMenu {

        private FruitExtractor fruitExtractor;

        public ApplicationMenu(String fileName) {
            this.fruitExtractor = new FruitExtractor(fileName);
        }

        public ApplicationMenu() {
            String currentProjectDirectory = System.getProperty("user.dir");
            String fileName = currentProjectDirectory
                    .concat("\\src")
                    .concat("\\main")
                    .concat("\\resources")
                    .concat("\\basket.csv");
            this.fruitExtractor = new FruitExtractor(fileName);
        }

        public String run() {
            System.out.println("Welcome to the CSV Basket Extractor Application");
            System.out.println("From here, you can select any of the following options:");
            System.out.println("1. Print total number of fruit");
            System.out.println("2. Print number of types fruit");
            System.out.println("3. Print each type of fruit in descending order");
            System.out.println("4. Print characteristics of each fruit by type");
            System.out.println("5. Print fruit over 3 days old");
            System.out.println("6. Quit");
            Scanner scanner = new Scanner(System.in);
            String userInputAsString = scanner.nextLine();
            Integer userInputAsInteger = Integer.parseInt(userInputAsString);
            switch (userInputAsInteger) {
                case 1:
                    fruitExtractor.printTotalNumberOfFruit();
                    break;

                case 2:
                    fruitExtractor.printNumberOfTypesOfFruit();
                    break;

                case 3:
                    fruitExtractor.printNumberOfEachTypeOfFruitInDescendingOrder();
                    break;

                case 4:
                    fruitExtractor.printCharacteristicsOfEachFruitByType();
                    break;

                case 5:
                    fruitExtractor.printAllFruitOlderThan(3);
                    break;

                case 6:
                    System.out.println("Exiting system!");
                    return "QUIT";

                default:
                    System.out.println("Invalid input!");
                    System.out.println("Try again!");
                    run();
            }
            return null;
        }
}
