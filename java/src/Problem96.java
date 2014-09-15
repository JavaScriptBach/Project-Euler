import java.util.*;
import java.io.*;
public class Problem96 {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(new File("sudoku.txt"));
		int sum = 0;
		for (int i = 0; i < 50; i++){
			input.nextLine();
			int[][] grid = new int[9][9];
			for (int j = 0; j < 9; j++){
				String line = input.nextLine();
				for (int k = 0 ; k < 9; k++){
					grid[j][k] = Character.getNumericValue(line.charAt(k));
				}
			}
			
			SudokuBoard board = new SudokuBoard(grid);
			solve(board);
			sum += 100 * board.get(1, 1) + 10 * board.get(1, 2) + board.get(1, 3);
		}
		System.out.println(sum);
		
	}
	
	public static boolean explore(SudokuBoard b, int row, int col){
		if (row == 10)
			return true;
		if (col == 10)
			return explore(b, row+1, 1);
		if (b.get(row, col) == 0){
			for (int i = 1; i <= 9; i++){
				if (b.safe(i, row, col)){
					b.place(i, row, col);
					if (explore(b, row, col+1))
						return true;
					b.remove(row, col);
				}
			}
			return false;
		}
		return explore(b, row, col+1);
	}
	
	public static void solve(SudokuBoard b){
		if (explore(b, 1, 1)){
			b.print();
			System.out.println();
		}
		else
			System.out.println("No solution");
	}
}
