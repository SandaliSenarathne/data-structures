class PrintEvenApp{
	public static void main(String[] args){
		printEven(0);
	}
	
	static void printEven(int i){
		if(i<=10){
			if (i%2 == 0)
				System.out.println(i);
			printEven(i+1);
		}
	}
}