package com.bike.maraton.csv;

import org.junit.Test;

import java.io.IOException;


public class CSVReaderTest {

    @Test
    public void readFile() throws IOException {
        String filePath = "src/test/resources/ALL_USERS_UTF-8.csv";
        CSVReader reader = new CSVReader();
        reader.readFile(filePath);
    }

}