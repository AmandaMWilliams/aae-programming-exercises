package com.github.amandamwilliams;

import java.io.File;
import java.util.List;

public class CSVReader {
    private File file;

    public CSVReader(String fileName) {
        this.file = new File(fileName);
    }

    public String fileToString() {
        return null; // TODO
    }

    public String[] getLines() {
        return fileToString().split("\n");
    }
}
