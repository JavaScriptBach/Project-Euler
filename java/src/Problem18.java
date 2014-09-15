import java.io.*;
import java.util.*;
public class Problem18 {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(new File("triangle.txt"));
		Queue<IntTreeNode> q = new LinkedList<IntTreeNode>();
		IntTreeNode root = new IntTreeNode(input.nextInt());
		q.add(root);
		for (int i = 2; i <= 100; i++){
			IntTreeNode prev = q.remove();
			prev.left = new IntTreeNode(input.nextInt());
			prev.right = new IntTreeNode(input.nextInt());
			q.add(prev.left);
			q.add(prev.right);
			for (int j = 1; j <= i - 2; j++){
				IntTreeNode current = q.remove();
				current.left = prev.right;
				current.right = new IntTreeNode(input.nextInt());
				q.add(current.right);
				prev = current;
			}
		}
		System.out.println(solve(root));
		input.close();
	}

	//pre: tree has already been properly set up
	//post: returns the maximum path sum
	public static int solve(IntTreeNode node){
		if (node == null){
			return 0;
		}
		return node.data + Math.max(solve(node.left), solve(node.right));
	}
}