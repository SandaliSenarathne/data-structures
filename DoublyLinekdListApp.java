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

class DoublyLinekdListApp{
	public static void main(String[] args){
		DoublyLinekdList x = new DoublyLinekdList();
		x.insertFirst('A');
		x.insertFirst('B');
		x.insertLast('C');
		x.insertFirst('D');
		
		
		x.displayLinkedList();
		
		try{
			x.insertAfter('X',x.getHead());
			System.out.println("Deleted : " + x.deleteFirst().data);
			System.out.println("Deleted : " + x.deleteUsingKey(2).data);
			System.out.println("Peek is : " + x.peek());
		}catch(Exception e){
			System.out.println(e.toString());
		}
		x.displayLinkedList();
}