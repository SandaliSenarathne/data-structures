class BSTNode {
	int data;
	BSTNode leftChild;
	BSTNode rightChild;

	public BSTNode(int data){
		this.data=data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	@Override
	public String toString(){
		return "data -> "+data;
	}
	
	public int minValue(){
		if(this.leftChild == null){
			return this.data;
		}else{
			return this.leftChild.minValue();
		}
	}
	
	public boolean remove(int data, BSTNode parent){
		if(data < this.data){
			if(this.leftChild != null){
				return this.leftChild.remove(data, this);
			}else{
				return false;
			}
		}else if(data > this.data){
			if(this.rightChild != null){
				return this.rightChild.remove(data, this);
			}else{
				return false;
			}
		} else{
			// here you have to delete the node
			if(this.leftChild != null && this.rightChild != null){
				//replace the data to be removed by it's successor
				this.data = this.rightChild.minValue();
				this.rightChild.remove(this.data, this);
			}else if(parent.leftChild == this){
				parent.leftChild = (this.leftChild == null)? this.rightChild : this.leftChild;
			}else if(parent.rightChild == this){
				parent.rightChild = (this.leftChild == null)? this.rightChild : this.leftChild;
			}
			return true;
		}
	}
}

class BSTree {
	BSTNode root;
	public BSTree(){
		this.root = null;
	}
	
	public void addNode(int data) {
		BSTNode newNode = new BSTNode(data);
		
		if(root == null){
			root = newNode;
			return;
		}
		BSTNode currentNode = root;
		BSTNode parentNode = root;
		while(currentNode != null){
			parentNode = currentNode;
			if(newNode.data < currentNode.data){
				currentNode = currentNode.leftChild;
				if(currentNode == null){
					parentNode.leftChild = newNode;
					return;
				}
			}else{
				currentNode = currentNode.rightChild;
				if(currentNode == null){
					parentNode.rightChild = newNode;
					return;
				}
			}
		}
	}
	
	public void preOrderTraversal(BSTNode currentNode) {
		if(currentNode == null)
			return;
		System.out.println(currentNode.toString());
		preOrderTraversal(currentNode.leftChild);
		preOrderTraversal(currentNode.rightChild);
	}
	
	public void postOrderTraversal(BSTNode currentNode) {
		if(currentNode == null)
			return;
		postOrderTraversal(currentNode.leftChild);
		postOrderTraversal(currentNode.rightChild);
		System.out.println(currentNode.toString());
	}
	
	public void inOrderTraversal(BSTNode currentNode) {
		if(currentNode == null)
			return;
		inOrderTraversal(currentNode.leftChild);
		System.out.println(currentNode.toString());
		inOrderTraversal(currentNode.rightChild);
	}
	
	public BSTNode findNode(int data) {
		BSTNode currentNode = root;
		while(currentNode != null){
			if(currentNode.data == data){
				return currentNode;
			}else{
				if(data < currentNode.data){
					currentNode = currentNode.leftChild;
				}else{
					currentNode = currentNode.rightChild;
				}
			}
		}
		return null;
	}
	
	public boolean remove(int data){
		if(root == null){
			return false;
		}
		if(root.leftChild == null){
			root = root.rightChild;
			return true;
		}else if(root.rightChild == null){
			root = root.leftChild;
			return true;
		}
		return root.remove(data, null);
	}
}

public class BSTreeDemo {
	public static void main(String[] args) {
		// TODO code application logic here
		BSTree t = new BSTree();
		t.addNode(3);
		t.addNode(4);
		t.addNode(1);
		t.addNode(7);
		t.addNode(2);
		t.addNode(5);
		t.addNode(6);
		System.out.println("inorder");
		t.inOrderTraversal(t.root);
		System.out.println("--------------------------");
		t.remove(31);
		System.out.println("inorder");
		t.inOrderTraversal(t.root);
	}
}