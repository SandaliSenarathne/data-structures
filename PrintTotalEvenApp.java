class PrintTotalEvenApp{

	public static void main(String[] args){

		System.out.println(PrintTotalEven(0));

	}

	

	static int PrintTotalEven(int i){

		if(i<=10){

			if (i%2 == 0)
				return i + PrintTotalEven(i+1);
			else
				return PrintTotalEven(i+1);

		}else{
			return 0;
		}

	}

}

