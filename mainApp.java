
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
    static FileReader filereader;
    static BufferedReader reader;
    static FileWriter filewriter;
    static PrintWriter prtwriter;
    static {

        try {

            filereader = new FileReader("./Test Cases/Test 1.txt");
            reader = new BufferedReader(filereader);
            filewriter = new FileWriter("./Test Cases/Test 1 OUTPUT.txt");
            prtwriter = new PrintWriter(filewriter);
            
        } catch (final IOException e) {

            throw new ExceptionInInitializerError(e.getMessage());

        }
    }

    static Scanner scanner = new Scanner(filereader);
    static int numberOfLines = 0;
    static int numberOfChars = 0;

    static Map map = new Map();
    static Robot bot;
    static boolean solved = false;

    public static void main(String[] args) throws IOException {
        
        // Run map class functions to generate the map object:
        map.countAndSet();
        map.generate();
        map.setStartEnd();

        // Cunstruct the robot object:
        bot = new Robot("bot", "red", map.startPoint, "Right", 0, map);
    
        // // Check:
        // prtwriter.println("done!");
        // System.out.println("NOL: " + map.numberOfLines);
        // System.out.println("NOC: " + map.numberOfChars);


   
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();
        bot.decide();


        


        
        System.out.println(bot.toString());
        System.out.println(map.toString());
        System.out.println(map.endPoint);

        prtwriter.close();
        scanner.close();
        //System.out.println(map.mapArray[numberOfLines-1][numberOfChars-1].symbol);
    }

    public static void test() {
        
        for (Spot[] i: map.mapArray) {

            for (Spot j: i) {

                try {

                    System.out.println("sym: " + j.symbol + " - y: " + j.y + " - x: " + j.x + " - left: " + map.mapArray[j.y][j.x-1].symbol);
                    
                } catch (Exception e) {

                    System.out.println("sym: " + j.symbol + " - y: " + j.y + " - x: " + j.x);

                }
            }
        }
    }
}