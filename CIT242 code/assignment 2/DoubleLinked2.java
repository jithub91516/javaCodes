package doublelinked2;

import java.util.NoSuchElementException;

public class DoubleLinked2<number> {
	 
    private Node head;
    private Node tail;
    private int size;
     
    public DoubleLinked2() {
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
     
   
    public void addFirst(number data) {
        Node tmp = new Node(data, head, null);
        if(head != null ) {head.prev = tmp;}
        head = tmp;
        if(tail == null) { tail = tmp;}
        size++;
        System.out.print(data+" ");
    }
     
    
    public void addLast(number data) {
         
        Node tmp = new Node(data, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        size++; 
        System.out.print(data+" ");
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
        System.out.println("Backword Direction");
        Node tmp = tail;
        while(tmp != null){
            System.out.print(tmp.String+" ");
            tmp = tmp.prev;
        }
    }
     
  
    public number removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println();
        System.out.println("deleted: "+tmp.String);
        return tmp.String;
    }
     
  
    public number removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: "+tmp.String);
        return tmp.String;
    }
     
    public static void main(String a[]){
         
    	DoubleLinked2<Integer> dll = new DoubleLinked2<Integer>();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.iterateForward();
        dll.removeFirst();
        dll.removeLast();
        dll.iterateBackward();
      
    }
}

