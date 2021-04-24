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
		
		PrintNode(list);
		
		
	}

	private static void PrintNode(NodeList nList)
	
	{
		for(int i=0;i<nList.getLength();i++)
		{
		  Node node=nList.item(i);
		  
		//  System.out.println("\n"+node.getNodeName());
		  
		  if(node.hasChildNodes() )
		  {
			  System.out.println("\n"+node.getNodeName());
			  
			  if(node.hasAttributes())
			  {
				  System.out.println("\n"+node.getAttributes().item(0));
			  }
			  
			  if(node.getChildNodes().getLength()==1)
			  {
				  System.out.println("\n"+node.getTextContent());
			  }
			  
			//  System.out.println("----------------------------------------------------");
			  
			  PrintNode(node.getChildNodes());
		  }
		  
		  
		}
		
	}

}

