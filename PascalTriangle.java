// By: Marcos Gil

import java.util.Scanner; // Importing the scanner to get input from the user

public class PascalTriangle { // Creating my PascalTriangle class that will contain all my methods to create Pascals Triangle
  
  public long factorial(long num){ // My factorial method which returns the factorial of the inputed number
  
    long factorialNumber = 1;
    
    while (num >= 1) {
      factorialNumber = factorialNumber * num;
      num = num - 1;
    }
    
    return factorialNumber;
  }
  
  public long combination(long row, long column){ // My combination method which returns the combination of both the values inputed
  
    return (this.factorial(row)) / ((this.factorial(column)) * (this.factorial(row-column)));
  }
  
  public long findRow(long userNum){ // My Find Row method which locates what row the number is in then returns the row the number was located in
   
    boolean foundNumber = false;
    long row = 0;
    for(row = 0; row < userNum + 1; row++){
      
      if(foundNumber == true){
        break;
      }
      
      for(long column = 0; column <= row; column++){
        
        if(userNum == this.combination(row, column)){
          
          foundNumber = true;
          break;
        }
      }
    }
    return row - 1;
  }
    
  public void printTriangle(long row){ // My Print Triangle method which prints out the Triangle to console for the user to see
  
    long rows = 0;
    while(rows <= row){
     
      long column = 0;
      
      while(column <= rows){
     
        long combo = this.combination(rows, column);
        System.out.printf(combo + " ");
        column++;
      }
      
      rows++;
      System.out.println();
    }
  }
  
  public static void main(String[] args){ // The main method of my program which creates an instance of the class I created then 
                                         // gets the user input and calls on the methods I created to calculate and print the Triangle
    PascalTriangle myInstance = new PascalTriangle();
    
    Scanner userInput = new Scanner(System.in);
    System.out.println("What number would you like to find in Pascals Triangle? ");
    int userInt = userInput.nextInt();
    long userLong = (long)userInt;
    long row = myInstance.findRow(userLong);
    myInstance.printTriangle(row);
  }
}