class NonDupOrdArray {

	private int[] a; // ref to array a

	private int nElems; // number of data items

	//--------------------------------------------------

	 

	public NonDupOrdArray(int max) { // constructor

		//Fill the body [5 Marks]
		this.a = new int[max];
		nElems = 0;

	}

	//--------------------------------------------------

	 

	public int size() {

		//Fill the body (this should give max size of the array) [10 Marks]
		return a.length;

	}

	//--------------------------------------------------

	 

	public int find(int searchKey) {

		//Fill the body [15 Marks]
		for (int i=0; i<nElems; i++){
			if(a[i] == searchKey){
				return i;
			}
		}
		return -1;

	} // end find ()

	//--------------------------------------------------

	 

	public void insert(int value) { // put element into arrray

		//Fill the body [35 Marks]
		if(find(value) == -1){
			if(nElems == size()){
				System.out.println("Array is full. Insertion terminated.");
			}else{
				for (int i=0; i<nElems; i++){
					if(a[i] > value){
						for(int j = this.nElems-1; j>=i; j--){
							a[j+1] = a[j];
						}
						a[i] = value;
						nElems++;
						return;
					}
				}
				a[this.nElems] = value;
				nElems++;
			}
		}else{
			System.out.println("Value already exists. Insertion terminated.");
		}

	} // end insert ()

	//--------------------------------------------------

	 

	public boolean delete(int value) {

		//Fill the body [25 Marks]
		int index = find(value);
		if(index == -1){
			System.out.println("Value not found. Deletion terminated.");
			return false;
		}
		
		for(int i=index; i<nElems-1; i++){
			a[i] = a[i+1];
		}
		nElems--;
		return true;

	} // end delete ()

	//--------------------------------------------------

	 

	public void display() { // display array contents

		//Fill the body [10 Marks]
		System.out.println("------Values in the Array------");
		System.out.print("[ ");
		for (int i=0; i<nElems; i++){
			System.out.print(a[i] + " ");
		}
		System.out.print("]");
		System.out.println("");

	}

	//--------------------------------------------------

} // end class NonDupOrdArray

class NonDupOrdArrayApp{
	public static void main(String[] args){
		NonDupOrdArray x = new NonDupOrdArray(7);
		x.insert(50);
        x.insert(9);
        x.insert(7);
        x.insert(2);
        x.insert(9);
        x.insert(10);
        x.insert(11);
        x.insert(9);

        x.display();
		
		x.delete(9);
		x.delete(2);

        x.display();
	}
}
 