class Node {
	int data;
	Node next;
	
	Node(int item) {
		this.data = item;
		this.next = null;
	}
	
	void displayNode() {
		System.out.print(this.data + " ");
	}
}

class LinkedList {
	 private Node head;
	 
	 public void LinkedList() {
		head = null;
	 }
	 
	 public boolean isEmpty() {
		return this.head == null;
	 }
	 
	 public void insertFirst(int i) {
		Node newHead = new Node(i);
		newHead.next = head;
		this.head = newHead;
	 }
	 
	 public Node deleteFirst() {
		if(isEmpty()){
			System.out.println("List is empty. Deletion terminated.");
			return null;
		}
		Node deletedNode = head;
		head = head.next;
		deletedNode.next = null;
		return deletedNode;
	 }
	 
	 public void displayList() {
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
	 
	 public Node find(int key) { // 1st, 2nd, 3rd
		Node currentNode = head;
		int count = 1;
		while(currentNode != null){
			if(count == key){
				return currentNode;
			}
			currentNode = currentNode.next;
			count++;
		}
		System.out.println("Key is out of bound.");
		return null;
	 }
	 /*
	 public void delete(int key) {
		Node currentNode = head;
		int count = 1;
		while(currentNode != null){
			if(key == 1){
				this.head = this.head.next;
				return;
			}
			if(count == key-1){
				if(currentNode.next != null){
					Node delNode = currentNode.next;
					currentNode.next = delNode.next;
					return;
				}
				System.out.println("Key is out of bound.");
				return;
			}
			currentNode = currentNode.next;
			count++;
		}
	 }
	 */
	 
	 public void delete(int key) {
		 Node newHead = recDelete(key, this.head);
		 if(newHead != null)
			this.head = newHead;
	 }
	 
	 Node recDelete(int key, Node tempNode) {
		if(key < 1){
			System.out.println("Key is out of bound.");
			return tempNode;
		}else if(key == 1){
			return tempNode.next;
		}else{
			if(tempNode.next == null){
				System.out.println("Key is out of bound.");
			}else{
				tempNode.next = recDelete(key-1, tempNode.next);
			}
			return tempNode;
		}
	 }
}

class LinkedListApp{
	public static void main(String[] args){
		LinkedList linkedList = new LinkedList();
		linkedList.insertFirst(3);
		linkedList.insertFirst(1);
		linkedList.insertFirst(8);
		linkedList.insertFirst(-1);
		linkedList.insertFirst(-7);
		linkedList.displayList();
		
		linkedList.delete(2);
		linkedList.displayList();
	}
}