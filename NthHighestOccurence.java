import java.util.*;
class NthHighestOccurence{
	
	public static int nthHighest(int[] arr, int n){
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
			}else{
				map.put(arr[i], 1);
			}
		}
		
		int[] arr2 = new int[map.size()];
		int i=0;
		for (int a : map.values()) {
			arr2[i] = a;
			i++;
		}
		
		Arrays.sort(arr2);
		
		int j=0;
		for (Map.Entry entry : map.entrySet()) {
			if(arr2[arr2.length -n] == (int)entry.getValue())
				return (int)entry.getKey();
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		
		int[] arr = new int[]{1, 2, 3, 5, 4, 2, 4, 3, 5, 4, 3, 5, 5, 4, 5};
		
		System.out.println(nthHighest(arr, 3));
		
	}
}
