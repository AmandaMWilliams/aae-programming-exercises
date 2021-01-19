package com.github.amandamwilliams;

import java.util.*;

/**
 * Extracts fruit from CSVReader and injects them into the Basket
 */
public class FruitExtractor {
    private CSVReader reader;

    public FruitExtractor(String filename) {
        this.reader = new CSVReader(filename);
    }

    public List<Fruit> extractAllFruit() {
        List<Fruit> result = new ArrayList<>();
        String[] csvFileLines = reader.getLines();
        for (int i = 1; i < csvFileLines.length; i++) {
            String csvFileLine = csvFileLines[i]; //apple,1, red, sweet
            String[] fields = csvFileLine.split(",");
            String fruitName = fields[0];
            String ageOfFruitAsString = fields[1];
            Integer ageOfFruitAsInteger = Integer.parseInt(ageOfFruitAsString);
            String characteristic1OfFruit = fields[2];
            String characteristic2OfFruit = fields[3];
            Fruit fruit = new Fruit(fruitName, ageOfFruitAsInteger, characteristic1OfFruit, characteristic2OfFruit);
            result.add(fruit);
        }
        return result;
    }

    public Basket getBasket() {
        return new Basket(extractAllFruit());
    }

    public void printTotalNumberOfFruit(){
        Integer totalNumberOfFruit = getBasket().getTotalFruitCount();
        String prefix = "Total number of fruit: ";
        String output = prefix + totalNumberOfFruit;
        System.out.println(output);
    }

    public void printNumberOfTypesOfFruit() {
        Integer totalNumberOfFruit = getBasket().getTypesOfFruit().size();
        String prefix = "Types of fruit: ";
        String output = prefix + totalNumberOfFruit;
        System.out.println(output);
    }


    public void printNumberOfEachTypeOfFruitInDescendingOrder() {
        StringBuilder result = new StringBuilder();
        Basket basket = getBasket();
        List<String> typesOfFruit = basket.getTypesOfFruit();
        System.out.println(basket.getNumberOfOccurrencesOfEachFruit());

        //Convert typesOfFruit to map
//        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
//
//        typesOfFruit.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
//        result
//                .append("The following is the numof of each type of fruit in descending order:\n")
//                .append(result);
    }

    public void printCharacteristicsOfEachFruitByType() {
        StringBuilder result = new StringBuilder();
        Basket basket = getBasket();
        List<String> typesOfFruit = basket.getTypesOfFruit();
        Collections.sort(typesOfFruit);
        for (String currentFruitType : typesOfFruit) {
            List<Fruit> fruitsOfCurrentType = basket.getFruitsByType(currentFruitType);
            Integer numberOfFruitOfCurrentType = fruitsOfCurrentType.size();
            Fruit instanceOfCurrentFruit = fruitsOfCurrentType.get(0);
            String characteristic1 = instanceOfCurrentFruit.getCharacteristic1();
            String characteristic2 = instanceOfCurrentFruit.getCharacteristic2();
            result
                    .append(numberOfFruitOfCurrentType)
                    .append(" ")
                    .append(currentFruitType)
                    .append(": ")
                    .append(characteristic1)
                    .append(", ")
                    .append(characteristic2)
                    .append("\n");
        }

        String output = result
                .toString()
                .replaceAll("\n$", "");

        System.out.println(output);
    }

    public void printAllFruitOlderThan(Integer numberOfDays) {
        StringBuilder result = new StringBuilder();
        Basket basket = getBasket();
        List<Fruit> oldFruitList = basket.getFruitOlderThan(numberOfDays);
        Basket oldFruitBasket = new Basket(oldFruitList);
        List<String> oldFruitTypes = oldFruitBasket.getTypesOfFruit();
        result.append("The following is a list of the fruit older than " + numberOfDays + ": \n");
        for (String oldFruitType : oldFruitTypes) {
            List<Fruit> currentOldFruitTypeInstancesList = oldFruitBasket.getFruitsByType(oldFruitType);
            Integer numberOfOldFruitOfCurrentType = currentOldFruitTypeInstancesList.size();
            result.append(numberOfOldFruitOfCurrentType);
            result.append(" ");
            result.append(oldFruitType);
            result.append(" and ");
        }

        String output = result
                .toString()
                .replaceAll("and $", "");

        System.out.println(output);
    }

}
