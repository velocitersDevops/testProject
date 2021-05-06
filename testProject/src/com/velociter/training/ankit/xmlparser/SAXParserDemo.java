package com.velociter.training.ankit.xmlparser;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserDemo {
public static void main(String args[])
{
	try
	{
		//File file = new File("E:\\xml\\employee.txt");
		File file = new File("E:\\xml\\sax_input.txt");
		// it is responsible to make connection with SAX parser then we need to create object of the 
		//SAXParserFactory class object
		SAXParserFactory spf=SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		spf.setValidating(true);
		//System.out.println(""+spf.isValidating());
		
		// it will create instance of the parser by using object of the SAXParserFactory 
		
		SAXParser saxParser=spf.newSAXParser();
		//uri
		// Here it will parse the content of the xml document.
		saxParser.parse(file,new UserHandler());
		
	}
	catch(Exception e)
	{
		
	}
}
}
