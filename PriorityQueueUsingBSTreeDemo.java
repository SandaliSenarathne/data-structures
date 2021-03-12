class Patient {
	 String patientName;
	 int priority;
	 
	 Patient(String patientName, int priority) {
		/*fill the code*/
		this.patientName = patientName;
		this.priority = priority;
	 }
	 
	 @Override
	 public String toString() {
		return patientName + "(" + priority + ")";
	 }
}
class BSTNode {
	 Patient p;
	 BSTNode leftChild;
	 BSTNode rightChild;
	 
	 public BSTNode(Patient p) {
		/*fill the code*/
		this.p = p;
		this.leftChild = null;
		this.rightChild = null;
	 }
	 
	 @Override
	 public String toString() {
		return p.patientName + "(" + p.priority + ")";
	 }
}
class PriorityQueueBSTree {
	 BSTNode root;

	 public void enqueue(Patient p) {
		/*add the patient to the relevant place of the queue*/
		BSTNode newPatient = new BSTNode(p);
			
		if(root == null){
			root = newPatient;
			return;
		}
			
		BSTNode currentPatient = root;
		BSTNode previousPatient = root;
		while(currentPatient != null){
			previousPatient = currentPatient;
			if(newPatient.p.priority < currentPatient.p.priority){
				currentPatient = currentPatient.leftChild;
				if(currentPatient == null){
					previousPatient.leftChild = newPatient;
					return;
				}
			}else{
				currentPatient = currentPatient.rightChild;
				if(currentPatient == null){
					previousPatient.rightChild = newPatient;
					return;
				}
			}
		}
	 }
	 
	 public Patient dequeue() {
		/*remove the BSTNode of the front patient and return the removed patient*/
		BSTNode currentPatient = root;
		BSTNode previousPatient = null;
		
		if(root == null){
			System.out.println("No patient available");
			return null;
		}
		if(root.leftChild == null){
			BSTNode dequeuedPatient = root;
			root = root.rightChild;
			return dequeuedPatient.p;
		}
		while(currentPatient != null){
			if(currentPatient.leftChild == null){
				BSTNode dequeuedPatient = currentPatient;
				previousPatient.leftChild = currentPatient.rightChild;
				return dequeuedPatient.p;
			}else{
				previousPatient = currentPatient;
				currentPatient = currentPatient.leftChild;
			}
		}
		return null;
	 }
	 
	public void displayPatients(BSTNode currentNode) {
		 /*display all the patient names in the queue
		Sample output of this method according to the above sample figure 01.
		Oshadee(17)
		Vijitha(19)
		Kamal(20)
		Saman(28)
		Johan(30)
		Sandun(31)
		Riyana(35)
		Gayani(36)
		Sathira(38)
		*/
		if(currentNode == null){
			return;
		}
			
		displayPatients(currentNode.leftChild);
		System.out.println(currentNode.toString());
		displayPatients(currentNode.rightChild);
	}
}

public class PriorityQueueUsingBSTreeDemo {
	public static void main(String[] args) {
		// TODO code application logic here
		PriorityQueueBSTree t = new PriorityQueueBSTree();
		t.enqueue(new Patient("Saman", 18));
		t.enqueue(new Patient("Kamal", 20));
		t.enqueue(new Patient("Oshadee", 17));
		t.enqueue(new Patient("Sandun", 31));
		t.enqueue(new Patient("Johan", 30));
		t.enqueue(new Patient("Vijitha", 19));
		t.enqueue(new Patient("Sathira", 38));
		t.enqueue(new Patient("Riyana", 35));
		t.enqueue(new Patient("Gayani", 36));
		
		t.displayPatients(t.root);
		System.out.println("--------------------------");
		t.dequeue();
		t.displayPatients(t.root);
	}
}