package Projekt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvProjektApplication {
    private BufferedReader csvReader;
    private BufferedWriter csvWriter;
    private String pathToSource;
    private String pathToTarget;
    private List<List> outerList;

    public CsvProjektApplication(String pathToSource, String pathToTarget) throws IOException {
        this.pathToSource = pathToSource;
        this.pathToTarget = pathToTarget;

    }

    public List<List> getListNoFN() throws IOException {
        outerList = new ArrayList<List>();
        try{
            csvReader = new BufferedReader(new FileReader(this.pathToSource));
            String firstRow;
            String secondRow;
            String[] data = new String[4];
            while((firstRow = csvReader.readLine()) != null) {
                List<String> innerList = new ArrayList<String>();
                secondRow = csvReader.readLine();
                String plz = secondRow.substring(0, secondRow.indexOf(" ", 0));
                secondRow = secondRow.substring((secondRow.indexOf(" ")+1));
                String city = secondRow.substring(0, secondRow.indexOf(" ", 0));
                secondRow = secondRow.substring((secondRow.indexOf(" ")+1));
                String address = secondRow;
                data[0] = firstRow;
                data[1] = plz;
                data[2] = city;
                data[3] = address;
                innerList.add(data[0]);
                innerList.add(data[1]);
                innerList.add(data[2]);
                innerList.add(data[3]);
                outerList.add(innerList);
            }
        } catch (NullPointerException nul) {

        }
        return outerList;
    }
    public List<List> getListWithFN() {
        outerList = new ArrayList<List>();
        try{
            csvReader = new BufferedReader(new FileReader(this.pathToSource));
            String firstRow;
            String secondRow;
            String[] data = new String[5];
            while((firstRow = csvReader.readLine()) != null) {
                List<String> innerList = new ArrayList<String>();
                secondRow = csvReader.readLine();
                String plz = secondRow.substring(0, secondRow.indexOf(" ", 0));
                secondRow = secondRow.substring((secondRow.indexOf(" ")+1));
                String city = secondRow.substring(0, secondRow.indexOf(" ", 0));
                secondRow = secondRow.substring((secondRow.indexOf(" ")+1));
                String address = secondRow.substring(0, secondRow.indexOf("FN"));
                String FN_Number = secondRow.substring(secondRow.indexOf("FN"));
                data[0] = firstRow;
                data[1] = plz;
                data[2] = city;
                data[3] = address;
                data[4] = FN_Number;
                innerList.add(data[0]);
                innerList.add(data[1]);
                innerList.add(data[2]);
                innerList.add(data[3]);
                innerList.add(data[4]);
                outerList.add(innerList);
            }
        } catch (NullPointerException | IOException nul) {

        }
        return outerList;
    }
    public void createCSVFileNoFN() throws IOException {
        try {
            csvWriter = new BufferedWriter(new FileWriter(this.pathToTarget));
            csvWriter.append("Firmenname");
            csvWriter.append(",");
            csvWriter.append("Zip");
            csvWriter.append(",");
            csvWriter.append("Stadt");
            csvWriter.append(",");
            csvWriter.append("Adresse");
            csvWriter.append("\n");

            for (List<String> rowData : this.outerList) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
            this.outerList.clear();

        } catch (NullPointerException nul) {

        }
    }

    public void createCSVFileWithFN() throws IOException {
        try {
            csvWriter = new BufferedWriter(new FileWriter(this.pathToTarget));
            csvWriter.append("Firmenname");
            csvWriter.append(",");
            csvWriter.append("Zip");
            csvWriter.append(",");
            csvWriter.append("Stadt");
            csvWriter.append(",");
            csvWriter.append("Adresse");
            csvWriter.append(",");
            csvWriter.append("Firmenbuch-Nummer");
            csvWriter.append("\n");

            for (List<String> rowData : this.outerList) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
            this.outerList.clear();

        } catch (NullPointerException nul) {

        }
    }
    public void setPathToSource(String pathToSource) {
        this.pathToSource = pathToSource;
    }

    public void setPathToTarget(String pathToTarget) {
        this.pathToTarget = pathToTarget;
    }
}
