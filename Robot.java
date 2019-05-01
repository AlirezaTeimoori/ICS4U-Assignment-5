
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
//-- This is the Robot class. A robot  --
//-- has different fields and methods  --
//-- that helps it to solve the maze.  --
//---------------------------------------

class Robot {

    //Intro Fields:
    protected String   name;
    protected String   color;
    protected Spot     location;
    protected Spot     previousLocation;
    protected String   facingDirection;
    protected Integer  numberOfMoves;
    protected String   lastMove;
    protected String   secondLastMove;
    protected Map      map;

    // Constructor:
    public Robot(String name, String color, Spot location, String facingDirection, Integer numberofMoves, Map map) {

        // Set Fields:
        this.name = name;
        this.color = color;
        this.location = location;
        this.facingDirection = facingDirection;
        this.numberOfMoves = numberofMoves;
        this.map = map;

    }

    // Check() function:
    public String check() {

        try {

            switch (this.facingDirection) {

                case "Right":

                    return map.findSpot(this.location.y, this.location.x+1).symbol;
                
                case "Down":

                    return map.findSpot(this.location.y+1, this.location.x).symbol;
    
                case "Left":

                    return map.findSpot(this.location.y, this.location.x-1).symbol;
    
                case "Up":

                    return map.findSpot(this.location.y-1, this.location.x).symbol;
                
                default:

                    System.out.println("CHECK: Direction IMPOSSIBLE!");
                    return "error";

                }
        } catch (Exception e) {

            System.out.println("CHECK: Reached a BORDER!");
            return "error";

        }
    }

    public void checkk() {

        if (mainApp.solved = checkWin() == true) {
            System.out.println("You WIN!!!!!!!!!!!");
            return;
        } else {
            
            
            
        }

    }

    public void decide() {
        
        String nextBlock = check();

        try {

            switch (nextBlock) {

                case "#": // If there is a wall
                case "x":

                    System.out.println("Faced wall or Border! Turning Right!");

                    if (this.lastMove == this.secondLastMove && this.lastMove == "Turn Right") {

                        System.out.println("This is the second border! facing back!");
                        turnRight();
                        turnRight();
                        this.lastMove = "Turn Right";
                        this.secondLastMove = null;
                        break;
                    }
                    turnRight();
                    
                    break;
                    
                case ".": // If the way is open
                case "S":
                
                    System.out.println("Way is open! Moving Ahead!");
                    map.findSpot(this.location.y, this.location.x).symbol = "+";
                    move();
                    break;
                
                case "+":

                    map.findSpot(this.location.y, this.location.x).symbol = "+";
                    int count = map.findSpot(this.location.y, this.location.x).count;
                    if ( count < 1) {
                        map.findSpot(this.location.y, this.location.x).count++;
                        System.out.println("count of Spot (" + this.location.symbol + ") is: " + this.location.count);
                        System.out.println("First Time! TURN RIGHT!");
                        turnRight();
                        break;

                    } else if (count < 2) {
                        map.findSpot(this.location.y, this.location.x).count++;
                        System.out.println("Second Time! MOVE!");
                        //map.findSpot(this.location.y, this.location.x).symbol = "x";
                        move();
                        break;
                    } else {
                        System.out.println("x making now!");
                        map.findSpot(this.location.y, this.location.x).symbol = "x";
                        move();
                        break;
                    }            


                default: // If nothing worked!

                    System.out.println("D: Direction IMPOSSIBLE!");
                    turnRight();
                    turnRight();
                    turnRight();

                }

        } catch (Exception e) { // If reached a border

            System.out.println("D: Reached a BORDER!");
            turnRight();

        }
        
        map.toString();
        if (mainApp.solved = checkWin() == true) {
            System.out.println("You WIN!!!!!!!!!!!");
            return;
        }
        //decide();

    }

    public void turnRight() { // turnRight() function

        this.secondLastMove = this.lastMove;
        this.lastMove = "Turn Right";

        // Switch case to set @param facingDirection
        switch (this.facingDirection) {

            case "Right":

                this.facingDirection = "Down";
                break;
            
            case "Down":

                this.facingDirection = "Left";
                break;

            case "Left":
            
                this.facingDirection = "Up";
                break;

            case "Up":

                this.facingDirection = "Right";
                break;
            
            default:

                System.out.println("TURN: Direction IMPOSSIBLE!");
                break;
        }

        

    }

    public void move() { // move() function
        
        this.numberOfMoves++;
        map.findSpot(this.location.y, this.location.x).count++;

        this.secondLastMove = this.lastMove;
        this.lastMove = "Move";
        
        // Store the current location as @param previousLocation
        this.previousLocation = this.location;
        

        // Change the @param location based on the direction the robot is facing:
        try {

            switch (this.facingDirection) {

                case "Right":

                    this.location = map.findSpot(this.location.y, this.location.x+1);
                    break;
                
                case "Down":

                    this.location = map.findSpot(this.location.y+1, this.location.x);
                    break;
    
                case "Left":

                    this.location = map.findSpot(this.location.y, this.location.x-1);
                    break;
    
                case "Up":

                    this.location = map.findSpot(this.location.y-1, this.location.x);
                    break;
                
                default: // Non of the cases above:

                    System.out.println("MOVE: Direction IMPOSSIBLE!");
                    break;
            }

        } catch (Exception e) { // If there was an exception:

            System.out.println("MOVE: Reached a BORDER!");
            turnRight();

        }
        
    }

    public boolean checkWin() {
        
        if (this.location == map.endPoint.left ||
            this.location == map.endPoint.up ||
            this.location == map.endPoint.right ||
            this.location == map.endPoint.down) {

                return true;

        } else {

            return false;

        }

    }

    public String toString() {
        
        // Intro output Variable:
        String output = "";

        // Add to the output:
        output += "The name of the bot is: \t" + this.name + "\n";
        output += "The color of the bot is: \t" + this.color + "\n";
        output += "The location of the bot is: \t" + this.location.symbol + "\n";
        output += "The previous location of the bot is: " + this.previousLocation.symbol + "\n";
        output += "The facing direction is: \t" + this.facingDirection + "\n";
        output += "The number of moves are: \t" + this.numberOfMoves + "\n";

        // return the output:
        return output;
    }
}


