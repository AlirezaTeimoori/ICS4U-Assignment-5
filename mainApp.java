
//---------------------------------------
//-- Created by:     Alireza Teimoori  --
//-- Created on:     Apr 16 2019       --
//-- Created for:    Assignment 5      --
//-- Course Code:    ICS4U             --
//-- Teacher Name:   Chris Atkinson    --
//---------------------------------------
//-- This program solves rectangular   --
//-- with a recursive function         --
//---------------------------------------
//-- This is the mainApp class. the    --
//-- main function is written here.    --
//---------------------------------------



import java.util.Scanner;
import java.io.*;

class mainApp {

    // Instantiations:


    public static void main(String[] args) throws IOException {

        FileReader filereader = new FileReader("./Test Cases/Test 1.txt");
        BufferedReader reader = new BufferedReader(filereader);
        FileWriter filewriter = new FileWriter("./Test Cases/Test 1 OUTPUT.txt");
        PrintWriter prtwriter = new PrintWriter(filewriter);
        Scanner scanner = new Scanner(filereader);

        int numberOfLines = 0;
        int numberOfChars = 0;


        // Count number of lines:
        while (reader.readLine() != null) numberOfLines++; reader.close(); // Close the reader

        // Reopen the reader:
        reader = new BufferedReader(new FileReader("./Test Cases/Test 1.txt"));

        // Count number of chars in line
        numberOfChars = reader.readLine().toCharArray().length; reader.close(); // Close the reader

        // Create the map array:
        Spot [][] map = new Spot[numberOfLines][numberOfChars];

        while (reader.readLine() != null) {
            
        }



        prtwriter.println("done!");
        System.out.println("NOL: " + numberOfLines);
        System.out.println("NOC: " + numberOfChars);
        for (Spot[] i: map) {
            for (Spot j: i) {
                System.out.println(j);
            }
            
        }
        prtwriter.close();
        scanner.close();
    }
}