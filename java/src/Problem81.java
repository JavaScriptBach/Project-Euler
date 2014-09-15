import java.util.*;
import java.io.*;
public class Problem81 {
	public static void main(String[] args) throws FileNotFoundException{
		int[][] matrix = new int[80][80];
		Scanner input = new Scanner(new File("matrix.txt"));
		for (int i = 0; i < 80; i++){
			String line = input.nextLine();
			String[] ints = line.split(",");
			for (int j = 0; j < 80; j++)
				matrix[i][j] = Integer.parseInt(ints[j]);
		}
		input.close();
		//solve all edge cases
		for (int i = 78; i >= 0; i--){
			matrix[79][i] += matrix[79][i+1];
			matrix[i][79] += matrix[i+1][79];
		}
		for (int i = 78; i >= 0; i--){
			for (int j = 78; j >= 0; j--){
				matrix[i][j] += Math.min(matrix[i][j+1], matrix[i+1][j]);
			}
		}
		System.out.println(matrix[0][0]);
	}
	
	public static void print(int[][] matrix){
		for (int i = 0; i < 80; i++){
			for (int j = 0; j < 80; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
