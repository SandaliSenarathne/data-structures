class ReverseString{
	public static void main(String[] args){
		System.out.println(ReverseString("Sandali"));
	}
	
	private static String ReverseString(String in) {
		char[] arr = in.toCharArray();
		StringBuilder s = new StringBuilder();
		
		for (int i = arr.length-1; i >= 0 ; i--) {
			s.append(arr[i]);
		}
		return s.toString();
	}
		
}