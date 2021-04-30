class NumberOfVowels{
	public static void main(String[] args){
		System.out.println(NumberOfVowels("SAndali"));
	}
	
	private static int NumberOfVowels(String in) {
		char[] arr = in.toLowerCase().toCharArray();
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
				count++;
			}
		}  
		System.out.println(in);
		return count;
	}
		
}