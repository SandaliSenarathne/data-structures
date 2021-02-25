class Student {
     String studentName;
     double gpa;
	 
     Student(String studentName, double gpa) {
		//fill the body
		this.studentName = studentName;
		this.gpa = gpa;
     }
}

class Node {
     Student s;
     Node next;

     Node(Student s) {
		//fill the body
		this.s = s;
     }
}

class PriorityQueue {

     private Node head;
     private Node tail;
	 
	 PriorityQueue(){
		 this.head = null;
		 this.tail = null;
	 }

     public void enqueue(String studentName, double gpa) {
		//add Node of the student into the relevant place of the queue
		Student newStudent = new Student(studentName, gpa);
		Node newNode = new Node(newStudent);
		
		if(head == null){
			head = tail = newNode;
			return;
		}
		
		Node prevNode = null;
		Node currentNode = head;
		while(currentNode != null){
			if(currentNode.s.gpa < gpa){
				if(prevNode == null){
					newNode.next = currentNode;
					head = newNode;
					return;
				}
				newNode.next = currentNode;
				prevNode.next = newNode;
				return;
			}
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		
		tail.next = newNode;
		tail = newNode;
     }

     public String dequeue() throws Exception {
		/*remove the node of the front student and return the name of the student*/
		if(head == null){
			throw new Exception("Queue is Empty");
		}
		Node removedNode = head;
		head = head.next;
		return removedNode.s.studentName;
     }

     public String peek() throws Exception {
		//return the name of the front student
		if(head == null){
			throw new Exception("Queue is Empty");
		}
		return head.s.studentName;
     }

     public void display() {
		//display all the student names in the queue
		Node currentNode = head;
		while(currentNode != null){
			System.out.println(currentNode.s.studentName);
			currentNode = currentNode.next;
		}
     }

}

class LinkedListPriorityQueueDemo{
	public static void main(String[] args){
		PriorityQueue q = new PriorityQueue();
		q.enqueue("Sandali", 3.33);
		q.enqueue("Hirunika", 4.75);
		q.enqueue("Sachee", 3.00);
		q.enqueue("Mali", 3.30);
		q.enqueue("dilki", 3.5);
		q.display();
		System.out.println("------------------------------------");
		try{
			q.dequeue();
			System.out.println("------------------------------------");
			q.enqueue("aaaaa", 3.45);
			q.display();
			System.out.println("------------------------------------");
			System.out.println(q.peek());
			System.out.println("------------------------------------");
			q.display();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}
}