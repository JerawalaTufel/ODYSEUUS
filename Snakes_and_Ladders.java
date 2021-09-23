/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dell
 */
import java.io.*;

public class Snakes_and_Ladders
{
    
    //Main
    public static void main (String [] args) throws IOException
    {
        
        BufferedReader myInput2 = new BufferedReader (new InputStreamReader (System.in));
          System.out.println ("\t\t\t\t\t\tWelcome To Snakes And Ladders\n\n");
        
        
        int counter= 100,iteration=-1; 
        System.out.println ("-----------------------------------------------------Game Board------------------------------");
        
        
        //This while loop makes the board for the player 
        
        while (counter > 0){
            if (counter%10 == 0 && counter != 100){
                if(iteration==-1)
                {
                  
                    counter-=9;
                    iteration=1;
                }
                else
                {
                    System.out.print(counter+"\t");
                    counter-=10;
                    iteration=-1; 
                }
                if(counter!=0)
                System.out.print("\n" + counter + "\t"); 
            }
            else
            System.out.print(counter + "\t"); 
            counter+=iteration; 
        }
        System.out.println();
        System.out.println ("-------------------------------------------------------------------------------------------");
        
        String sGame = "y"; 
        
        System.out.print ("Do you want to play? Y or N     >  "); // ask user if we wants to play the game
        sGame = myInput2.readLine (); 
        System.out.print ("\n\n\n\n\n\n");
        while (sGame.equals ("y") || sGame.equals ("Y"))
        {
            sGame = startGame(sGame);
        }
        System.out.println ("\n\n\n\n\t\t\t\t\t\tSEE YA!!");
            
    } 
   
    //startGame method:
    //This method is responsible for organizing the game, asking the user to continue playing.
    
