package com.ups.pwd;

import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Runner {
    public static void main(String[] args) {
    	if(args.length != 1) {
    		System.err.println("please provide a valid directory to be searched");
    		System.exit(0);
    	}
    	List<PasswordData> pdList = new ArrayList<PasswordData>();

        File file = new File(args[0]);
        if (!file.exists()) {
          System.out.println("does not exist");
        }
        File[] listOfFiles = file.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try (BufferedReader br = new BufferedReader(new FileReader(listOfFiles[i]))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String ext = FilenameUtils.getExtension(listOfFiles[i].getAbsolutePath());
                            String[] lineArray = line.split(" ");
                            pdList.add(new PasswordData(ext, lineArray[0], Long.parseLong(lineArray[1])));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
            }else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        Collections.sort(pdList);
         final String FILE_HEADER = "Server Name,Account Name,Last Password Change Date \n";
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter("test.csv", false);
                fileWriter.append(FILE_HEADER.toString());
                for (PasswordData pd : pdList) {
                    fileWriter.append(pd.toString());
                }

                System.out.println("CSV file was created successfully !!!");

            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
            } finally {

                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                }

            }
        }
}


