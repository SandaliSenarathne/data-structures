class NonDupChrArray {

	private char[] ch; // ref to array ch

	private int nElems; // number of data items

	//--------------------------------------------------

	 

	public NonDupChrArray(int max) { // constructor

		//Fill the body (5 Marks)
		this.ch = new char[max];
		this.nElems = 0;

	}

	//--------------------------------------------------

	 

	public int remainSlots() {

		//Fill the body (this should give number of remaining array slots for insertion)(15 Marks)
		return ch.length - nElems;

	}

	//--------------------------------------------------

	 

	public boolean find(char value) {

		//Fill the body (10 Marks)
		for(int i=0; i<nElems; i++){
			if(value == ch[i]){
				return true;
			}
		}
		
		return false;

	} // end find ()

	//--------------------------------------------------

	 

	public void insert(char value) { // put element into array

		//Note: if duplicated, remove existing value from array and insert new value to end of existing elements of the array.
		//Fill the body (20 Marks)
		if(find(value)){
			delete(value);
			ch[nElems] = value;
			nElems++;
		}else if(remainSlots() == 0){
			System.out.println("Array is full. Insertion terminated.");
		}else{
			ch[nElems] = value;
			nElems++;
		}

	} // end insert ()

	//--------------------------------------------------

	 

	public boolean delete(char value) {

		//Fill the body (15 Marks)
		for(int i=0; i<nElems; i++){
			if(value == ch[i]){
				for(int j=i; j<nElems-1; j++){
					ch[j] = ch[j+1];
				}
				nElems--;
				return true;
			}
		}
		System.out.println("Value not found. Deletion terminated.");
		return false;

	} // end delete ()

	//--------------------------------------------------

	 

	public void multiDelete(char value) {

		//If value is a vowel, delete all vowels in the array, otherwise delete only the value.
		//Fill the body
		if(isVowel(value)){
			for(int i=0; i<nElems; i++){
				if(isVowel(ch[i])){
					delete(ch[i]);
				}
			}
		}else{
			delete(value);
		}


	} // end delete ()
	
	public boolean isVowel(char value){
		if(Character.toUpperCase(value) == 'A' || Character.toUpperCase(value) == 'E' || Character.toUpperCase(value) == 'I' || Character.toUpperCase(value) == 'O' || Character.toUpperCase(value) == 'U')
			return true;
		else
			return false;
	}

	//--------------------------------------------------

	 

	public void display() { // display array contents

		//Fill the body (10 Marks)
		System.out.println("------Values in ch------");
		System.out.print("[ ");
		for (int i=0; i<this.nElems; i++){
			System.out.print(ch[i] + " ");
		}
		System.out.print("]");
		System.out.println("");

	}

	//--------------------------------------------------

} // end class NonDupChrArray

class NonDupChrArrayApp{
	public static void main(String[] args){
		NonDupChrArray arr = new NonDupChrArray(3);
		arr.insert('S');
		arr.insert('H');
		arr.insert('S');
		
		arr.display();
		
		arr.insert('S');
		arr.insert('f');
		
		arr.display();
		
		arr.delete('s');
		arr.display();
		
		arr.delete('f');
		arr.display();
		
		arr.insert('f');
		arr.display();
		arr.delete('d');
		arr.display();
		arr.delete('H');
		arr.display();
		arr.delete('f');
		arr.display();
	}
}
 