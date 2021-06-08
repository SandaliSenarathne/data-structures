class SimpleSorting {
	private int[] a;//ref to array a
	private int nElems;//number of data items
	//------------------------------------------------------
	public SimpleSorting(int max) {
		this.a = new int[max];
		this.nElems = 0;
	}
	public void insert(int value){
		//put element into array
		if(this.nElems == this.a.length){
			System.out.println("Array is full. Insertion teminated;");
			return;
		}
		
		this.a[this.nElems] = value;
		nElems++;
	}
	public void display(){
		//display array contents
		System.out.println("------Values in Array------");
        System.out.print("[ ");
        for (int i=0; i<this.nElems; i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
        System.out.println("");
	}
	private void swap(int index1, int index2)
	{
		//swaps array elements in a[index1] and a[index2]
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	public void bubbleSort() {
		//Fill the body
		for(int i=0; i<nElems-1; i++){
			for(int j=0; j<nElems-1-i; j++){
				if(a[j] > a[j+1]){
					swap(j, j+1);
				}
			}
		}
	}
	public void selectionSort() {
		//Fill the body
		for(int i=0; i<nElems-1; i++){
			int minIndex = i;
			for(int j=i+1; j<nElems; j++){
				if(a[minIndex] > a[j]){
					minIndex = j;
				}
			}
			swap(i, minIndex);
		}
	}
	public void insertionSort() {
		//Fill the body
		for(int i=1; i<nElems; i++){
			int temp = a[i];
			int j;
			for(j=i-1; j>=0; j--){
				if(temp < a[j]){
					a[j+1] = a[j];
				}else{
					break;
				}
			}
			a[j+1] = temp;
		}
	}
	
	//=======================================================================
	static int partition(int[] arr, int low, int high){
		// pivot
		int pivot = arr[high];
		 
		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (low - 1);
	 
		for(int j = low; j <= high - 1; j++)
		{
			 
			// If current element is smaller
			// than the pivot
			if (arr[j] < pivot)
			{
				 
				// Increment index of
				// smaller element
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}
	static void quickSort(int[] arr, int low, int high){
		if (low < high)
		{
			 
			// pi is partitioning index, arr[p]
			// is now at right place
			int pi = partition(arr, low, high);
	 
			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	static void printArray(int[] arr, int size){
		for(int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
			 
		System.out.println();
	}
}

class SimpleSortingApp{
	public static void main(String[] args){
		SimpleSorting simpleSorting = new SimpleSorting(5);
		simpleSorting.insert(3);
		simpleSorting.insert(1);
		simpleSorting.insert(8);
		simpleSorting.insert(-1);
		simpleSorting.insert(-7);
		
		//simpleSorting.insertionSort();
		//simpleSorting.display();
		
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;
		 
		simpleSorting.quickSort(arr, 0, n - 1);
		System.out.println("Sorted array: ");
		simpleSorting.
		
		printArray(arr, n);
	}
}