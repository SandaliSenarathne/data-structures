class NonDupIntArray {

	private int[] ary; // ref to array ary

	private int nElems; // number of data items

	//--------------------------------------------------



	public NonDupIntArray(int max) { // constructor

		this.ary = new int[max];
		this.nElems = 0;

	}

	 

	//--------------------------------------------------

	public int size() {

		return this.ary.length;

	}

	//--------------------------------------------------

	 

	public int find(int value) {

		// return the array location of the value. If not found, return -1.

		//Fill the body (15 Marks)
		for (int i=0; i<nElems; i++){
			if(ary[i] == value){
				return i;
			}
		}
		return -1;

	} // end find ()

	//--------------------------------------------------

	 

	public void insert(int value) { // put element into arrray

		//Fill the body (15 Marks)
		if (this.nElems == size()){
            System.out.println("Array is full. Insertion terminated.");
        }else if (find(value) == -1){
            ary[this.nElems] = value;
            this.nElems++;
        }else{
            System.out.println("Value already exists. Insertion terminated.");
        }

	} // end insert ()

	//--------------------------------------------------

	 

	public boolean delete(int location) { //delete value of specific array location

	/*

	(Note: you need to validate minimum and maximum location of the array. minimum location is 0)

	*/ //Fill the body (50 Marks)
	
		if(location < 0 || location >= nElems){
			System.out.println("Location is out of bound. Deletion terminated.");
			return false;
		}
	
		for (int j=location; j<this.nElems-1; j++){
			ary[j] = ary[j+1];
		}
		this.nElems--;
		return true;

	} // end delete ()

	//--------------------------------------------------

	 

	public void display() { // display array contents

		//Fill the body (10 Marks)
		System.out.println("------Values in Ary------");
        System.out.print("[ ");
        for (int i=0; i<this.nElems; i++){
            System.out.print(ary[i] + " ");
        }
        System.out.print("]");
        System.out.println("");

	}

	//--------------------------------------------------

} // end class NonDupIntArray

class NonDupIntArrayApp{
	public static void main(String[] args){
		NonDupIntArray arr = new NonDupIntArray(3);
		arr.insert(5);
		arr.insert(3);
		arr.insert(5);
		arr.insert(4);
		arr.insert(6);
		
		arr.display();
		
		arr.delete(3);
		arr.display();
		
		arr.delete(2);
		arr.display();
	}
}
 