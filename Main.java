package Projekt;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //path format = C:/Users/admin/Documents/Projekt CV/....csv
        CsvProjektApplication app = new CsvProjektApplication("C:/Users/admin/Documents/Projekt CV/text_with_fn.csv", "C:/Users/admin/Documents/Projekt CV/testfile_1.csv");
        app.getListWithFN();
        app.createCSVFileWithFN();
    }
}
