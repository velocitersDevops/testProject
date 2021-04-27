package com.velociter.training.mukesh.xmlParser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParsarDemo 
{
	public static void main(String[] args) 
	{

		try 
		{
			
	        File inputFile = new File("E:\\xmlDocument\\saxInput.txt");                 //file path of xml document
	        
	         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     //create DocumentBuilderFactory object
	         
	         DocumentBuilder builder = factory.newDocumentBuilder();               //create DocumentBuilder object
	         
	         Document document = builder.parse(inputFile);						// parse the xml file 
	         document.getDocumentElement().normalize();                 
	         
	         //Here It will return root element of document
	         System.out.println("Root of xml document :" + document.getDocumentElement().getNodeName());
	        
	         
	         
	         System.out.println("-----------company record ------------");
	        
	         NodeList companylist = document.getElementsByTagName("company");
	         for(int i=0;i<companylist.getLength();i++)
	         {
	        	 Node node=companylist.item(i);
	        	 System.out.println("\nCurrent Element : " + node.getNodeName());
	        	 
	        	 if(node.getNodeType()==Node.ELEMENT_NODE)
	        	 {
	        		 Element element=(Element) node;
	        		 
	        		 System.out.println("company id      : "+element.getAttribute("id"));
	        		 System.out.println("company name    : "+element.getElementsByTagName("cmp_name").item(0).getTextContent());
	        		 System.out.println("company addr    : "+element.getElementsByTagName("Address").item(0).getTextContent());
	        	 }
	         }
	         
	         
	         System.out.println();
	         System.out.println("---------student record ------------");
	        
	         NodeList studentlist = document.getElementsByTagName("student");
	        
	         for(int i=0;i<studentlist.getLength();i++)
	         {
	       
	        	 Node node=studentlist.item(i);
	        	 System.out.println("\nCurrent Element    : " + node.getNodeName());
	        	 if(node.getNodeType()==Node.ELEMENT_NODE)
	        	 {
	        		 Element element=(Element)node;
	        		
	        		 System.out.println("Student rollno     : "+element.getAttribute("rollno"));
	        		 System.out.println("Student first name : "+element.getElementsByTagName("firstname").item(0).getTextContent());
	        		 System.out.println("Student last name  : "+element.getElementsByTagName("lastname").item(0).getTextContent());
	        		 System.out.println("Student nick name  : "+element.getElementsByTagName("nickname").item(0).getTextContent());
	        		 System.out.println("Student marks      : "+element.getElementsByTagName("marks").item(0).getTextContent());
	        		 System.out.println("Student work email : "+element.getElementsByTagName("work").item(0).getTextContent());
	        		 System.out.println("Student perm mail  : "+element.getElementsByTagName("perm").item(0).getTextContent());
	        		 
	        		 if(element.getElementsByTagName("city").item(i)==null)
	        		 {
	        			 System.out.println(" ");
	        		 }
	        		 else
	        		 {
	        			 System.out.println("Student city       : "+element.getElementsByTagName("city").item(0).getTextContent());
	        			 System.out.println("Student dist       : "+element.getElementsByTagName("district").item(0).getTextContent());
	        		 }
	        		 
	        		 
	        	 }
	         }
		} 
		catch (ParserConfigurationException |SAXException |IOException e) 
		{
            e.printStackTrace();
        }
		    
	  }
}

