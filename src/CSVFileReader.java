/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import helper.Exercise;

/**
 *
 * @author cjwn
 */

public class CSVFileReader {
    
    private String fileName;
    
    /**
     *  Constructor
     */
    public CSVFileReader(String file) throws Exception {
        fileName = file;
        
        BufferedReader csvFile = new BufferedReader(new FileReader(fileName));
        
        String dataRow = csvFile.readLine();
        while (dataRow != null) {
            String[] dataArray = dataRow.split(",");
            
            for (String item: dataArray) {
                System.out.print(item + "\t");
            }
            System.out.println();
            dataRow = csvFile.readLine();
        }
        
        csvFile.close();
    }
    
}
