package doublelinked;



public class DoubleLinked<number> {
	 
    private Node head;
    private Node tail;
    private int size;
     
    public DoubleLinked() {
        size = 0;
    }
    
    private class Node {
        number String;
        Node next;
        Node prev;
 
        public Node(number data, Node next, Node prev) {
            this.String = data;
            this.next = next;
            this.prev = prev;
        }
    }
   
    public int size() { return size; }
     
    
    public boolean isEmpty() { return size == 0; }
     
     
    
    public void push(number data) {
         
        Node tmp = new Node(data, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        size++; 
    }
     
    
    public void iterateForward(){
    		System.out.println();
        System.out.println("Forward Direction");
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.String+" ");
            tmp = tmp.next;
        }
    }
   
    public void iterateBackward(){
        System.out.println();
        System.out.println("Backword Direction");
        Node tmp = tail;
        while(tmp != null){
            System.out.print(tmp.String+" ");
            tmp = tmp.prev;
        }
    }
     
  
  
     
    public static void main(String a[]){
         
    	DoubleLinked<Integer> dll = new DoubleLinked<Integer>();
        dll.push(1);
        dll.push(2);
        dll.push(3);
        dll.push(4);
        dll.push(5);
        dll.iterateForward();
        dll.iterateBackward();
       
    }
}


