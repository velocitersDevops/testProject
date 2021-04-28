package com.velociter.training.vivek.xmlParser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXmlFile {

	public static void main(String[] args)  throws Exception
	{
		File file= new File("C:\\AvoidFile\\newxmlFile.xml");
        
		DocumentBuilderFactory fact= DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder= fact.newDocumentBuilder();
		
		Document doc= builder.parse(file);
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		NodeList list= doc.getChildNodes();
		
		//System.out.println(list.getLength());
		
		PrintNode(list);
		
		
	}

	private static void PrintNode(NodeList nList)
	
	{
		int maxLength=0;
		for(int i=0;i<nList.getLength();i++)
		{
		  Node node=nList.item(i);
		  
		//  System.out.println("\n"+node.getNodeName());
		  
		  if(node.hasChildNodes() )
		  {
			  System.out.print(node.getNodeName());
			  
			  //logic for alignment
			  String name=node.getNodeName();
			  int nodeLength=name.length();
			    if(maxLength<nodeLength)
			    {
			      maxLength=nodeLength;	
			    }
			    
			    for(int j=0;j<(maxLength-nodeLength);j++)
			    {
			    	System.out.print(" ");
			    }
			  
			    System.out.print("   :");
			  
			  if(node.hasAttributes())
			  {
				  
				  System.out.println();
				  System.out.println("\n"+node.getAttributes().item(0));
				 // System.out.println("----------");
			  }
			  
			  if(node.getChildNodes().getLength()==1)
			  {
				  System.out.println(node.getTextContent());
			  }
			 
			  
			  
			  PrintNode(node.getChildNodes());
			  
		  }
		  
		}
		
	}

}

