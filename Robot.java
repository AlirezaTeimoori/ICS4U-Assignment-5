
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
    String   name;
    String   color;
    Spot     location;
    Spot     previousLocation;
    String   facingDirection;
    Integer  numberOfMoves;
    Map      map;

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

    public void decide() {
        
        String nextBlock = check();

        try {

            switch (nextBlock) {

                case "#": // If there is a wall

                    System.out.println("Faced wall or Border! Turning Right!");
                    turnRight();
                    break;
                    
                case ".": // If the way is open
                case "+":
                case "S":
                
                    System.out.println("Way is open! Moving Ahead!");
                    move();
                    break;
                
                default: // If nothing worked!

                    System.out.println("CHECK: Direction IMPOSSIBLE!");

                }
        } catch (Exception e) { // If reached a border
            System.out.println("CHECK: Reached a BORDER!");
            turnRight();
        }
        
    }

    public void turnRight() { // turnRight() function

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
        
        // Store the current location as @param previousLocation
        this.previousLocation = this.location;

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
                
                default:
                    System.out.println("MOVE: Direction IMPOSSIBLE!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("MOVE: Reached a BORDER!");
        }
        
    }
}


