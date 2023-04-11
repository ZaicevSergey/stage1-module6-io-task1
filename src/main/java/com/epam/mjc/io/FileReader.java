package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {
        List<String> parsing = parsing(file);
        return new Profile(parsing.get(0), Integer.parseInt(parsing.get(1)), parsing.get(2),
                Long.parseLong(parsing.get(3)));
    }

    private List<String> parsing (File file){
        List<String> profilDate = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] s = line.split(" ");
                profilDate.add(s[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return profilDate;
    }
}
