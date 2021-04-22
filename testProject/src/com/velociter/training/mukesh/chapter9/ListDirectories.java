package com.velociter.training.mukesh.chapter9;
import java.io.File;
import java.io.FileFilter;
 
public class ListDirectories implements FileFilter 
{
		private static StringBuffer string = new StringBuffer();

	  public static void main(String[] args) 
	  {
	  		File[] roots = null;

	    	if(args.length>0) 
	    	{                              						 // Check for command line argument                            
		    	File directory = new File(args[0]);
		    	if(directory.isDirectory()) 
		    	{                   							
		        roots = new File[1];                          
		        roots[0] = directory;
		    	}
		    	else 
		    	{                                       
		        System.out.println(directory.getName()+" is not a directory");
		        System.exit(1);
		    	}
	    	}
	    	else
	    	{                                                 // If no command line argument
	    		roots = File.listRoots();                        // get the system roots
	    	}
                              
	    	ListDirectories lister = new ListDirectories();    // Create object to do the listing
		    
	    	for(File root : roots) 
		    {                           						// and list all the directories
		      lister.listDirectories(root);
		    }
  }


			  private void listDirectories(File rootDirectory) 
			  {
				    String name = rootDirectory.getName();
				    if(name.length()==0) 
				    {                             						
				      name = rootDirectory.getPath();                 
				    }
				    
				    System.out.println(string.toString()+name);        
				    string.append("  ");                               
				    File[] fileList = rootDirectory.listFiles(this);   
				    if(fileList != null) 
				    {                             						
				      for(File file : fileList) 
				      {                      							
				        listDirectories(file);
				      }
				    }
			
				    string.delete(string.length()-2, string.length());  
				    return;                                            
			   }

				  // Filter method to only accept directories
				  public boolean accept(File file) 
				  {
				    return file.isDirectory();
				  }  

}
