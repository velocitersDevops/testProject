package com.velociter.training.ankit.generics;

import java.util.Scanner;

public class StackDisplay<T extends Object> {
       public static void main(String a[]) {
    	StackClass<String> stringStack = new StackClass<String>(10);
        
        StackClass<Double> doubleStack = new StackClass<Double>(10);
        //double[] values = { 1.0, 1.1 , 1.2 , 2.0, 2.1, 2.2, 3.0, 3.1, 3.2 }; 
        String[] stringValues= {"one","two", "three", "four", "five","six","seven","eight","Nine","ten"};
        int choice,choice1 =1;
        
        Scanner sc=new Scanner(System.in);
        do {
        	System.out.println("Choose Operation\n 1 Push \n 2.Pop \n 3. Display");
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
        else if (choice==3)
        	 stringStack.displayAll();
        
        else
        {
        	System.out.println("Invalid Choice");
        	main(a);
        
        }
        
    }
        while(choice1==1);
    }
}
