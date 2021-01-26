import java.util.Scanner;
class TowerOfHanoi{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		TowerOfHanoi h = new TowerOfHanoi();
		h.solveHanoi(scanner.nextInt(), 'A', 'B', 'C');
	}
	
	//			No.ofDisks from	   using	to
	void solveHanoi(int n, char a, char b, char c) {
		if(n == 0){
			return;
		}
		solveHanoi(n-1, a, c, b);
		System.out.println("Move disk " +n+ " from " +a+ " to " +c);
		solveHanoi(n-1, b, a, c);
	}
		
}