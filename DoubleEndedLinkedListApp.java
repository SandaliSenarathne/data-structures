class Node {
	char data;
	Node next;
	
	Node(char item) {
		this.data = item;
		this.next = null;
	}
	
	void displayNode() {
		System.out.print(this.data + " ");
	}
}

class DoubleEndedLinkedList{
	private Node head;
	private Node tail;
	private int nItems;
	 
	public void DoubleEndedLinkedList() {
		this.head = null;
		this.tail = null;
		this.nItems = 0;
	}
	 
	public boolean isEmpty() {
		return this.head == null && this.tail == null;
	}
	
	public int size(){
		return this.nItems;
	}
	
	public void insertLeft(char i) {
		if(isEmpty()){
			head = tail = new Node(i);
			return;
		}
		Node newHead = new Node(i);
		newHead.next = head;
		this.head = newHead;
		this.nItems++;
	}
	
	public void insertRight(char i) {
		if(isEmpty()){
			head = tail = new Node(i);
			return;
		}
		Node newTail = new Node(i);
		tail.next = newTail;
		this.tail = newTail;
		this.nItems++;
	}
	
	public Node deleteLeft() throws Exception{
		if(isEmpty()){
			throw new Exception("List is empty. Deletion terminated.");
		}
		
		Node deletedNode = head;
		head = head.next;
		if(head == null){
			this.tail = null;
		}
		deletedNode.next = null;
		this.nItems--;
		return deletedNode;
	}
	
	
	public Node deleteRight() throws Exception{
		
		if(isEmpty()){
			throw new Exception("List is empty. Deletion terminated.");
		}
		
		if(head == tail){
			Node deletedNode = head;
			head = tail = null;
			this.nItems--;
			return deletedNode;
		}
		
		Node currentNode,previousNode;
		previousNode = currentNode = head;
		
		while(currentNode.next != null){
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		Node deletedNode = currentNode;
		previousNode.next = null;
		tail = previousNode;
		this.nItems--;
		return deletedNode;
	}
	
	public char peekLeft() throws Exception{
		if(isEmpty()){
			throw new Exception("Queue is empty. Cannot peek.");
		}
		return this.head.data;
	}
	
	public char peekRight() throws Exception{
		if(isEmpty()){
			throw new Exception("Queue is empty. Cannot peek.");
		}
		return this.tail.data;
	}
	
	public void displayLinkedList() {
		if(isEmpty()){
			System.out.println("List is empty. Nothing to display.");
			return;
		}
		Node tempNode = head;
		while(tempNode != null){
			tempNode.displayNode();
			tempNode = tempNode.next;
		}
		System.out.println();
	}
	
}

class DoubleEndedLinkedListApp{
	public static void main(String[] args){
		DoubleEndedLinkedList x = new DoubleEndedLinkedList();
		x.insertLeft('A');
		x.insertRight('B');
		x.insertLeft('C');
		x.insertRight('D');
		x.insertLeft('E');
		x.displayLinkedList();
		
		try{
			System.out.println("Deleted : " + x.deleteLeft().data);
			x.displayLinkedList();
			System.out.println("Peek is : " + x.peekLeft());
		}catch(Exception e){
			System.out.println(e.toString());
		}
		x.displayLinkedList();
		
		try{
			System.out.println("Deleted : " + x.deleteRight().data);
			x.displayLinkedList();
			System.out.println("Peek is : " + x.peekRight());
		}catch(Exception e){
			System.out.println(e.toString());
		}
		x.displayLinkedList();
	}
}