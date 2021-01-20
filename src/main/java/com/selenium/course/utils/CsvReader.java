package com.selenium.course.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReader {
    public static Object[][] readCsvFile(String fileName) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        List<String[]> csvData = csvReader.readAll();
        Object[][] csvDataObject = new Object[csvData.size()][csvData.get(0).length];
        for(int i = 0; i < csvData.size(); i++) {
            csvDataObject[i] = csvData.get(i);
        }
        return csvDataObject;
    }
}
