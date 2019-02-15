//import java.util.IllegalArgumentException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
public class KnightBoard{

  private int[][] board;
  private int[][] MarkUp;
  private int length;
  private int width;
  private int Solutions;
  private int level;

  public KnightBoard(int startingrow, int startingcol){
    if(startingrow < 0 || startingcol < 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingrow][startingcol];
    length = startingrow;
    width = startingcol;
  }

  private boolean inBounds(int row, int col){
    if(row >= length || col >= width){return false;}
    else if(row < 0 || col < 0){return false;}
    return true;
  }

  // Make sure that there is a Knight in given position
  private String MoveCoordinates(int row, int col){
    ArrayList<Integer> result = new ArrayList<Integer>();
    String output = "";
    for(int i = 0; i <= result.size(); i++){
      String coordinate = "(" + result.get(i) + ", " + result.get(i+1) + ")";
      output += coordinate + " ";
    }
    return output;
  }

  private void KnightMove(int row, int col, String direction){
    if(direction.equals("upright")){
      int newrow = row - 3;
      int newcol = col + 1;
      if(inBounds(newrow,newcol)){board[newrow][newcol] = level+1;}
    }
    else if(direction.equals("downright")){
      int newrow = row + 3;
      int newcol = col + 1;
      if(inBounds(newrow,newcol)){board[newrow][newcol] = level+1;}
    }
    else if(direction.equals("upleft")){
      int newrow = row - 3;
      int newcol = col - 1;
      if(inBounds(newrow,newcol)){board[newrow][newcol] = level+1;}
    }
    else if(direction.equals("downleft")){
      int newrow = row + 3;
      int newcol = col - 1;
      if(inBounds(newrow,newcol)){board[newrow][newcol] = level+1;}
    }
    else if(direction.equals("rightup")){
      int newrow = row - 1;
      int newcol = col + 3;
      if(inBounds(newrow,newcol)){board[newrow][newcol] = level+1;}
    }
    else if(direction.equals("rightdown")){
      int newrow = row + 1;
      int newcol = col + 3;
      if(inBounds(newrow,newcol)){board[newrow][newcol] = level+1;}
    }
  }

  public boolean solve(int startingrow, int startingcol){
    return true;
  }

  public int countSolutions(int startingrow, int startingcol){
    return 0;
  }

  private boolean solveHelper(int row, int col, int level){
    return false;
  }

  private boolean addKnight(int row, int col){
    if(board[row][col] != 0){
      return false;
    }
    board[row][col] = level+1;
    level++;
    return true;
  }

  private boolean removeKnight(int row, int col){
    if(board[row][col] == 0){return false;}
    board[row][col] = 0;
    level--;
    return true;
  }

  private void clear(){
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
        board[i][j] = 0;
      }
    }
  }

  public String toString(){
    String result = "";
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
        if(board[i][j] == 0){result += "__ ";}
        else{result += board[i][j] + " ";}
      }
      result += "\n";
    }
    return result;
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int num1 = 0;
    int num2 = 0;
    boolean taken1 = true;
    boolean taken2 = true;
    while(taken1){
    try{
    System.out.println("Input a length: ");
	  num1 = in.nextInt();
    taken1 = false;
  }catch(InputMismatchException e){
     System.out.println("Please input a number!");
     in.next();
   }
 }
 while(taken2){
   try{
   System.out.println("Input a width: ");
   num2 = in.nextInt();
   taken2 = false;
  }catch(InputMismatchException e){
     System.out.println("Please input a number!");
     in.next();
   }
 }
    KnightBoard puzzle = new KnightBoard(num1,num2);
    System.out.println("Welcome to KnightBoard!!!");
    System.out.println("------------------------------");
    System.out.println("Chose one of the following options: ");
    System.out.println("1. Print the puzzle");
    System.out.println("2. Add a Knight");
    System.out.println("3. Remove a Knight");
    System.out.println("4. Find a tour");
    System.out.println("5. Find a semi-magic tour");
    System.out.println("6. Find a magic tour");
    System.out.println("7. Find total number of tours");
    System.out.println("8. Exit");
    System.out.println("------------------------------");
    int option = in.nextInt();
    boolean running = true;
    while(running){
    try{
      if(option == 1){
  		String output = puzzle.toString();
      System.out.println(output);
      System.out.println("Chose another Option: ");
      option = in.nextInt();
  	}
    else if(option == 2){
  		System.out.println("Input a row number: ");
  		int row = in.nextInt() - 1;
  		System.out.println("Input a column number: ");
  		int col = in.nextInt() - 1;
  		if(!puzzle.addKnight(row,col)){
        System.out.println("Knight Already There!");
      }
      System.out.println("Chose another Option: ");
      option = in.nextInt();
  	}
    else if(option == 3){
  		System.out.println("Input a row number: ");
  		int row = in.nextInt() - 1;
  		System.out.println("Input a column number: ");
  		int col = in.nextInt() - 1;
  		if(!puzzle.removeKnight(row,col)){
        System.out.println("No Knight There!");
      }
      System.out.println("Chose another Option: ");
      option = in.nextInt();
  	}
    else if(option == 4){
      System.out.println("Not Yet Ready!");
      System.out.println("Chose another Option: ");
      option = in.nextInt();
    }
    else if(option == 5){
      System.out.println("Not Yet Ready!");
      System.out.println("Chose another Option: ");
      option = in.nextInt();
    }
    else if(option == 6){
      System.out.println("Not Yet Ready!");
      System.out.println("Chose another Option: ");
      option = in.nextInt();
    }
    else if(option == 7){
      System.out.println("Not Yet Ready!");
      System.out.println("Chose another Option: ");
      option = in.nextInt();
    }
    else if(option == 8){
      running = false;
    }
    else{
      System.out.println("Invalid option!");
      System.out.println("Chose another Option: ");
      option = in.nextInt();
    }
  }catch(InputMismatchException e){
    System.out.println("Please input a number!");
    in.next();
  }
  }

}
}
