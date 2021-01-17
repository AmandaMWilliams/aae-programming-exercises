package com.github.amandamwilliams;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CSVReader {
    private File file;

    public CSVReader(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        }catch(IOException e){
            throw new Error(e);
        }
        return result
                .toString()
                .replaceAll("\n$", "");
    }

    public String[] getLines() {
        return toString().split("\n");
    }

    public String getLine(Integer lineNumber){
        return getLines()[lineNumber];
    }

    public String getLastLine() {
        return getLine(this.getLines().length-1);
    }
}
