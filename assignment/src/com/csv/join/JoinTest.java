package com.csv.join;

/**     Write a command line program to "join" .csv files. Use any
        programming language you're comfortable with.
        Your program should
        work similarly to the unix "join" utility (google for it). Unlike the unix join,
        your program will not require files to be sorted on the key. Your
        program must also accept the "type" of join to use---merge join, inner
        loop join, or hash join, etc. Test your program on "large" files (e.g.
        make sure it doesn't blow up on one million records, etc.)
        Submit source code for the program.
 **/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JoinTest {
    public static void main(String[] args) {
        Scanner scanner;
        String data;
        String [] row ={};
        HashMap<String,String> record1 = new HashMap<>();
        String [] header1 = {};
        String delimiter = ";";

        /* Read first CSV */
        scanner = importFile("first.csv");
        header1 = scanner.nextLine().split(delimiter);
        System.out.println("header1 = ");
        printStringArray(header1);
        try{
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
                System.out.println("data = ");
                row = data.split(delimiter);
                printStringArray(row);
                for(int j=0;j<header1.length;j++){
                    record1.put(header1[j],row[j]);
                }
                compareAndMergeRecords(record1);
            }
        }catch (Exception e){
            System.out.println("Error while importing CSV file.\n");
        }
    }

    public static Scanner importFile(String fileName){
        Scanner myReader = null;
        try {
            File myObj = new File(fileName);
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return myReader;
    }

    public static void printStringArray(String [] array){
        if(array.length == 0){
            System.out.println("Empty array..");
        }else{
            for(int i=0;i<array.length;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println("\n");
        }

    }

    public static void compareAndMergeRecords(HashMap<String, String> record1){
        Scanner scanner2;
        HashMap<String,String> record2 = new HashMap<>();
        String [] header2 = {};
        String delimiter = ";";
        String [] row ={};

        /* Read second CSV */
        scanner2 = importFile("second.csv");
        header2 = scanner2.nextLine().split(delimiter);
        System.out.println("header2 = ");
        printStringArray(header2);
        try{
            while (scanner2.hasNextLine()) {
                row = scanner2.nextLine().split(delimiter);
                printStringArray(row);

                for(int j=0;j<header2.length;j++){
                    System.out.println("header2 = " + header2[j]);
                    System.out.println("row = " + row[j]);
                    record2.put(header2[j],row[j]);
                }

                System.out.println("Integer.parseInt(record1.get(\"id\")) = " + Integer.parseInt(record1.get("id")));
                System.out.println("Integer.parseInt(record2.get(\"id\")) = " + Integer.parseInt(record2.get("id")));

                /* id is the common column for both */
                if(Integer.parseInt(record1.get("id")) == Integer.parseInt(record2.get("id"))){
                    record1.putAll(record2);
                    writeToCSV(record1);
                }

            }
        }catch (Exception e){
            System.out.println("Error while importing CSV file.\n");
        }

    }

    public static void writeToCSV(HashMap<String, String> finalOutput){
        System.out.println("finalOutput ======== ");
        String fileName = "output.csv";
        File outputFile = new File("output.csv");
        int size = finalOutput.keySet().size();
        int finalVal = 0;
        try {
            FileWriter myWriter = new FileWriter(fileName,true);
            StringBuilder valueString = new StringBuilder();

            if(outputFile.length()==0){//empty
                StringBuilder headerString = new StringBuilder();

                for(String key: finalOutput.keySet()){
                    finalVal++;
                    System.out.println("key = " + key);
                    if(finalVal == size) headerString.append(key);
                    else headerString.append(key+";");
                }
                myWriter.write(String.valueOf(headerString));
                myWriter.write(System.lineSeparator());
                finalVal = 0;
                for(String val: finalOutput.values()){
                    finalVal++;
                    System.out.println("val = " + val);
                    if(finalVal == size) valueString.append(val);
                    else valueString.append(val+";");
                }
                myWriter.write(String.valueOf(valueString));
            }else{
                myWriter.write(System.lineSeparator());
                for(String val: finalOutput.values()){
                    finalVal++;
                    System.out.println("val = " + val);
                    if(finalVal == size) valueString.append(val);
                    else valueString.append(val+";");
                }
                myWriter.write(String.valueOf(valueString));
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
