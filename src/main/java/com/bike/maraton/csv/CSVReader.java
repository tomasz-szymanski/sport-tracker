package com.bike.maraton.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class CSVReader {

    public void readFile(String filePath) throws IOException {
        File toRead = new File(filePath);
        CSVParser parser = CSVParser.parse(toRead, Charset.defaultCharset(), CSVFormat.EXCEL);
        for (CSVRecord record : parser.getRecords()) {
            System.out.println(record);
        }
    }
}
