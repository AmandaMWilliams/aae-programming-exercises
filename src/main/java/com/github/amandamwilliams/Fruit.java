package com.github.amandamwilliams;

public class Fruit {
    private String fruit;
    private Integer days;
    private String characteristic1;
    private String characteristic2;

    public Fruit(String fruit, Integer days, String characteristic1, String characteristic2) {
        this.fruit = fruit;
        this.days = days;
        this.characteristic1 = characteristic1;
        this.characteristic2 = characteristic2;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getCharacteristic1() {
        return characteristic1;
    }

    public void setCharacteristic1(String characteristic1) {
        this.characteristic1 = characteristic1;
    }

    public String getCharacteristic2() {
        return characteristic2;
    }

    public void setCharacteristic2(String characteristic2) {
        this.characteristic2 = characteristic2;
    }

    public String getString(Integer numberOfFruit) {
        return String.format("%s %s: %s, %s", numberOfFruit, fruit, characteristic1, characteristic2);
    }
}
