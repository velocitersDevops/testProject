package com.velociter.training.mukesh.xmlParser;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXParserDemo
{
		public static void main(String args[])
		{
			
			try
			{
				File file=new File("E:\\xmlDocument\\saxInput.xml");
				
				//SAXParserFactory class object
				SAXParserFactory factory=SAXParserFactory.newInstance();
				
				factory.setNamespaceAware(true);
				factory.setValidating(true);
				
				SAXParser saxParser=factory.newSAXParser();
	
				// Here it will parse the content of the xml document.
				saxParser.parse(file,new UserHandler());
			}
			catch(ParserConfigurationException|SAXException|IOException e){
				e.printStackTrace();
			}
		}
			
		
}
