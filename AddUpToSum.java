class AddUpToSum{
	public static void main(String[] args){
		System.out.println(AddUpToSumExists(new int[]{10,28,2,32,54,14,3}, 7));
	}
	
	private static boolean AddUpToSumExists(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					return true;
				}
			}
		}
		return false;
	}
		
}