package com.bike.marathon.csv;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVReader {

    public List<CSVRecord> getRecords(String filePath) throws IOException {
        File toRead = new File(filePath);
        CSVParser parser = CSVParser.parse(toRead, Charset.defaultCharset(), CSVFormat.newFormat(';'));
        return parser.getRecords();
    }

    public List<String> getValues(CSVRecord record){
        final int size = record.size();
        final String s = record.get(size);
        return null;
    }
}
