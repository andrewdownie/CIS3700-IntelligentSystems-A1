
public class Board extends ObjectPlus{
	
	char[][] board;
	
	
	public Board(Board board){
		//TODO: how to get info out from here without exposing it?
	}
	
	public Board(String strBoard){
		board = new char[3][3];
		int curIndex = 0;
		
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 3; x++){
				
				board[x][y] = strBoard.charAt(x + (y * 3));
				//System.out.println( "Index is: " + x + " " + y );
				curIndex++;
				
			}
		//	System.out.println("");
		}
		
	}

	@Override
	void showPart(int index) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	void show() {
		// TODO Auto-generated method stub
		for(int y = 0; y < 3; y++){
			System.out.println(board[0][y]  + "" + board[1][y] + "" + board[2][y]);
			
		}
	}
	
	public boolean IsGoal(Board goalBoard){
		return false;
	}

	///
	/// Methods to write
	///
	// 1. isGoal
	// 2. isLegal
	// 3. nextState
	// 4. heuristicFunction
}
