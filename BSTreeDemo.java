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
		System.out.println("preorder");
		t.preOrderTraversal(t.root);
		System.out.println("postorder");
		t.postOrderTraversal(t.root);
		System.out.println("find 1 ="+t.findNode(1));
		System.out.println("find 8 ="+t.findNode(8));
		System.out.println("find 5 ="+t.findNode(5));
		System.out.println("find 6 ="+t.findNode(6));
	}
}