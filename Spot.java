
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
//-- This is the Spot class. Each spot --
//-- in the maze will be created as a  --
//-- type Spot and stored in the 2D arr--
//---------------------------------------

class Spot {

    // Intro Fields:
    String symbol; // The symbol of the spot
    Spot   up;     // The spot above
    Spot   down;   // The spot below
    Spot   left;   // The spot to the right
    Spot   right;  // The spot to the left
    int    count;  // Number of times this spot has been passed
    int    y;      // The y axis of the array
    int    x;      // The x axis of the array

    public Spot (String symbol, int y, int x) {

        this.symbol = symbol;
        this.y      = y;
        this.x      = x;
        this.count  = 0;
    }

    public void setUp(Spot up) {
        this.up = up;
    }

    public void setRight(Spot right) {
        this.right = right;
    }

    public void setDown(Spot down) {
        this.down = down;
    }

    public void setLeft(Spot left) {
        this.left = left;
    }

    public String info() {

        // Create output variable:
        String output = "";

        // Add required information to the output variable
        output += "\nSymbol: " +             this.symbol;
        output += "\nY-axis: " +             this.y + " (on line " + (this.y+1) + ")";
        output += "\nX-axis: " +             this.x + " (on char " +   this.x   + ")";
        output += "\nSpot above: (" +        this.up.symbol    +                  ")";
        output += "\nSpot below: (" +        this.down.symbol  +                  ")";
        output += "\nSpot to the left:  (" + this.left.symbol  +                  ")";
        output += "\nSpot to the right: (" + this.right.symbol +                  ")";

        // For sake of tidyness:
        output += "\n";

        // Return output:
        return output;
    }
}