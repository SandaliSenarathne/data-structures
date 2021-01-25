import java.util.Scanner;
class RecursiveSumUpToGivenNumber{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println(getSum(scanner.nextInt()));
	}
	
	private static int getSum(int number) {
		if(number == 1){
			return 1;
		}else{
			return (number + getSum(number-1));
		}
	}
		
}