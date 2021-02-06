package com.selenium.course.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvReader {
    public static Object[][] readCsvFile(String fileName) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
        List<String[]> csvData = csvReader.readAll();
        Object[][] csvDataObject = new Object[csvData.size()][csvData.get(0).length];
        for(int i = 0; i < csvData.size(); i++) {
            csvDataObject[i] = csvData.get(i);
        }
        csvReader.close();
        return csvDataObject;
    }
}
