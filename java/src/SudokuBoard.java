
public class SudokuBoard {
	private int[][] board;
	public SudokuBoard(int[][] board){
		this.board = board;
	}
	
	public void place(int number, int row, int col){
		board[row-1][col-1] = number;
	}
	
	public void remove(int row, int col){
		board[row-1][col-1] = 0;
	}
	
	public int get(int row, int col){
		return board[row-1][col-1];
	}
	
	public boolean safe(int number, int row, int col){
		//if (board[row-1][col-1] != 0)
			//return false;
		for (int i = 0 ; i < 9; i++){
			if (board[row-1][i] == number)
				return false;
			if (board[i][col-1] == number)
				return false;
		}
		if (row >= 1 && row <= 3){
			if (col >= 1 && col <= 3){
				for (int i = 0 ; i <= 2; i++){
					for (int j = 0; j <= 2; j++){
						if (board[i][j] == number)
							return false;
					}
				}
			}
			
			if (col >= 4 && col <= 6){
				for (int i = 0 ; i <= 2; i++){
					for (int j = 3; j <= 5; j++){
						if (board[i][j] == number)
							return false;
					}
				}
			}
			
			if (col >= 7 && col <= 9){
				for (int i = 0 ; i <= 2; i++){
					for (int j = 6; j <= 8; j++){
						if (board[i][j] == number)
							return false;
					}
				}
			}
			
		}
		
		if (row >= 4 && row <= 6){
			if (col >= 1 && col <= 3){
				for (int i = 3 ; i <= 5; i++){
					for (int j = 0; j <= 2; j++){
						if (board[i][j] == number)
							return false;
					}
				}
			}
			if (col >= 4 && col <= 6){
				for (int i = 3 ; i <= 5; i++){
					for (int j = 3; j <= 5; j++){
						if (board[i][j] == number)
							return false;
					}
				}
			}
			if (col >= 7 && col <= 9){
				for (int i = 3 ; i <= 5; i++){
					for (int j = 6; j <= 8; j++){
						if (board[i][j] == number)
							return false;
					}
				}
			}
		}
		
		if (row >= 7 && row <= 9){
			if (col >= 1 && col <= 3){
				for (int i = 6; i <= 8; i++){
					for (int j = 0; j <= 2; j++){
						if (board[i][j] == number)
							return false;
					}
				}
			}
			if (col >= 4 && col <= 6){
				for (int i = 6; i <= 8; i++){
					for (int j = 3; j <= 5; j++){
						if (board[i][j] == number)
							return false;
					}
				}
			}
			if (col >= 7 && col <= 9){
				for (int i = 6; i <= 8; i++){
					for (int j = 6; j <= 8; j++){
						if (board[i][j] == number)
							return false;
					}
				}
			}
		}
		return true;
	}
	
	public void print(){
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}
}
