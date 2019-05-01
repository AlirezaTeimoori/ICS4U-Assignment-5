
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
//-- This is the Map class. the map is --
//-- created in this class so that it  --
//-- will be easily accessible as an   --
//-- object from other classes in app. --
//---------------------------------------

import java.io.*;

class Map {

    // Intro Fields:
    protected Spot[][] mapArray;
    protected Spot startPoint;
    protected Spot endPoint;
    protected int numberOfLines = 0;
    protected int numberOfChars = 0;

    protected static FileReader filereader;
    protected static BufferedReader reader;
    protected static FileWriter filewriter;
    protected static PrintWriter prtwriter;
    static {
        try {
            filereader = new FileReader("./Test Cases/Test 2.txt");
            reader = new BufferedReader(filereader);
            filewriter = new FileWriter("./Test Cases/Test 1 OUTPUT.txt");
            prtwriter = new PrintWriter(filewriter);
            
        } catch (final IOException e) {
            throw new ExceptionInInitializerError(e.getMessage());
        }
    }


    // public Map (Spot[][] array) {

    //     this.mapArray = array;
        
    // }

    public void generate() throws IOException {

        // Create the array
        this.mapArray = new Spot[numberOfLines][numberOfChars];

        // Create required variables:
        String line;
        int thisLine = 0;

        // Reopen the reader:
        reader = new BufferedReader(new FileReader("./Test Cases/Test 2.txt"));

        // Add the spots to the array
        while ((line = reader.readLine()) != null) {
            
            String lineArray[] = line.split("");

            for (int i = 0; i <= numberOfChars-1; i++) {

                this.mapArray[thisLine][i] = new Spot(lineArray[i],thisLine,i);
                //map[thisLine][i].symbol = lineArray[i];
                
            }
            thisLine++;
        }

        // Add the Spot properties of the Spots:
        for (Spot[] spotArray : this.mapArray) {
            for (Spot spot : spotArray) {
                try {
                    spot.setUp(this.mapArray[spot.y-1][spot.x]);
                } catch (Exception e) {
                    // System.out.println("no Up!");
                    continue;
                }
                try {
                    spot.setRight(this.mapArray[spot.y][spot.x+1]);
                } catch (Exception e) {
                    // System.out.println("no Right!");
                    continue;
                }
                try {
                    spot.setDown(this.mapArray[spot.y+1][spot.x]);
                } catch (Exception e) {
                    // System.out.println("no Down!");
                    continue;
                }
                try {
                    spot.setLeft(this.mapArray[spot.y][spot.x-1]);
                } catch (Exception e) {
                    // System.out.println("no Left!");
                    continue;
                }
            }
        }
    }

    public void countAndSet() throws IOException{
        
        // Count number of lines:
        while (reader.readLine() != null) this.numberOfLines++; reader.close(); // Close the reader

        // Reopen the reader:
        reader = new BufferedReader(new FileReader("./Test Cases/Test 2.txt"));

        // Count number of chars in line
        this.numberOfChars = reader.readLine().toCharArray().length; reader.close(); // Close the reader
    }

    public void setStartEnd() throws IOException{

        for (Spot[] spotArray : this.mapArray) {

            for (Spot spot : spotArray) {

                if (spot.symbol.equals("S")) {this.startPoint = spot;}
                if (spot.symbol.equals("G")) {this.endPoint   = spot;}
                
            }
        }
    }

    public Spot findSpot(int y, int x) {
        
        Spot target = this.mapArray[y][x];

        return target;
    }

    public String toString() {

        // Create output variable:
        String output = "";

        // For sake of tidyness:
        output += "\n";

        for (Spot[] spotArray : this.mapArray) {

            for (Spot spot : spotArray) {
                
                if (spot == mainApp.bot.location) {

                    System.out.print("B");

                } else {

                    System.out.print(spot.symbol);

                }
            }
            System.out.print("\n");
        }

        // Return output:
        return output;
    }
}
