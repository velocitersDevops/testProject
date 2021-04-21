package com.velociter.training.ankit.generics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.Scanner;

public class StackClass<T extends Object> {
	 
    private int stackSize;
    private T[] stackArr;
    private static  int top;
	private int lenght;
     
   
    public StackClass(int size) {
        this.stackSize = size;
        this.stackArr = (T[]) new Object[stackSize];
        this.top = -1;
    }
    public void push(T entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        else if(this.isStackEmpty()){
            System.out.println("Stack is Empty");
            System.exit(0);
        }
        System.out.println("Adding: "+entry);
        this.stackArr[++top] = entry;
    }
 
    public T pop()  {
        if(this.isStackEmpty()){
            System.out.println("Stack is Empty");
            System.exit(0);
        }
        T entry = this.stackArr[top--];
        System.out.println("Removed entry: "+entry);
        return entry;
    }
    public void displayAll()
    {
    	System.out.println("All Objects of Stack are :");
    	for(int i=0;i<stackSize;i++)
    	System.out.println(stackArr[i]);
    }
     public void serialize()
     {
    	 System.out.println("All Objects of Stack are :");
    	 String filePath="E:\\New folder\\stackSerialization.txt";
//    		ObjectOutputStream objectOut=null;
 
    		try {
    			ObjectOutputStream objectOut=new ObjectOutputStream(new FileOutputStream(filePath,true));
    			//objectOut=new ObjectOutputStream(new BufferedOutputStream(new  FileOutputStream(filePath)));
    			for(int i=0;i<stackSize-1;i++) {
    		        	//stringStack.push(v);
    		        objectOut.writeObject(stackArr[i]);
    			 }System.out.println("File Created"); 
    		} catch (FileNotFoundException e) 
    		{
    		  e.printStackTrace();
    		}
    		catch (StreamCorruptedException e1)
    		{
    		 e1.printStackTrace();
    		}
    		catch (IOException e2) 
    		{
    		  e2.printStackTrace();
    		}
     }
    public T peek() {
        return stackArr[top];
    }
 
    private void increaseStackCapacity(){
         
        T[] newStack = (T[]) new Object[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
     
    public boolean isStackEmpty() {
        return (top == -1);
    }
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
     
    public static void main(String a[]) throws Exception{
    	StackClass<String> stringStack = new StackClass<String>(10);
        
        StackClass<Double> doubleStack = new StackClass<Double>(10);
        //double[] values = { 1.0, 1.1 , 1.2 , 2.0, 2.1, 2.2, 3.0, 3.1, 3.2 }; 
        //String[] stringValues= {"one","two", "three", "four", "five","six","seven","eight","Nine","ten"};
        int choice,choice1 =1;
        String[] stringValues= {};
        Scanner sc=new Scanner(System.in);
        do {
        	System.out.println("Choose Operation\n 1 Push \n 2.Pop");
        choice=sc.nextInt();
        // Store the values on the stack
        if(choice==1)
        {
        System.out.println("Data pushed onto the stack in sequence is:");
       // for(double v : values) {
      //doubleStack.push(v);
        //}
        	
        for(String v : stringValues) {
        	stringStack.push(v);
        }
        }
        else if (choice==2)
        {
//        for(double v : values) {
//        
//			doubleStack.pop();
//		} 
        for(String v : stringValues) {
            
        	stringStack.pop();
		} 
        }
       
        else
        {
        	System.out.println("Invalid Choice");
        	main(a);
        
        }
        
    }
        while(choice1==1);
        stringStack.displayAll();
    }
}
