class NonDupDoubleArray {

	private double[] d; // ref to array d

	private int nElems; // number of data items

	//--------------------------------------------------

	public NonDupDoubleArray(int max) { // constructor

		//Fill the body (5 Marks)
		this.d = new double[max];
		this.nElems = 0;

	}

	//--------------------------------------------------

	 

	public int remainSlots() {

		//Fill the body (this should give number of remaining array slots for insertion)(15 Marks)
		return d.length - nElems;

	}

	//--------------------------------------------------

	 

	public int find(double value) {

		//return the array location of the value. If not found, return -1.
		//Fill the body (15 Marks)
		for (int i=0; i<nElems; i++){
			if(d[i] == value){
				return i;
			}
		}
		return -1;

	} // end find ()

	//--------------------------------------------------

	 

	public void insert(double value) { // put element into array

		//Fill the body
		//Note: if duplicated, remove existing value from the array and insert new value to beginning of existing elements of the array. Which means for duplicated values, inserted value should be the first element.
		//(40 Marks)
		if(find(value) != -1){
			/***** Method 01*****
			delete(find(value));
			for (int i=nElems; i>0; i--){
				d[i] = d[i-1];
			}
			d[0] = value;
			nElems++;
			********************/
			
			//*****Method 02*****
			for(int i=find(value); i>0; i--){
				d[i] = d[i-1];
			}
			d[0] = value;
			//*******************
		}else if(remainSlots() > 0){
			d[nElems] = value;
			nElems++;
		}else{
			System.out.println("Array is full. Insertion terminated.");
		}

	} // end insert ()

	//--------------------------------------------------

	public boolean delete(int location) { //delete value of specific array location

		//(Note: you need to validate minimum and maximum location of the array. minimum location is 0)
		//Fill the body (15 Marks)
		if(location < 0 || location >= nElems){
			System.out.println("Location is out of bound. Deletion terminated.");
			return false;
		}
	
		for (int j=location; j<this.nElems-1; j++){
			d[j] = d[j+1];
		}
		this.nElems--;
		return true;

	} // end delete ()

	//--------------------------------------------------

	 

	public void display() { // display array contents

		//Fill the body (10 Marks)
		System.out.println("------Values in d------");
        System.out.print("[ ");
        for (int i=0; i<this.nElems; i++){
            System.out.print(d[i] + " ");
        }
        System.out.print("]");
        System.out.println("");

	}

	//--------------------------------------------------

} // end class NonDupDoubleArray

class NonDupDoubleArrayApp{
	public static void main(String[] args){
		NonDupDoubleArray arr = new NonDupDoubleArray(3);
		arr.insert(5.0);
		arr.insert(3.0);
		arr.display();
		arr.insert(3.0);
		
		arr.display();
		
		arr.delete(1);
		arr.display();
		
		arr.delete(0);
		arr.display();
	}
}
 