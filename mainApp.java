
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
    static Map map = new Map();

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
        Spot mapArray [][] = new Spot[numberOfLines][numberOfChars];
        Map map = new Map(mapArray);
        Robot bot = new Robot("bot", "red", map.mapArray[0][0], "right", 0, map);


        // Reopen the reader:
        reader = new BufferedReader(new FileReader("./Test Cases/Test 1.txt"));
        
        String line;
        int thisLine = 0;

        while ((line = reader.readLine()) != null) {
            
            String lineArray[] = line.split("");
            for (int i = 0; i <= numberOfChars-1; i++) {
                map.mapArray[thisLine][i] = new Spot(lineArray[i],thisLine,i);
                //map[thisLine][i].symbol = lineArray[i];
            }
            thisLine++;
        }

        
        for (Spot[] spotArray : map.mapArray) {
            for (Spot spot : spotArray) {
                try {
                    spot.setUp(map.mapArray[spot.y-1][spot.x]);
                } catch (Exception e) {
                    System.out.println("no Up!");
                }
                try {
                    spot.setRight(map.mapArray[spot.y][spot.x+1]);
                } catch (Exception e) {
                    System.out.println("no Right!");
                }
                try {
                    spot.setDown(map.mapArray[spot.y+1][spot.x]);
                } catch (Exception e) {
                    System.out.println("no Down!");
                }
                try {
                    spot.setLeft(map.mapArray[spot.y][spot.x-1]);
                } catch (Exception e) {
                    System.out.println("no Left!");
                }
            }

        }




        prtwriter.println("done!");
        System.out.println("NOL: " + numberOfLines);
        System.out.println("NOC: " + numberOfChars);
        for (Spot[] i: map.mapArray) {
            for (Spot j: i) {

                try {
                    System.out.println("sym: " + j.symbol + " - y: " + j.y + " - x: " + j.x + " - left: " + map.mapArray[j.y][j.x-1].symbol);
                    
                } catch (Exception e) {
                    System.out.println("sym: " + j.symbol + " - y: " + j.y + " - x: " + j.x);
                }
            }
            
        }




        prtwriter.close();
        scanner.close();
        //System.out.println(map.mapArray[numberOfLines-1][numberOfChars-1].symbol);
    }

    public String printStatus() {
        
        // Intro Variable:
        String output = "";
        for (Spot[] spotArray : map.mapArray) {
            System.out.println("\n");
            for (Spot spot : spotArray) {
                
                if (spot == bot.location) {
                    System.out.print("B");
                }
            }
            System.out.println("\n");
        }



        return output;
    }
}