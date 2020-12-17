class NonDupStrArray {

	private String[] str; // ref to array str

	private int nElems; // number of data items

	//--------------------------------------------------

	public NonDupStrArray(int max) { // constructor

		//Fill the body (5 Marks)
		this.str = new String[max];
		this.nElems = 0;
		
	}

	//--------------------------------------------------



	public int size() {

		//Fill the body (this should give max size of the array) (5 Marks)
		return str.length;

	}

	//--------------------------------------------------

	 

	public boolean find(String value) {

		//Fill the body (10 Marks)
		for(int i=0; i<nElems; i++){
			if(value.equals(str[i])){
				return true;
			}
		}
		
		return false;

	} // end find ()

	//--------------------------------------------------

	 

	public void insert(String value) { // put element into arrray

		//Note: if duplicated, remove existing value from array and insert new value to end of existing elements of the array.
		//Fill the body (60 Marks)
		if(find(value)){
			delete(value);
			str[nElems] = value;
			nElems++;
		}else if(this.nElems == size()){
			System.out.println("Array is full. Insertion terminated.");
		}else{
			str[nElems] = value;
			nElems++;
		}

	} // end insert ()

	//--------------------------------------------------

	 

	public boolean delete(String name) {

		//Fill the body (10 Marks)
		for(int i=0; i<nElems; i++){
			if(name.equals(str[i])){
				for(int j=i; j<nElems-1; j++){
					str[j] = str[j+1];
				}
				nElems--;
				return true;
			}
		}
		System.out.println("Value not found. Deletion terminated.");
		return false;

	} // end delete ()

	//--------------------------------------------------

	 

	public void display() { // display array contents

		//Fill the body (10 Marks)
		System.out.println("------Values in str------");
		System.out.print("[ ");
		for (int i=0; i<this.nElems; i++){
			System.out.print(str[i] + " ");
		}
		System.out.print("]");
		System.out.println("");

	}

	//--------------------------------------------------

} // end class NonDupStrArray

class NonDupStrArrayApp{
	public static void main(String[] args){
		NonDupStrArray arr = new NonDupStrArray(3);
		arr.insert("Sandali");
		arr.insert("Hirunika");
		arr.insert("Senarathne");
		
		arr.display();
		
		arr.insert("Sandali");
		arr.insert("Seya");
		
		arr.display();
		
		arr.delete("Sandali");
		arr.display();
		
		arr.delete("Seya");
		arr.display();
		
		arr.insert("Seya");
		arr.display();
		arr.delete("Senarathne");
		arr.display();
		arr.delete("Hirunika");
		arr.display();
		arr.delete("Seya");
		arr.display();
	}
}
 