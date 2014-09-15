import java.io.*;
import java.util.*;
public class Problem67 {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(new File("triangle.txt"));
		int[][] numbers = new int[100][100];
		for (int i = 0; i < 100; i++){
			for (int j = 0; j <= i; j++){
				numbers[i][j] = input.nextInt();
			}
		}
		
		for (int i = 98; i >= 0; i--){
			for (int j = i; j >= 0; j--){
				numbers[i][j] += Math.max(numbers[i+1][j], numbers[i+1][j+1]);
			}
		}
		System.out.println(numbers[0][0]);
		
	}
	
	private static IntTreeNode solve(IntTreeNode root){
		if (root != null){
			root.left = solve(root.left);
			root.right = solve(root.right);
			if (root.left != null && root.right != null){
				root.data = root.data + Math.max(root.left.data, root.right.data);
			}
		}
		return root;
	}
}
