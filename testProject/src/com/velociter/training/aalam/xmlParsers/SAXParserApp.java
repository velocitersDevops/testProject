package com.velociter.training.aalam.xmlParsers;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserApp 
{
	public static void main(String[] args)
	{
		try
		{
			//File fileObject = new File("e:\\programingExample\\xmlParser\\employee.txt");
			File fileObject = new File("e:\\programingExample\\xmlParser\\input.txt");
            //it is responsible to make connection with SAX Parser then we need to create object of the
			//SAXParserFactory class Object
			SAXParserFactory saxParserFactoryObject = SAXParserFactory.newInstance();
			//saxParserFactoryObject.setNamespaceAware(true);
			//saxParserFactoryObject.setValidating(true);
			//System.out.println(" "+saxParserFactoryObject.isValidating());
			//it will create instance of the parser by using object of the SAXParserFactory
            SAXParser saxParserObject = saxParserFactoryObject.newSAXParser();
		    //uri
		    //here it will parse the content of the xml document
            System.out.println("\t\t\t   Student Details");
            System.out.println("\t\t\t=====================\n");
		    saxParserObject.parse(fileObject,new UserHandler());
		    
		}catch(Exception fnfe)
		{
			fnfe.getStackTrace();
		}


	}

}
