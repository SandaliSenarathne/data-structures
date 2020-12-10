class OrderedArray {
 private long[] a; // ref to array a
 private int nElements; //number of data items
 
 public OrderedArray(int max) {
	this.a = new long[max];
	this.nElements = 0;
 }
 public int size() { // return max size of the array
	return this.a.length;
 }
 public int find(long searchKey) {
	for(int i=0; i<nElements; i++){
		if(a[i] == searchKey)
			return i;
	}
	return -1;
 }
 public void insert(long value) { // put element into arrray
	if(nElements == a.length){
		System.out.println("Array is full. Insertion terminated.");
	}else{
		for (int i=0; i<nElements; i++){
			if(a[i] > value){
				for(int j = this.nElements-1; j>=i; j--){
					a[j+1] = a[j];
				}
				a[i] = value;
				nElements++;
				return;
			}
		}
		a[this.nElements] = value;
		nElements++;
	}
 }
 
 public boolean deleteAll(long value) {
	boolean deleted = false;
	for(int i=0; i<nElements; i++){
		if(a[i] == value){
			for(int j=i; j<nElements-1; j++){
				a[j] = a[j+1];
			}
			deleted = true;
			nElements--;
			if(a[i] == value)
				i--;
			else
				break;
		}
	}
	return deleted;
 }
 
 public boolean delete(long value) {
	int index = find(value);
	if(index == -1){
		System.out.println("Value not found. Deletion terminated.");
		return false;
	}
	
	for(int i=index; i<nElements-1; i++){
		a[i] = a[i+1];
	}
	nElements--;
	return true;
 }
 
 void display() { // display array contents
	System.out.println("------Values in the Array------");
    System.out.print("[ ");
    for (int i=0; i<nElements; i++){
        System.out.print(a[i] + " ");
    }
    System.out.print("]");
    System.out.println("");
 }
}

class OrderedArrayApp {
    public static void main(String[] args) {
        OrderedArray x = new OrderedArray(7);
        x.insert(2);
        x.insert(9);
        x.insert(9);
        x.insert(2);
        x.insert(9);
        x.insert(10);
        x.insert(11);
        x.insert(9);

        x.display();

        //x.insert(4);

        //x.display();

        //x.delete(7);

        //x.display();

        //x.insert(9);

        //x.display();
		
		x.deleteAll(9);
		x.deleteAll(2);

        x.display();
    } //end main()
}