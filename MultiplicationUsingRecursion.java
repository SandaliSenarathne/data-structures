import java.util.Scanner;
class MultiplicationUsingRecursion{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		MultiplicationUsingRecursion m = new MultiplicationUsingRecursion();
		System.out.println(m.multiply(scanner.nextInt(), scanner.nextInt()));
	}
	
	int multiply(int number1, int number2) {
		if(number2 == 1){
			return number1;
		}else{
			return number1 + multiply(number1, number2-1);
		}
	}
		
}