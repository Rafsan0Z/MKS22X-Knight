public class KnightBoard{

  private int[][] board;
  private int Solutions;

  public KnightBoard(int startingrow, int startingcol){
    if(startingrow < 0 || startingcol < 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingrow][startingcol];
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

  public String toString(){
    String result = "";
    for(int i = 0; i < startingrow; i++){
      for(int j = 0; j < startingcol; j++){
        if(board[i][j] == 0){result += "__ ";}
        else{result += board[i][j] + " ";}
      }
      result += "\n";
    }
    return result;
  }

  public static void main(String[] args){
    System.out.println("Welcome to KnightBoard!!!");
    System.out.println("------------------------------");
    
  }

}
