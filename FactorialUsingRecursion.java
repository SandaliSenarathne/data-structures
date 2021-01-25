import java.util.Scanner;
class FactorialUsingRecursion{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println(factorial(scanner.nextInt()));
	}
	
	private static int factorial(int number) {
		if(number == 1 || number == 0){
			return 1;
		}else{
			return number * factorial(number-1);
		}
	}
		
}