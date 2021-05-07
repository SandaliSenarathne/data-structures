class CircularQueue {
	private int maxSize;
	private int[] qArray;
	private int front;
	private int rear;
	private int nItems;
	
	public CircularQueue(int max){
		this.qArray = new int[max];
		this.maxSize = max;
		this.front = -1;
		this.rear = -1;
		this.nItems = 0;
	}
	
	public boolean isFull(){
		return this.nItems == this.maxSize;
	}
	
	public boolean isEmpty(){
		return this.nItems == 0;
	}
	
	public int size(){
		return nItems;
	}
	
	public boolean insert(int item){
		if(isEmpty()){
			qArray[0] = item;
			front = 0;
			rear = 0;
			nItems++;
			return true;
		}else if(!isFull()){
			qArray[(rear+1)%maxSize] = item;
			rear = (rear+1)%maxSize;
			nItems++;
			return true;
		}
		return false;
	}
	
	public int delete(){
		if(front == rear){
			int index = this.front;
			front = rear = -1;
			nItems--;
			return index;
		}else if(!isEmpty()){
			int index = this.front;
			front = (front+1)%maxSize;
			nItems--;
			return index;
		}
		
		return maxSize;
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Array is empty");
		}else if(front == rear){
			System.out.print(qArray[front]);
			System.out.println();
		}else if(rear > front){
			 for(int i = front; i <= rear; i++)
				{
					System.out.print(qArray[i]);
					System.out.print(" ");
				}
				System.out.println();
		}else{
         
			for(int i = front; i < maxSize; i++)
			{
				System.out.print(qArray[i]);
				System.out.print(" ");
			}
	 
			for(int i = 0; i <= rear; i++)
			{
				System.out.print(qArray[i]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	
}

class CircularQueueApp {
    public static void main(String[] args) {
        CircularQueue x = new CircularQueue(3);
        x.insert(1);
        x.insert(2);
		x.insert(3);
		x.display();
		x.delete();
		x.display();
		x.insert(4);
		x.display();
		x.delete();
		x.delete();
		x.display();
		x.insert(5);
		x.display();
		x.insert(6);
		x.display();
    } //end main()
}