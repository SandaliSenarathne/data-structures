class MaxAndNextMax{
	public static void main(String[] args){
		
		findMaxAndNextMax(new int[]{10, 23, 58, 1, 20, 5, 3});
		
	}
	
	public static void findMaxAndNextMax(int[] arr){
		int max = arr[0];
		int nxtMax = arr[0];
		
		for (int i = 0; i<arr.length; i++){
			if (max < arr[i]){
				nxtMax = max;
				max = arr[i];
			}else if (nxtMax < arr[i]){
				nxtMax = arr[i];
			}
		}
		
		System.out.println("Max = " + max);
		System.out.println("Next Max = " + nxtMax);
	}
}