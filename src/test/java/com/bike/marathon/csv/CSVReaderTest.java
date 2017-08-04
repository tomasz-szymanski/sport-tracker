package com.bike.marathon.csv;

import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;


public class CSVReaderTest {

    @Test
    public void testGetRecords() throws IOException {
        String filePath = "src/test/resources/ALL_USERS_UTF-8.csv";
        CSVReader reader = new CSVReader();
        final List<CSVRecord> records = reader.getRecords(filePath, ';');
        Assert.assertNotNull(records);
        Assert.assertTrue(records.size() > 0);
    }

}