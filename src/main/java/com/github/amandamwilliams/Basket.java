package com.github.amandamwilliams;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Fruit> fruitList;

    public Basket(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public Basket() {
        this.fruitList = new ArrayList<>();
    }

    public void addFruit(Fruit fruit){
        fruitList.add(fruit);
    }

    public Integer getTotalFruitCount(){
        return fruitList.size();
    }


}
