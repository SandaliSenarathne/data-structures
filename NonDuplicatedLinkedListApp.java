import java.util.*;

class Node {
	String data;
	Node next;
	
	Node(String item) {
		this.data = item;
		this.next = null;
	}
}

class NonDuplicatedLinkedList {
	
	private Node head;
	 
	public NonDuplicatedLinkedList(){
		head = null;
	}
	 
	public void insert(String value){
		if(find(value)){
			System.out.println("Value already exist. Insertion terminated.");
			return;
		}
		Node newHead = new Node(value);
		newHead.next = this.head;
		this.head = newHead;
		return;
	}
	
	public boolean find(String value){
		Node currentNode = head;
		if(currentNode == null){
			return false;
		}
		while(currentNode.next != null){
			if(value.equals(currentNode.data)){
				return true;
			}
			currentNode = currentNode.next;
		}
		if(value.equals(currentNode.data)){
			return true;
		}
		return false;
	}
	
	public boolean delete(String value){
		if(!find(value)){
			System.out.println("Value does not exist. Deletion terminated.");
			return false;
		}else{
			Node previousNode = head;
			Node currentNode = head;
			int count = 1;
			while(currentNode != null){
				if(value.equals(currentNode.data)){
						if(count == 1){
							this.head = currentNode.next;
							return true;
						}
						Node temp = currentNode.next;
						previousNode.next = temp;
						return true;
				}
				previousNode = currentNode;
				currentNode = currentNode.next;
				count++;
			}
			return false;
		}
	}
	
	public void display(){
		Node currentNode = head;
		if(currentNode == null){
			System.out.println("Nothing to display.");
			return;
		}
		while(currentNode.next != null){
			System.out.print(currentNode.data + "->");
			currentNode = currentNode.next;
		}
		System.out.print(currentNode.data);
		System.out.println();
	}
	
}

class NonDuplicatedLinkedListApp{
	public static void main(String[] args){
		NonDuplicatedLinkedList linkedList = new NonDuplicatedLinkedList();
		linkedList.insert("aa");
		linkedList.insert("ba");
		linkedList.insert("ca");
		linkedList.insert("aa");
		linkedList.insert("da");
		linkedList.insert("ea");
		
		linkedList.display();
		System.out.println(linkedList.delete("aa"));
		linkedList.display();
	}
}