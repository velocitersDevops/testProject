package com.velociter.training.ankit.chapter6;
public class SinglyLinkedList {
	
	  Node head , tail;
	  class Node {
	    Object item;
	    Node next;

	    Node(Object d) {
	      item = d;
	      next = null;
		 
	    }
	  }
	  public boolean compareNode(Object data) {    
	          Node node = head;
			  
		while (node != null) {
			
	      if((node.item).equals(data))
		  {
			//System.out.println(check.getClass().getName());
			//System.out.println(node.getClass().getName());  
		  return true;
		  }
	      node = node.next;
	    }
		return false;
	  }
	  
	     public void addNode(Object data) {    
	          
	        Node new_Node = new Node(data); 
		
	        if(head == null) {    
	            head = new_Node;    
	            tail = new_Node;    
	        }    
	        else {    
	            tail.next = new_Node;    
	            tail = new_Node;    
	        }    
	    }  


	  public void insertAtBeginning(Object data) {
	    // insert the item
	    Node new_node = new Node(data);
	    new_node.next = head;
	    head = new_node;
	  }

	  public void insertAfter(Node prev_node, Object data) {
	    if (prev_node == null) {
	      System.out.println("The given previous node cannot be null");
	      return;
	    }
	    Node new_node = new Node(data);
	    new_node.next = prev_node.next;
	    prev_node.next = new_node;
	  }

	  public void insertAtEnd(Object data) {
	    Node new_node = new Node(data);

	    if (head == null) {
	      head = new Node(data);
	      return;
	    }

	    new_node.next = null;

	    Node last = head;
	    while (last.next != null)
	      last = last.next;

	    last.next = new_node;
	    return;
	  }

	  void deleteNode(int position) {
	    if (head == null)
	      return;

	    Node node = head;

	    if (position == 0) {
	      head = node.next;
	      return;
	    }
	    // Find the key to be deleted
	    for (int i = 0; node != null && i < position - 1; i++)
	      node = node.next;

	    // If the key is not present
	    if (node == null || node.next == null)
	      return;

	    // Remove the node
	    Node next = node.next.next;

	    node.next = next;
	  }

	  public void printList() {
	    Node node = head;
	    while (node != null) {
	      System.out.print(node.item + " ");
	      node = node.next;
	    }
	  }
	  
	  public void BackprintList() {
		       String sum ="";
	           Node current = head;
	           Node previous = null;
	           while (current != null) {
	            sum = sum+" "+current.item;
	            previous = current;
	            current = current.next;
	       }
			String []wordString=sum.split(" ");
			String reverseString="";
			for(int i=wordString.length-1;i>=0;i--)
			{
	         reverseString=reverseString+wordString[i]+" ";
			}
			System.out.println(reverseString);    
	 }
	 
	 public void insertNth(int data, int position) {
	        //create new node.
	        Node new_Node = new Node(data);
	        new_Node.item = data;
	        new_Node.next = null;


	        if (this.head == null) {
	            //if head is null and position is zero then exit.
	            if (position != 0) {
	                return;
	            } else { //node set to the head.
	                this.head = new_Node;
	            }
	        }

	        if (head != null && position == 0) {
	            new_Node.next = this.head;
	            this.head = new_Node;
	            return;
	        }

	        Node current = this.head;
	        Node previous = null;

	        int i = 0;

	        while (i < position) {
	            previous = current;
	            current = current.next;

	            if (current == null) {
	                break;
	            }

	            i++;
	        }

	        new_Node.next = current;
	        previous.next = new_Node;
	    }

}
