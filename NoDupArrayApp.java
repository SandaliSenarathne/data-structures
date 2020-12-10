class NoDupArray {

    private long[] a;//ref to array a
    private int nEliments;//number of data items

    public NoDupArray(int max) {//constructor
        this.a = new long[max];
        this.nEliments = 0;
    }

    public boolean find(long SearchKey) {//find specified value
        for (int i=0; i<this.nEliments; i++){
            if (a[i] == SearchKey){
                return true;
            }
        }
        return false;
    }// end find()

    public void insert(long value) {//put element into array
        if (this.nEliments == a.length){//As if the array is full nElements is out of bound
            System.out.println("Array is full. Insertion terminated.");
        }else if (!find(value)){
            a[this.nEliments] = value;
            this.nEliments++;
        }else{
            System.out.println("Value already exists. Insertion terminated.");
        }
    }//end insert()

    public boolean delete(long value) {//delete the element if it found
        for (int i=0; i<this.nEliments; i++){
            if (a[i] == value){
                for (int j=i; j<this.nEliments-1; j++){
                    a[j] = a[j+1];
                }
                // no need to delete the last value because in display() we only show elements upto nElements.
                //a[nElements] = null;
                this.nEliments--;
                return true;
            }
        }
        System.out.println("Value does not exist. Deletion terminated.");
        return false;
    }//end delete()

    public void display() {//display array contents
        System.out.println("------Values in the Array------");
        System.out.print("[ ");
        for (int i=0; i<this.nEliments; i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
        System.out.println("");
    } //end display()

}

class NoDupArrayApp {
    public static void main(String[] args) {
        NoDupArray x = new NoDupArray(6);
        x.insert(9);
        x.insert(7);
        x.insert(3);
        x.insert(8);

        x.display();

        x.insert(4);

        x.display();

        x.delete(7);

        x.display();

        x.insert(9);

        x.display();
    } //end main()
}