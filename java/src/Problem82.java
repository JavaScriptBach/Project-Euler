import java.util.*;
import java.io.*;
public class Problem82 {
	public static void main(String[] args) throws FileNotFoundException{
		long start = System.currentTimeMillis();
		Scanner input = new Scanner(new File("matrix.txt"));
		int[][] matrix = new int[80][80];
		for (int i = 0; i < 80; i++){
			String line = input.nextLine();
			String[] ints = line.split(",");
			for (int j = 0; j < 80; j++)
				matrix[i][j] = Integer.parseInt(ints[j]);
		}
		input.close();
		for (int j = 78; j >= 0; j--){
			int[] temp = new int[80];
			for (int i = 0; i < 80; i++){
				//find all choices for matrix[i][j]
				int[] choices = new int[80];
				for (int k = 0; k < 80; k++){
					//exiting at matrix[k][j]
					for (int l = Math.min(i, k); l <= Math.max(i, k); l++){
						choices[k] += matrix[l][j];
					}
					choices[k] += matrix[k][j+1];
				}
				Arrays.sort(choices);
				//matrix[i][j] = choices[0];
				temp[i] = choices[0];
			}
			
			for (int i = 0; i < 80; i++)
				matrix[i][j] = temp[i];
		}
		
		int min = 9999999;
		for (int i = 0 ; i < 80; i++){
			if (matrix[i][0] < min)
				min = matrix[i][0];
		}
		//print(matrix);
		System.out.println(min);
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static void print(int[][] matrix){
		for (int i = 0 ; i < 80; i++){
			for (int j = 0; j < 80; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
}
