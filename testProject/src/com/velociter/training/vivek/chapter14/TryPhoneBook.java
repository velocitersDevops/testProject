package com.velociter.training.vivek.chapter14;

public class TryPhoneBook {

	public static void main(String[] args)
	{
		
			    PhoneBook book = new PhoneBook();                 // The phone book
			    FormattedInput in = new FormattedInput();         // Keyboard input
			    Person someone = null;
			    BookEntry[] entries = null;
			    int what = 0;
			    
			    for(;;) {
			      System.out.println("Enter 1 to enter a new phone book entry\n"+
			                         "Enter 2 to find the numbers for a second name\n"+
			                         "Enter 3 to find the number for a first and second name\n"+
			                         "Enter 4 to find the name for a number\n" +
			                         "Enter 5 to list all the entries\n" +
			                         "Enter 9 to quit.");
			      try {
			        what = in.readInt();
			      } catch(InvalidUserInputException e) {
			        System.out.println(e.getMessage()+"\nTry again.");
			        continue;
			      }
			      switch(what) {
			        case 1:
			          book.addEntry(BookEntry.readEntry());
			          break;
			        case 2:                        // Get names and numbers for a second name the second name
			          System.out.println("\nEnter second name:");
			          String name = null;
			          try {
			            name = in.readString().trim();
			          } catch(InvalidUserInputException e) {
			            System.out.println(e.getMessage()+"\nError Reading a string.");
			            break;
			          }
			          entries = book.getEntries(name);
			          if(entries.length == 0) {
			            System.out.println("No entries found for "+name);
			          } else {
			            System.out.println("Entries found for "+name+":");
			            for(BookEntry entry : entries) {
			              System.out.println("\n"+ entry);
			            }
			          }

			          break;
			        case 3:                        // Get number for a person
			          someone = Person.readPerson();
			          entries = book.getEntries(someone);
			          if(entries.length == 0) {
			            System.out.println("The number for "+someone +
			                             " was not found. ");
			          } else {
			            System.out.println("The number(s) for "+someone + " are:");
			            for(BookEntry entry : entries) {           
			              System.out.println(entry.getNumber());
			            }
			          }
			          break;
			        case 4:                        // Get persons at a given number
			          PhoneNumber number = PhoneNumber.readNumber();
			          entries = book.getEntries(number);
			          if(entries.length == 0) {
			            System.out.println("No entry for the number "+number +
			                             " was found.");
			          } else {           
			            System.out.println("Entries found for "+number +":");
			            for(BookEntry entry : entries) {
			              System.out.println("\n"+ entry.getPerson());
			            }
			          }
			          break;
			        case 5:                        // List all the entries
			          book.listEntries();
			          break;
			        case 9:
			          book.save();
			          System.out.println("Ending program.");
			          return;
			        default:
			          System.out.println("Invalid selection, try again.");
			          break;
			      }
			    }
			  
		 }
	}


