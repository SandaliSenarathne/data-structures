import java.util.Scanner;
class FibonacciUsingRecursion{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		FibonacciUsingRecursion f = new FibonacciUsingRecursion();
		System.out.println(f.fibonacci(scanner.nextInt()));
	}
	
	int fibonacci(int number) {
		if(number == 0 || number == 1){
			return number;
		}else{
			return  fibonacci(number-1) + fibonacci(number-2);
		}
	}
		
}