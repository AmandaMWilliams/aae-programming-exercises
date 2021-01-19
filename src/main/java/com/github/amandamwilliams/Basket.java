package com.github.amandamwilliams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Basket {
    private List<Fruit> fruitList;

    public Basket(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public Basket() {
        this.fruitList = new ArrayList<>();
    }

    public void addFruit(Fruit fruit) {
        fruitList.add(fruit);
    }

    public Integer getTotalFruitCount() {
        return fruitList.size();
    }

    public List<String> getTypesOfFruit() {
        List<String> list = new ArrayList<>();
        for (Fruit fruit : this.fruitList) {
            String typeOfFruit = fruit.getFruit();
            boolean alreadyContainsFruit = list.contains(typeOfFruit);
            if (!alreadyContainsFruit) {
                list.add(typeOfFruit);
            }
        }
        return list;
    }

    public List<Fruit> getFruitsByType(String fruitType) {
        List<Fruit> result = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            if (fruit.getFruit().equalsIgnoreCase(fruitType)) {
                result.add(fruit);
            }
        }
        return result;
    }

    public String getCharacteristicsOfFruit(String fruitType) {
        List<Fruit> fruitList = getFruitsByType(fruitType);
        Integer numberOfFruit = fruitList.size();
        Fruit someFruit = fruitList.get(0);
        return someFruit.getString(numberOfFruit);
    }

    public List<String> getCharacteristicsOfEachFruit() {
        List<String> result = new ArrayList<>();
        for (String fruitType : getTypesOfFruit()) {
            result.add(getCharacteristicsOfFruit(fruitType));
        }
        return result;
    }

    public List<Fruit> getFruitOlderThan(Integer numberOfDays) {
        List<Fruit> result = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            Integer daysInBasket = fruit.getDays();
            if (daysInBasket >= numberOfDays) {
                result.add(fruit);
            }
        }
        return result;
    }

    public Map<String, Integer> getNumberOfOccurrencesOfEachFruit(List<String> typesOfFruit){
        Map<String, Integer> numberOfOccurrenceMap = new HashMap<>();
        String fruitName = "";
        Integer numberOfFruit = 0;
        for (Fruit fruit : fruitList) {
            fruitName = getTypesOfFruit().toString();
            numberOfFruit++;
           // numberOfFruit = getFruitsByType(fruitName).size();
            numberOfOccurrenceMap.put(fruitName, numberOfFruit);
        }
        return numberOfOccurrenceMap;

    }
}
