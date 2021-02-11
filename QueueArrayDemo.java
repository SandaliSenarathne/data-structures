class QueueArray{
private int maxSize;
private int[] queArray;
private int front;
private int rear;
private int nItems;
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - // ...

	QueueArray(int max){
		this.maxSize = max;
		this.queArray = new int[maxSize];
		this.front = 0;
		this.rear = -1;
		this.nItems = 0;
	}
	
	public boolean isEmpty(){
		return this.nItems == 0;
	}
	
	public boolean isFull(){
		return this.nItems == this.maxSize;
	}
	
	public int size(){
		return this.nItems;
	}
	
	public void enqueue(int value){
		if(isFull()){
			System.out.println("Queue is full. Cannot enqueue.");
			return;
		}
		/*if(rear == maxSize-1){
			this.rear = 0;
		}else{
			rear++;
		}*/
		rear = (rear+1) % maxSize;
		this.queArray[rear] = value;
		this.nItems++;
	}
	
	public int dequeue() throws Exception{
		if(isEmpty()){
			System.out.println("Queue is empty. Cannot dequeue.");
			throw new Exception("Queue is empty. Cannot dequeue.");
		}
		
		int removedValue = queArray[front];
		front = (front+1) % maxSize;
		this.nItems--;
		return removedValue;
	}
	
	public int peek() throws Exception{
		if(isEmpty()){
			throw new Exception("Queue is empty. Cannot peek.");
		}
		return queArray[front];
	}
	
	public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i = this.front;
        while (i != rear) {
            System.out.print(this.queArray[i] + " ");
            i = (i + 1) % maxSize;
        }
        System.out.print(this.queArray[rear]);
        System.out.println();
    }

} 

class QueueArrayDemo{
	
	public static void main(String[] args){
		QueueArray q = new QueueArray(5);
		q.display();
		q.enqueue(2);
		q.enqueue(8);
		q.enqueue(3);
		q.display();
		
		try{
			q.dequeue();
			q.display();
			System.out.println("Peek is : " + q.peek());
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}











