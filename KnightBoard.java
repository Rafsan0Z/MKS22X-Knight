//import java.util.IllegalArgumentException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
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

  public boolean solve(int startingrow, int startingcol){
    if(!inBounds(startingrow,startingcol)){
      throw new IllegalArgumentException();
    }
    return solveHelper(startingrow,startingcol,0,0,1);
  }

  public int countSolutions(int startingrow, int startingcol){
    if(!inBounds(startingrow,startingcol)){
      throw new IllegalArgumentException();
    }
    counterHelper(1,startingrow,startingcol);
    return Solutions;
  }

  public boolean counterHelper(int position, int row, int col){
    if(position == length*width){
      board[row][col] = 0;
      Solutions++;
      return true;
    }
    int[][] moves = new int[][] { {1,2} , {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1} };
    for(int i = 0; i < moves.length; i++){
      int rowChange = row + moves[i][0];
      int colChange = col + moves[i][1];
      if(inBounds(rowChange,colChange) && board[rowChange][colChange] == 0){
        board[row][col] = position;
        counterHelper(position+1,rowChange,colChange);
        board[row][col] = 0;
      }
    }
    return false;
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

  private boolean solveHelper(int row, int col, int vert, int horz, int level){
    board[row][col] = level;
    if(level == length*width){
      board[row][col] = level;
      return true;
    }
    int[][] moves = new int[][] { {1,2} , {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1} };
    for(int i = 0 ; i < moves.length && (vert != -moves[i][0] || horz != -moves[i][1]); i++){
      int rowChange = row + moves[i][0];
      int colChange = col + moves[i][1];
      if(inBounds(rowChange,colChange) && board[rowChange][colChange] == 0){
        return solveHelper(rowChange,colChange,moves[i][0],moves[i][1],level+1);
      }
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

  public static void main(String[] args){

    KnightBoard kn = new KnightBoard(8,8);
    kn.solve(1,0);
    System.out.println(kn);

  }

}
