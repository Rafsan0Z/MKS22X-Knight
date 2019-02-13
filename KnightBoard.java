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
    Scanner in = new Scanner(System.in);
    int num = 0;
    boolean taken = true;
    while(taken){
    try{
    System.out.println("Input a size: ");
	  num = in.nextInt();
    taken = false;
  } catch(InputMismatchException e){
    System.out.println("Please input a number!");
    in.next();
  }
}
    System.out.println("Welcome to KnightBoard!!!");
    System.out.println("------------------------------");
    System.out.println("Chose one of the following options: ");
    System.out.prinltn("1. Print the puzzle");

  }

}
