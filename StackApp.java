import java.util.Scanner;

class StackArray {
	 private int maxSize; //size of stack array
	 private int[] stackData;
	 private int top; //top of stack
	 //-------------------------------------------------------------------------
	 public StackArray(int s) {
		 this.maxSize = s;
		 this.stackData = new int[maxSize];
		 this.top = -1;
	 }
	 public boolean isEmpty() {
		return top == -1;
	 }
	 public boolean isFull() {
		 return top == maxSize-1;
	 }
	 public void push(int item) {
		if(!isFull()){
			top++;
			stackData[top] = item;
			//stackData[++top] = item;
		}else{
			System.out.println("Stack is full. Cannot push.");
		}
	 }
	 public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack is empty. Cannot pop.");
		}
		return stackData[top--];
	 }
	 public int peek() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack is empty. Cannot peek.");
		}
		return stackData[top];
	 }
	 public void display() {
		 /*
		System.out.println("------Values in the stack------");
		for(int i=top; i>=0; i--){
			System.out.println(stackData[i]);
		}
		*/
		System.out.println("------------");
        System.out.print("[ ");
        for(int i=top; i>=0; i--){
            System.out.print(stackData[i] + " ");
        }
        System.out.print("]");
        System.out.println("");
	 }
} //end class StackArray

class StackApp{
	public static void main(String[] args){
		 
		 /*StackArray stackArray = new StackArray(6);
		 stackArray.push(7);
		 stackArray.push(3);
		 
		 stackArray.display();
		 stackArray.push(1);
		 
		 stackArray.display();
		 stackArray.push(5);
		 
		 try{
			 int k = stackArray.peek();
			 System.out.println("Peek is "+k);
			 System.out.println("Poped item is "+stackArray.pop());
			 System.out.println("Poped item is "+stackArray.pop());
			 System.out.println("Poped item is "+stackArray.pop());
			 System.out.println("Poped item is "+stackArray.pop());
			 System.out.println("Poped item is "+stackArray.pop());
		 }catch(Exception e){
			 System.out.println(e);
		 }*/
		 
		 Scanner scanner = new Scanner(System.in);
		 decimalToBinary(scanner.nextInt());
	}
	
	public static void decimalToBinary(int d){
		int temp = d;
		int count = 0;
		while(temp!=0){
			temp = temp/2;
			count++;
		}
		StackArray stackArray = new StackArray(count);
		while(d > 0){
			stackArray.push(d%2);
			d = d/2;
		}
		stackArray.display();
	}
}