    public static String startGame (String start) throws IOException // Recieves data from the main method
    {
        
        BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));
        
        
        int userPosition = 1; // sets the default loaction for user's piece to 1
        int compPosition = 1; // sets the default loaction for computer's piece to 1
        int diceRoll = 0; // creates the first die
        int userRoll = 1; // declares what the user rolled
        int compRoll = 1; // declares what the computer rolled
        String playAgain = "y"; 
        
        // declare all the snakes and ladders in a array
        int snakesLaddersArray [] = new int [6]; // create a 6 element array
        // store the snakes and ladders location in the array
        snakesLaddersArray [0] = 54;
        snakesLaddersArray [1] = 90;
        snakesLaddersArray [2] = 99;
        snakesLaddersArray [3] = 9;
        snakesLaddersArray [4] = 40;
        snakesLaddersArray [5] = 67;
        
        
        while (playAgain.equals ("y") || playAgain.equals ("Y")) 
        {
            
            
            // gets the dice roll for user and computer
            userRoll =  getDice(diceRoll); 
            compRoll =  getDice(diceRoll); 
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            System.out.println ("\t\t\t\t\t------------------------------------------");
            System.out.println ("\t\t\t\t\t|\tYou Rolled a " + userRoll + "\t\t|"); 
            System.out.println ("\t\t\t\t\t|\tThe Computer Rolled a " + compRoll + "\t|"); 
            System.out.println ("\t\t\t\t\t------------------------------------------");
            
            // hold the user's last position for switching back if current position was greater than 100
            userPosition = userPosition + userRoll;
            
            // hold the computer's last position for switching back if current position was greater than 100
            compPosition = compPosition + compRoll;
            
            
            
            // check to see if user landed on top of a snake or at the bottom of a ladder
           
            userPosition = getP(userPosition, userRoll, snakesLaddersArray);
            
            // check to see if computer landed on top of a snake or at the bottom of a ladder
            
            compPosition = compgetP(compPosition, compRoll, snakesLaddersArray, userPosition);
            
            System.out.println("\t\t\t*************************************************************************");
            System.out.println ("\t\t\t*\t\tYou are currently on square " + userPosition + "\t\t\t*"); 
            System.out.println ("\t\t\t*\t\tThe Computer is currently on square " + compPosition + "\t\t*"); 
            System.out.println("\t\t\t*************************************************************************");
            
            // resets the position values, if the user or the computer won
            // so that the user could play the entire game again if he wanted to
            if (userPosition == 100 || compPosition == 100)
            {
                userPosition = 1;
                compPosition = 1;
                // asks the user if we wants to play again
                System.out.print ("Do you want to play? Y or N     >  ");
                playAgain = myInput.readLine ();
                System.out.print ("\n\n\n\n\n\n\n\n\n\n\n\n");
            }
            else
            {
                // asks the user if we wants to continue playing
                System.out.print ("Do you want to play? Y or N     >  ");
                playAgain = myInput.readLine ();
                
            }
                   
        }
        
        return playAgain; 
    }
    
    /*
    getDice method:
    This method generates  random numbers bewteen 1 and 6 for Dice.
    */
    public static int getDice (int diceRoll)
    {
        diceRoll = (int)(Math.random()*6 )+1 ; //creates dice roll number 1
        
        int move = diceRoll ;
        return move; // return dice value
    }
    
    /*
    getP method:
    
    This method is responsible for checking if the USER is on
    top of a snake, or at the bottom of a ladder.
    */
    public static int getP (int userPosition, int userRoll, int snakesLaddersArray []) throws IOException 
    {
        
        if(userPosition == snakesLaddersArray[0]) //if position equals snake 1
        {
            userPosition = 19; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[1]) //if position equals snake 2
        {
            userPosition = 48; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
            
        }
        else if (userPosition == snakesLaddersArray[2]) //if position equals snake 3
        {
            userPosition = 77; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[3]) //if position equals ladder 1
        {
            userPosition = 34; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
            
        }
        else if (userPosition == snakesLaddersArray[4]) //if position equals ladder 2
        {
            userPosition = 64; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
            
        }
        else if (userPosition == snakesLaddersArray[5]) //if position equals ladder 3
        {       
            userPosition = 86; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
        }
        
        if (userPosition < 0 || userPosition > 112) // This is ab ERROR TRAP to catch any unwanted system errors that may occur by chance
        {
            System.out.println ("An error has occured please reset the game!!!!!!");
        }
        
        else if (userPosition > 100) // checks if user's location if greater then a 100
        {
            userPosition = userPosition - userRoll; // subtract userRoll from the userposition to get back old position
            System.out.println ("OHHH You cant jump, you must land on a 100"); 
            
        }
        else if (userPosition == 100)
        {
            System.out.println ("YOU WON, GOOD JOB!!!"); // print out that the user won
            
        }
        return userPosition; 
    }
    
    /*
    compgetP method:
    
    This method is responsible for checking if the COMPUTER is on
    top of a snake, or at the bottom of a ladder
    */
    
    public static int compgetP (int compPosition, int compRoll, int snakesLaddersArray [], int userPosition) throws IOException
    {    
        if(compPosition == snakesLaddersArray[0])
        {
            compPosition = 19;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
            
            
        }
        else if (compPosition == snakesLaddersArray[1])
        {
            compPosition = 48;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
            
        }
        else if (compPosition == snakesLaddersArray[2])
        {
            compPosition = 77;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (compPosition == snakesLaddersArray[3])
        {
            compPosition = 34;
            System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
        }
        else if (compPosition == snakesLaddersArray[4])
        {
            compPosition = 64;
            System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
            
        }
        else if (compPosition == snakesLaddersArray[5])
        {
            compPosition = 86;
            System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
        }
        
        
        if (compPosition < 0 || compPosition > 112) //  ERROR TRAP to catch any unwanted system errors that may occur by chance
        {
            System.out.println ("An error has occured for the computer, please reset the game!!!!!!");
        }
        
        else if (compPosition > 100) // checks if computers's location if greater then a 100
        {
            compPosition = compPosition - compRoll; // get old position
            System.out.println ("THE COMPUTER CAN'T JUMP!!! He must land on a 100"); // give message that the computer cant jump
            
        }
        else if (compPosition == 100 && userPosition != 100)
        {
            System.out.println ("THE COMPUTER WON, YOU FAILED!!!"); // print out that the computer won
            
        }
        
        return compPosition; // return the final position to starGame: this position had gone through all checks and test and can be displayed on screen
    } 
}
