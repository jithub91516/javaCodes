package assignment4;

public class EncryptDecrypt {
	
	
	private Node top,bottom;
	private int size,seed;
	private boolean point = false;
	
	public EncryptDecrypt() {
		Node newNode = new Node();
		newNode.name = null;
		newNode.next = top;
		
		this.top = newNode;
		this.bottom = newNode;
		this.size = 0;
		this.seed = 12;
	}

	public void jisangEncrypt() {
		Node temp = top;
		if(!point) {
		while (temp.next != top) {
			temp = temp.next;
			String tempString = " ";
			for (int i = 0; i < temp.name.length(); i++) {
				tempString = tempString + (char) (temp.name.charAt(i) + seed);
			}
			temp.name = tempString;
		}
		System.out.println("Encrypt Successful");
		point = true;
		}
		
		else
			System.out.println("Encrypt Fail");
	}
	
	public void jisangDecrypt() {
		Node temp = top;
		if(point) {
			while (temp.next != top) {
				temp = temp.next;
				String tempString = " ";
				
				for (int i = 0; i < temp.name.length(); i++) {
					tempString = tempString + (char) (temp.name.charAt(i) - seed);
				}
				
			temp.name = tempString;
			}
			
		System.out.println("Dectypt Successful");
		point = false;
		
		}
		
		
		else 
			System.out.println("Decrypt Fail");
	}
	
	public void jioutput() {
		 Node temp = top;
			while (temp.next != top) {
				temp = temp.next;
				System.out.println(temp.name);
			}
			System.out.println();
	}
	
	public void jiinput(String name) {
        
		Node newNode = new Node();
		newNode.name = name;

		bottom.next = newNode;
		newNode.next = top;
		bottom = newNode;
		size++;
    }
		
	
	

	public int getSize() {
		return size;
	}
}
class Node{
	String name;
	Node next;
	Node previous;
	
	public Node() {
		
	}
	public Node(String name, Node next, Node previous) {
		this.name = name;
		this.next = next;
		this.previous = previous; 
	}
}

