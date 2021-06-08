class FindPrimeNumbers{
	public static ArrayList<Integer> findPrime(int a, int b){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=a; i<=b; i++) {
			if(i==0 || i==1) 
				continue;
			if(i==2) {
				arr.add(i);
				continue;
			}
			if (i % 2 == 0)
				continue;
			
			boolean flag = true;
			for(int j=3; j<i/2; j++) {
				if(i%j == 0) {
					flag = false;
					break;
				}
			}
			
			if(flag)
				arr.add(i);
				
		}
		
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPrime(0, 100).toString());
	}
}