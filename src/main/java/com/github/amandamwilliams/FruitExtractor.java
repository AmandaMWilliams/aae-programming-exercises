package com.github.amandamwilliams;

import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < csvFileLines.length; i++) {
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


}
