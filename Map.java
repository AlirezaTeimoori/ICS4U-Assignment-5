
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


class Map {

    // Intro Fields:
    Spot[][] mapArray;

    public Map (Spot[][] array) {

        this.mapArray = array;
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

        // Return output:
        return output;
    }
}
