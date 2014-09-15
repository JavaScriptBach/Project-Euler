import java.util.Arrays;
public class RightTriangle implements Comparable<RightTriangle> {
	public int a;
	public int b;
	public int c;
	public RightTriangle(int a, int b, int c){
		int[] temp = {a, b, c};
		Arrays.sort(temp);
		this.a = temp[0];
		this.b = temp[1];
		this.c = temp[2];
	}
	
	public boolean equals(RightTriangle other){
		return a == other.a && b == other.b && c == other.c;
	}
	
	public String toString(){
		return "[" + a + ", " + b + ", " + c + "]";
	}
	
	public int getPerimeter(){
		return a + b + c;
	}
	public int compareTo(RightTriangle other){
		return this.getPerimeter() - other.getPerimeter();
	}
}
