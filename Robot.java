
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
    String   facingDirection;
    Integer  numberOfMoves;

    public Robot(String name, String color, Spot location, String facingDirection, Integer numberofMoves) {

        this.name = name;
        this.color = color;
        this.location = location;
        this.facingDirection = facingDirection;
        this.numberOfMoves = numberofMoves;

    }

    public void turnRight(String facingDir) {

        // Switch case to set @param facingDirection
        switch (facingDir) {
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
                System.out.println("IMPOSSIBLE!");
                break;
        }
        
    }
}


