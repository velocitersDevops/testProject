package com.velociter.training.ankit.writingfiles;

public class PermuteWord {
	
 static void printPermutn(String string)
 {
	 if(string.length()==0)
	 {
		 System.out.println("String is Null");
		 System.exit(0);
	 
	 }
	 String []wordString=string.split(" ");
	 int wordLength=wordString.length;
	 int index=0;
	 System.out.println(string.length());
		String[] extract=new String[wordLength];
		for(String w:wordString)
		{
			extract[index]=w;
			index++;
		}
		
		for(String e:extract)
		{
			System.out.println(e);
			
		}
		
		for (int i = 0; i < wordLength; i++) {
           String startWord=wordString[i];
	       int startWordLength=startWord.length();
           System.out.println(string.substring(i+1, wordLength));
	    }
 }
		/* 
		for (int i=0;i <extract.length-1; i++) 
	        {
	            for (int j = 0; j <extract.length-1-i; j++) { 
	                if (extract[j].compareToIgnoreCase(extract[j+1])>0) 
	                {
	             String temprary= extract[j];
	                	extract[j] = extract[j+1];
	                	extract[j+1] = temprary;
	                }
	            }
	            for(String e:extract)
				{
					System.out.print(e+" ");
					
				}
	            System.out.println();
	 }
	 */
//		 System.out.println("After ");
//		 for(String e:extract)
//			{
//				System.out.print(e+" ");
//				
//			}
 //}
	
  
    // Driver code
    public static void main(String[] args)
    {
        String s = "Ankit mat";
        printPermutn(s);
       
    }
}





/*
static void printPermutn(String str, String ans)
{

    // If string is empty
    if (str.length() == 0) {
        System.out.print(ans + " ");
        return;
    }

    for (int i = 0; i < str.length(); i++) {

        // ith character of str
        char ch = str.charAt(i);

        // Rest of the string after excluding 
        // the ith character
        String ros = str.substring(0, i) + 
                     str.substring(i + 1);

        // Recurvise call
        printPermutn(ros, ans + ch);
    }
}*/