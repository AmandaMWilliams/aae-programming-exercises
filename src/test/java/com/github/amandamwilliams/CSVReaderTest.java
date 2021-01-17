package com.github.amandamwilliams;

import org.junit.Assert;
import org.junit.Test;

public class CSVReaderTest {

    @Test
    public void toStringTest(){
        //given
        String currentProjectDirectory= System.getProperty("user.dir");
        String fileName = currentProjectDirectory
                .concat("\\src")
                .concat("\\main")
                .concat("\\resources")
                .concat("\\basket.csv");
        CSVReader csvReader = new CSVReader(fileName);
        System.out.println(fileName);
        String expected = "fruit,days,characteristic1,characteristic2\n" +
                "apple,1, red, sweet\n" +
                "orange,2, round, sweet\n" +
                "pineapple,5, prickly, sweet\n" +
                "apple,4, yellow, sweet\n" +
                "grapefruit,2, yellow, bitter\n" +
                "watermelon,4, green, heavy\n" +
                "orange,2, round, sweet\n" +
                "orange,1, round, sweet\n" +
                "pineapple,6, prickly, sweet\n" +
                "apple,1, green, tart\n" +
                "grapefruit,1,bitter,yellow\n" +
                "watermelon,2, heavy, green\n" +
                "grapefruit,2, bitter, yellow\n" +
                "watermelon,3, heavy, green\n" +
                "orange,1, round, sweet\n" +
                "orange,5, sweet, round\n" +
                "pineapple,2, sweet, prickly\n" +
                "apple,2, red, sweet\n" +
                "orange,6, round, sweet\n" +
                "pineapple,2, sweet, prickly\n" +
                "apple,1, red, sweet\n" +
                "grapefruit,3, yellow, bitter";
        //when
        String actual = csvReader.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLine0Test(){
        //given
        String currentProjectDirectory= System.getProperty("user.dir");
        String fileName = currentProjectDirectory
                .concat("\\src")
                .concat("\\main")
                .concat("\\resources")
                .concat("\\basket.csv");
        CSVReader csvReader = new CSVReader(fileName);
        String expected = "fruit,days,characteristic1,characteristic2";
        //when
        String actual = csvReader.getLine(0);
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLine2Test(){
        //given
        String currentProjectDirectory= System.getProperty("user.dir");
        String fileName = currentProjectDirectory
                .concat("\\src")
                .concat("\\main")
                .concat("\\resources")
                .concat("\\basket.csv");
        CSVReader csvReader = new CSVReader(fileName);
        String expected = "orange,2, round, sweet";
        //when
        String actual = csvReader.getLine(2);
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLastLineTest(){
        //given
        String currentProjectDirectory= System.getProperty("user.dir");
        String fileName = currentProjectDirectory
                .concat("\\src")
                .concat("\\main")
                .concat("\\resources")
                .concat("\\basket.csv");
        CSVReader csvReader = new CSVReader(fileName);
        String expected = "grapefruit,3, yellow, bitter";
        //when
        String actual = csvReader.getLastLine();
        //then
        Assert.assertEquals(expected,actual);
    }
}
