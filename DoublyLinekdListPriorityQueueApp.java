//Assume that lower the the character, higher the priority
//Using Doubly Linked List,
class PriorityQueue{
	private DoublyLinekdList queue;
	PriorityQueue(){
		 this. queue = new DoublyLinekdList();
	}
	
	public void enqueue(char item){
		DoubleLinkNode currentNode = queue.getHead();
		
		if(queue.isEmpty()){
			queue.insertFirst(item);
			return;
		}
		
		try{
			while(currentNode != null){
				if(currentNode.data > item){
					if(currentNode.prev == null){
						queue.insertFirst(item);
						return;
					}
					queue.insertAfter(item, currentNode.prev);
					return;
				}
				currentNode = currentNode.next;
			}
		
			queue.insertLast(item);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public DoubleLinkNode dequeue(){
		try{
			return queue.deleteFirst();
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
	}
	
	public char peek() throws Exception{
		try{
			return queue.peek();
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void display(){
		queue.displayLinkedList();
	}
}

class DoublyLinekdListPriorityQueueApp{
	public static void main(String[] args){
		PriorityQueue q = new PriorityQueue();
		q.display();
		q.enqueue('C');
		q.display();
		q.enqueue('F');
		q.display();
		q.enqueue('D');
		q.display();
		q.dequeue();
		q.display();
		q.enqueue('Z');
		q.display();
		q.enqueue('X');
		q.display();
		q.enqueue('B');
		q.display();
		q.enqueue('A');
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


































class DoubleLinkNode {
	char data;
	DoubleLinkNode prev, next;
	
	DoubleLinkNode(char item) {
		this.data = item;
		this.prev = null;
		this.next = null;
	}
	
	void displayNode() {
		System.out.print(this.data + " ");
	}
}

class DoublyLinekdList{
	private DoubleLinkNode head;
	 
	public void DoublyLinekdList() {
		this.head = null;
	}
	 
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void insertFirst(char item){
		DoubleLinkNode newHead = new DoubleLinkNode(item);
		if(this.head != null){
			newHead.next = head;
			head.prev = newHead;
		}
		this.head = newHead;
	}
	
	void insertLast(char item){
		DoubleLinkNode newNode = new DoubleLinkNode(item);
		DoubleLinkNode tail = head;
	 
		if (isEmpty()) {
			head = newNode;
			return;
		}
	 
		while (tail.next != null){
			tail = tail.next;
		}
		newNode.prev = tail;
		tail.next = newNode;
	}
	
	public void insertAfter(char item, DoubleLinkNode node) throws Exception{
		DoubleLinkNode newNode = new DoubleLinkNode(item);
		
		if(node == null){
			if(isEmpty()){
				this.head = newNode;
				return;
			}
			throw new Exception("Out of Bound");
		}
		
		newNode.next = node.next;
		newNode.prev = node;
		if (newNode.next != null)
			newNode.next.prev = newNode;
		node.next = newNode;
		
	}
	
	public char peek() throws Exception{
		if(isEmpty()){
			throw new Exception("List is empty. Cannot peek.");
		}
		return this.head.data;
	}
	
	public DoubleLinkNode deleteFirst() throws Exception{
		if(isEmpty()){
			throw new Exception("List is empty. Deletion terminated.");
		}
		DoubleLinkNode deletedNode = head;
		head = head.next;
		head.prev = null;
		deletedNode.next = null;
		return deletedNode;
	}
	
	public DoubleLinkNode deleteUsingKey(int key) throws Exception{
		if(isEmpty()){
			throw new Exception("List is empty. Deletion terminated.");
		}
		
		DoubleLinkNode currentNode = head;
		int count = 1;
		while(currentNode != null){
			if(key == 1){
				DoubleLinkNode deletedNode = this.head;
				deletedNode. next = null;
				this.head = this.head.next;
				this.head.prev = null;
				return deletedNode;
			}
			if(count == key-1){
				if(currentNode.next != null){
					DoubleLinkNode deletedNode = currentNode.next;
					deletedNode.next.prev = currentNode;
					currentNode.next = deletedNode.next;
					return deletedNode;
				}
				throw new Exception("Key is out of bound.");
			}
			currentNode = currentNode.next;
			count++;
		}
		throw new Exception("Key is out of bound.");
	}
	
	public void displayLinkedList() {
		if(isEmpty()){
			System.out.println("List is empty. Nothing to display.");
			return;
		}
		DoubleLinkNode tempNode = head;
		while(tempNode != null){
			tempNode.displayNode();
			tempNode = tempNode.next;
		}
		System.out.println();
	}
	
	public DoubleLinkNode getHead(){
		return this.head;
	}
	public void setHead(DoubleLinkNode node){
		this.head = node;
	}
}