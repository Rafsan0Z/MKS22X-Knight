//import java.util.IllegalArgumentException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
public class KnightBoard{

  private int[][] board;
  private int[][] Marks;
  private int[][] Moves;
  private int length;
  private int width;
  private int level;
  private int Solutions;

  public KnightBoard(int startingrow, int startingcol){ // constructor
    if(startingrow < 0 || startingcol < 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingrow][startingcol];
    length = startingrow;
    width = startingcol;
  }

  private void setMoves(){

  }

  private boolean inBounds(int row, int col){ // checks if the knight is inside the Board
    if(row >= length || col >= width){return false;}
    else if(row < 0 || col < 0){return false;}
    return true;
  }

  public int getLevel(){ // returns the level, or the knight number
    return level;
  }

  private void MarkUp(int row, int col){
    if(inBounds(row-1,col+3)){Marks[row-1][col+3] += 1;}
    else if(inBounds(row-1,col-3)){Marks[row-1][col-3] += 1;}
    else if(inBounds(row-3,col+1)){Marks[row-3][col+1] += 1;}
    else if(inBounds(row-3,col-1)){Marks[row-3][col-1] += 1;}
    else if(inBounds(row+1,col+3)){Marks[row+1][col+3] += 1;}
    else if(inBounds(row+1,col-3)){Marks[row+1][col-3] += 1;}
    else if(inBounds(row+3,col+1)){Marks[row+3][col+1] += 1;}
    else if(inBounds(row+3,col-1)){Marks[row+3][col-1] += 1;}
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
    return solveHelper(startingrow,startingcol,0,0,1);
  }

  public int countSolutions(int startingrow, int startingcol){
    counterHelper(1,startingrow,startingcol);
    return Solutions;
  }

  public void counterHelper(int position, int row, int col){
    if(position == length*width){
      Solutions++;
    }
    int[][] moves = new int[][] { {1,0} , {-1,0}, {0,1}, {0,-1} };
    for(int i = 0; i < moves.length; i++){
      int rowChange = row + moves[i][0];
      int colChange = col + moves[i][1];
      if(inBounds(rowChange,colChange) && board[rowChange][colChange] == 0){
        board[row][col] = position;
        counterHelper(position+1,rowChange,colChange);
        board[row][col] = 0;
      }
    }
  }

  public int CountAllSolutions(){
    int counter = 0;
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
        counter += countSolutions(i,j);
      }
    }
    return counter;
  }

  private boolean solveHelper(int row, int col, int x, int y, int level){
    board[row][col] = level;
    if(level == length*width){
      return true;
    }
    int[][] moves = new int[][] { {1,0} , {-1,0}, {0,1}, {0,-1} };
    for(int i = 0 ; i < moves.length; i++){
      int rowChange = row + moves[i][0];
      int colChange = col + moves[i][1];
    }
    board[row][col] = 0;
    return false;
  }

  private boolean addKnight(int row, int col){ // adding a knight at a row and column
    if(board[row][col] != 0){
      return false;
    }
    board[row][col] = level+1;
    level++;
    return true;
  }

  private boolean removeKnight(int row, int col){ // removing a knight at a row and column
    if(board[row][col] == 0){return false;}
    board[row][col] = 0;
    level--;
    return true;
  }

  private void clear(){ // clears the board of knights
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
        board[i][j] = 0;
      }
    }
  }

  public String MarkstoString(){ // Marked by letter N for knight
    String result = "";
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
        if(board[i][j] == 0){result += "__ ";}
        else{result += "N" + " ";}
      }
      result += "\n";
    }
    return result;
  }

  public String toString(){ // Marked by integers for knight
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

  private static void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
      }

  private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
      }

  public static void main(String[] args){ // this is where the program runs
    Scanner in = new Scanner(System.in);
    System.out.println("If you wish to run a driver file press &. Otherwise press %");
    String func = in.nextLine();
    if(func.equals("&")){
      System.out.println("Make sure that the file is inside the directory!");
      System.out.println("_______________________________");
      System.out.println("Please input the path from the file explorer");
      String path = in.nextLine();
      File file = new File(path);
      if(file.exists()){
        System.out.println("Thank you!");
        try {
            runProcess("pwd");
            System.out.println("**********");
            runProcess("javac -cp src src/com/journaldev/files/Test.java");
            System.out.println("**********");
            runProcess("java -cp src com/journaldev/files/Test Hi Pankaj");
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
      else{
        System.out.println("Sorry, the path is incorrect or the file does not exist!");
      }
    }
    int num1 = 0;
    int num2 = 0;
    boolean taken1 = true;
    boolean taken2 = true;
    while(taken1){ // while loop to properly collect the dimensions of the board
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
    System.out.println("1. Print the puzzle with numbers");
    System.out.println("2. Print the puzzle with letters");
    System.out.println("3. Add a Knight");
    System.out.println("4. Remove a Knight");
    System.out.println("5. Find a tour");
    System.out.println("6. Find a semi-magic tour");
    System.out.println("7. Find a magic tour");
    System.out.println("8. Find total number of Solutions");
    System.out.println("9. Exit");
    System.out.println("------------------------------");
    int option = in.nextInt(); // initial option chosen, new options asked for after every action is complete!
    boolean running = true;
    while(running){
    try{
      if(option == 1){
  		String output = puzzle.toString();
      System.out.println(output);
      System.out.println("Chose another Option: ");
      option = in.nextInt();
  	}
    if(option == 2){
      String output = puzzle.MarkstoString();
      System.out.println(output);
      System.out.println("Chose another Option: ");
      option = in.nextInt();
    }
    else if(option == 3){
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
    else if(option == 4){
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
    else if(option == 5){
      if(puzzle.solve(0,0)){
        System.out.println("Yes It is Solvable");
      }
      else{
        System.out.println("No It is not Solvable");
      }
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
      int num = puzzle.CountAllSolutions();
      System.out.println(num);
      System.out.println("Chose another Option: ");
      option = in.nextInt();
    }
    else if(option == 9){
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
