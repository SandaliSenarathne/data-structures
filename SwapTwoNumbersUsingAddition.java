class SwapTwoNumbersUsingAddition{
	public static void main(String[] args){
		int a = 5;
		int b = 3;
		
		System.out.println("Value of A : " + a);
		System.out.println("Value of B : " + b);
		
		a = a+b;
		b = a-b;
		a = a-b;
		
		System.out.println("After Swapping");
		
		System.out.println("Value of A : " + a);
		System.out.println("Value of B : " + b);
		
	}
	
		
}