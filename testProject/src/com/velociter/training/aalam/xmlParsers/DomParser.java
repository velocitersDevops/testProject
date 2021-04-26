package com.velociter.training.aalam.xmlParsers;

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

public class DomParser 
{

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

	      try {
	         File inputFile = new File("E:\\programingExample\\xmlParser\\input.txt");
	         //Obtain DOM object tree. RAM
	         //here create Dom object(A)
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         
	         //dbFactory.setValidating(true);
	         //Here we will get instance of DOM document object.
	         //here create Dom document object(A)
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         
	         //Xml it is represent  as XML document (I)
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         
	         //Here It will return root element of document
	         System.out.println("\t\tRoot Eelement :" + doc.getDocumentElement().getNodeName());
	         
	         //It is used for to store no. of child element from xml document and it will act as Node. 
	         System.out.println("            ----------------------------");
	         NodeList cList = doc.getElementsByTagName("company");
	         System.out.println("");
 	         System.out.println("================Company Records=============================\n");
	         for(int i=0;i<cList.getLength();i++)
	         {
	        	 //It is base data type  of DOM
	        	 Node nNode=cList.item(i);
	        	// System.out.println("\nCurrent Element :" + nNode.getNodeName());
	        	
	        	 if(nNode.getNodeType()==Node.ELEMENT_NODE)
	        	 {
	        		 //Using Element interface we can access and modify content of the xml document.
	        		 Element element=(Element) nNode;
	        		 //getAttribute it will retuen attributes of 
	        		 System.out.println("\t\tCompany id : "+element.getAttribute("id"));
	        		 System.out.println("\t\tCompany name : "+element.getElementsByTagName("cmp_name").item(0).getTextContent());
	        		 System.out.println("\t\tAddress : "+element.getElementsByTagName("Address").item(0).getTextContent());
	        		 
	        	 }
	         }
	         //here i am getting student record from xml file
	         System.out.println("");
	         System.out.println("================Student Records=============================\n");
	         NodeList nextClist = doc.getElementsByTagName("student");
	         for(int i=0; i < nextClist.getLength() ;i++)
	         {
	        	 Node nextChildNode = nextClist.item(i);
	        	// System.out.println(" "+nextNode.getNodeName());
	        	 if(nextChildNode.getNodeType() == Node.ELEMENT_NODE)
	        	 {
	        		Element element =  (Element) nextChildNode;
	        		//getting Attribute
	        		System.out.println("\t\tRollno               :"+element.getAttribute("rollno"));
	        		System.out.println("\t\tFirst Name           :"+element.getElementsByTagName("firstname").item(0).getTextContent());
	        		System.out.println("\t\tLastName             :"+element.getElementsByTagName("lastname").item(0).getTextContent());
	        		System.out.println("\t\tNickNmae             :"+element.getElementsByTagName("nickname").item(0).getTextContent());
	        		System.out.println("\t\tMarks                :"+element.getElementsByTagName("marks").item(0).getTextContent());
	        		System.out.println("\t\tWorking Email        :"+element.getElementsByTagName("work").item(0).getTextContent());
	        		System.out.println("\t\tPersonal Email       :"+element.getElementsByTagName("perm").item(0).getTextContent());
	        		element.getChildNodes();
	        		if((element.getElementsByTagName("city").getLength() == 0))
	        		{
		        		System.out.println(" ");	
	        		}else
	        		{
	        			System.out.println("\t\tCity                 :"+element.getElementsByTagName("city").item(0).getTextContent());
		        		System.out.println("\t\tDistrict             :"+element.getElementsByTagName("district").item(0).getTextContent());
	        		}
	        		
	        
	        		
	        		
	        		System.out.println("\t\t-------------------------------------------");
	        	 }//outer if close
	         }//close forloop
	      } catch (NullPointerException e)
	      {
	    	  //System.err.println("Some Data not available !");
	         e.printStackTrace();
	      }
	   }


}
