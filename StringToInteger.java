class StringToInteger{
	
	public static int stringToInt(String str){
		int value = 0;
		int n = str.length();
		for(int i=0; i<n; i++){
			value = value*10 + ((int)str.charAt(i) - 48);
		}
		
		return value;
	}
	
	public static void main(String[] args){
		System.out.println(stringToInt("123"));
	}
}
