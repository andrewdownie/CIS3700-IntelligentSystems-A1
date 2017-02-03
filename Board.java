
public class Board extends ObjectPlus{

	char[][] board;

    private final char HOLE_CHAR = '0';

	public Board(String strBoard){
		board = new char[3][3];

		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 3; x++){

				board[x][y] = strBoard.charAt(x + (y * 3));

			}
		}

	}

    public Board(Board b){
        board = new char[3][3];

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                board[x][y] = b.board[x][y];
            }
        }

    }

    private int[] FindHole(){
        int hole_x = 0, hole_y = 0;

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(board[x][y] == HOLE_CHAR){
                    hole_x = x;
                    hole_y = y;
                }
            }
        }

        return new int[] {hole_x, hole_y};
    }

    public boolean MoveLeft(){

        int[] hole = FindHole();
        int hole_x, hole_y;

        hole_x = hole[0];
        hole_y = hole[1];

        if(hole_x > 0){
            char temp = board[hole_x][hole_y];
            board[hole_x][hole_y] = board[hole_x-1][hole_y];
            board[hole_x-1][hole_y] = temp;
            return true;
        }

        return false;
    }

    public boolean MoveRight(){
        int[] hole = FindHole();
        int hole_x, hole_y;

        hole_x = hole[0];
        hole_y = hole[1];

        if(hole_x < 2){
            char temp = board[hole_x][hole_y];
            board[hole_x][hole_y] = board[hole_x + 1][hole_y];
            board[hole_x + 1][hole_y] = temp;
            return true;
        }

        return false;
    }

    public boolean MoveUp(){
        int[] hole = FindHole();
        int hole_x, hole_y;

        hole_x = hole[0];
        hole_y = hole[1];

        if(hole_y > 0){
            char temp = board[hole_x][hole_y];
            board[hole_x][hole_y] = board[hole_x][hole_y - 1];
            board[hole_x][hole_y - 1] = temp;
            return true;
        }

        return false;
    }

    public boolean MoveDown(){
        int[] hole = FindHole();
        int hole_x, hole_y;

        hole_x = hole[0];
        hole_y = hole[1];

        if(hole_y < 2){
            char temp = board[hole_x][hole_y];
            board[hole_x][hole_y] = board[hole_x][hole_y + 1];
            board[hole_x][hole_y + 1] = temp;
            return true;
        }

        return false;
    }

	@Override
	void showPart(int index) {
		// TODO Auto-generated method stub -- WHAT DOES THIS DO?!

	}



	@Override
	void show() {
		// TODO Auto-generated method stub
		for(int y = 0; y < 3; y++){
			System.out.println(board[0][y]  + "" + board[1][y] + "" + board[2][y]);

		}
	}

	public boolean IsGoal(Board goalBoard){
		return calcHeuristic(goalBoard.board) == 0;
	}

    int calcHeuristic(char[][] goalBoard){
        int hCost = 0;

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(board[x][y] != goalBoard[x][y] && board[x][y] != HOLE_CHAR){
                    hCost++;
                }
            }
        }

        //System.out.println("DIF CNT IS: " + hCost);

        return hCost;
    }

	///
	/// Methods to write
	///
	// 1. isGoal
	// 2. isLegal
	// 3. nextState
	// 4. heuristicFunction
}
