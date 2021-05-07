package com.velociter.training.ankit.xmlparser;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
public class JDOMParser {
  public static void main(String [] args)
  {
	  try {
		  
		  File file = new File("E:\\xml\\sax_input.txt");
		  
		  SAXBuilder saxBuilder=new SAXBuilder();
		  
		 // it will create JDOM document from xml document
		  
		  // it is represent of the xml document
		  Document doc=saxBuilder.build(file);
		  
		System.out.println("Root Element : "+doc.getRootElement().getName());
		
		// it will return root element
		Element element=doc.getRootElement();
		// Stored child elements of company in list 
		List<Element>  listCompany=element.getChildren();
		
		for(int k=0;k<listCompany.size();k++)
		{
			// aacess , modify and create of xml element
			Element elementStudent=listCompany.get(k);
			
			
			//List<Attribute> attributes=elementStudent.getAttributes();
			System.out.println("\n=======================================================================");	
			System.out.println("Child Element :"+listCompany.get(k).getName());
			System.out.println("First Name :"+elementStudent.getChild("firstname").getText());
			System.out.println("Second Name : "+ elementStudent.getChild("lastname").getText());
			System.out.println("NickName : "+ elementStudent.getChild("nickname").getText());
			System.out.println("Marks: "+ elementStudent.getChild("marks").getText());
			System.out.println("Working Email : "+elementStudent.getChild("email").getChildText("work"));
			System.out.println("Permanant Email : "+elementStudent.getChild("email").getChildText("perm"));
			if((elementStudent.getChild("address") != null))   //if address found then print otherwise not display
		       { System.out.println("Address :");
			    System.out.println("\t\tCity                :"+ elementStudent.getChild("address").getChildText("city"));
			    System.out.println("\t\tDistrict            :"+ elementStudent.getChild("address").getChildText("district"));		
		       }
		else
		{
			System.out.print("");
		}
			//System.out.println("Email : "+ ((Element) elementStudent.getChildren()).getChild("email").getText()+elementStudent.getChild("work").getText());
			
			System.out.println("\n=======================================================================");
		            
			
		}
				
	} catch (JDOMException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
}
