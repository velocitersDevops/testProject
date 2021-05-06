package com.velociter.training.ankit.xmlparser;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


//Dom Parser Example
public class DomParser
{
	public static void main(String[] ar) 
	{

	      try {
	         File inputFile = new File("E:\\xml\\sax_input.txt");
	         //Obtain DOM object tree. RAM
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         
	         //dbFactory.setValidating(true);
	         //Here we will get instance of DOM document object.
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         
	         //Xml it is represent  as XML document 
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         
	         //Here It will return root element of document
	         System.out.println("Root :" + doc.getDocumentElement().getNodeName());
	         
	         //It is used for to store no. of child element from xml document and it will act as Node. 
	         System.out.println("----------------------------");
	         NodeList cList = doc.getElementsByTagName("student");
	         for(int i=0;i<cList.getLength();i++)
	         {
	        	 //It is base data type  of DOM
	        	 Node nNode=cList.item(i);
	        	 System.out.println("\nAttribute :" + nNode.getNodeName());
	        	 if(nNode.getNodeType()==Node.ELEMENT_NODE)
	        	 {
	        		 Element element=(Element) nNode;
	        		 //getAttribute it will retuen attributes of 
	        		    System.out.println("Rollno                   :"+element.getAttribute("rollno"));
		        		System.out.println("First Name               :"+element.getElementsByTagName("firstname").item(0).getTextContent());
		        		System.out.println("LastName                 :"+element.getElementsByTagName("lastname").item(0).getTextContent());
		        		System.out.println("NickNmae                 :"+element.getElementsByTagName("nickname").item(0).getTextContent());
		        		System.out.println("Marks                    :"+element.getElementsByTagName("marks").item(0).getTextContent());
		        		System.out.println("Email");
		        		System.out.println("\tWork Email        :"+element.getElementsByTagName("work").item(0).getTextContent());
		        		System.out.println("\tPermamant Email   :"+element.getElementsByTagName("perm").item(0).getTextContent());
		        		
		        		element.getChildNodes();
		        		if((element.getElementsByTagName("address").getLength() == 0))
		        		{
			        		System.out.println(" ");	
		        		}else
		        		{System.out.println("Address");
		        			System.out.println("\tCity             :"+element.getElementsByTagName("city").item(0).getTextContent());
			        		System.out.println("\tDistrict         :"+element.getElementsByTagName("district").item(0).getTextContent());
		        		}
		        	
		        		//System.out.print("address        :"+element.getElementsByTagName("address").item(0).getTextContent());
	        	 }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	}

