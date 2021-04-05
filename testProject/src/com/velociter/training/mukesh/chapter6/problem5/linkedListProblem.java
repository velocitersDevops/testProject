package com.velociter.training.mukesh.chapter6.problem5;
import java.io.*;
import java.util.Scanner; 

public class linkedListProblem { 

    	Node head; 
    	static class Node 
    	{ 
	    	int data; 
	    	Node next; 

        Node(int value) 
        { 

            data = value; 
            next = null; 
        } 

    } 

    public static linkedListProblem insert(linkedListProblem list, int data) 

    { 

        // Create a new node with given data 

        Node newNode = new Node(data); 

        newNode.next = null; 
        // If the Linked List is empty, 

        // then make the new node as head 

        if (list.head == null) { 

            list.head = newNode; 

        } 

        else { 

            // Else traverse till the last node 

            // and insert the new_node there 

            Node last = list.head; 

            while (last.next != null) { 

                last = last.next; 

            } 
            // Insert the new_node at last node 

            last.next = newNode; 

        } 
        return list; 

    } 

    void deleteNode(int key)
    {
        // Store head node
        Node temp = head; 
        Node preview = null;
 
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }
 
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            preview = temp;
            temp = temp.next;
        }
 
        // If key was not present in linked list
        if (temp == null)
            return;
 
        // Unlink the node from linked list
        preview.next = temp.next;
    }
   

    // Method to print the LinkedList. 

    public static void printList(linkedListProblem list) 

    { 

        Node currentNode = list.head; 
       
        // Traverse through the LinkedList 

        while (currentNode != null) { 

            // Print the data at current node 

            System.out.print(currentNode.data + " "); 
            // Go to next node 

            currentNode = currentNode.next; 

        } 

    } 

    public static void main(String[] args) 

    { 

        Scanner input = new Scanner(System.in);
      

        /* Start with the empty list. */ 

        linkedListProblem list = new linkedListProblem(); 
        String result;
        System.out.print("Enter data you want  to insert in list:");
        int insertItem=input.nextInt();
        
    	list = insert(list, insertItem); 
    	printList(list);
    	System.out.println();
        do {
        	

        	
        	System.out.println("Do you want to insert one more data in list[yes / no]:");
        	
        	result= input.next();
        	if(result.equalsIgnoreCase("no"))
        		break;
        	System.out.print("Enter data you want to insert in list:");
        	int insertItem1=input.nextInt();
        
        	list = insert(list, insertItem1); 
        	printList(list);
        	System.out.println();
        	
        }
        while(result.equalsIgnoreCase("yes"));
      
        System.out.println("This is listof items:");
        printList(list);
        System.out.println();
        System.out.println("do you want to delete any item ");
        String result1=input.next();
        if(result1.equalsIgnoreCase("yes")) {
        System.out.println("which data you want to delete :");
        int data=input.nextInt();
      
        list.deleteNode(data);
        System.out.println(
            "\nLinked List after Deletion  ");
        list.printList(list);
        }else if(result1.equalsIgnoreCase("no")) {
        	System.out.println("this is listof items:");
            printList(list);
        }
    } 

}

