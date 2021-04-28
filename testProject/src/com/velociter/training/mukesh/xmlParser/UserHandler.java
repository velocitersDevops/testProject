package com.velociter.training.mukesh.xmlParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler
{
	boolean isCompanyName=false;
	boolean isFirstName=false;
	boolean isLastName=false;
	boolean isNickName=false;
	boolean isMarks=false;
	boolean isWorksEmail=false;
	boolean isPermanentEmail=false;
	boolean isCity=false;
	boolean isDistrict=false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
	{
		
		super.startElement(uri, localName, qName, attributes);
		if(qName.equalsIgnoreCase("company"))
		{
			System.out.println("--------------------");
			String id=attributes.getValue("id");
			System.out.println("ID : "+id);
		}
		else if(qName.equalsIgnoreCase("cmp_name"))
		{
			isCompanyName=true; 
		}
		if(qName.equalsIgnoreCase("student"))
		{
			System.out.println("--------------------");
			String rollno=attributes.getValue("rollno");
			System.out.println("Rollno :"+rollno);
		
		}else if(qName.equalsIgnoreCase("firstname"))
		{
			 isFirstName=true;
		}
		else if(qName.equalsIgnoreCase("lastname"))
		{
			 isLastName=true;
		}
		else if(qName.equalsIgnoreCase("nickname"))
		{
			 isNickName=true;
		}
		else if(qName.equalsIgnoreCase("marks"))
		{
			 isMarks=true;
		}
		else if(qName.equalsIgnoreCase("work"))
		{
			isWorksEmail=true;
		}
		else if(qName.equalsIgnoreCase("perm"))
		{
			isPermanentEmail=true;
		}
		else if(qName.equalsIgnoreCase("city"))
		{
			isCity=true;
		}
		else if(qName.equalsIgnoreCase("district"))
		{
			isDistrict=true;
		}
		
	}
	
	//call beginning of the end element
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		super.endElement(uri, localName, qName);
	}
	
	//
	@Override
	public void startDocument() throws SAXException {
		
		super.startDocument();
		System.out.println("Begining of the document"+"\n");
	}
	
	@Override
	public void endDocument() throws SAXException {
		
		super.endDocument();
		System.out.println("\n"+"End of the document");
	}
	
	// if character data encounter then it will call characters method
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		super.characters(ch, start, length);
		
		if(isCompanyName)
		{
			
			System.out.println("Company Name           : "+new String(ch, start, length));
			isCompanyName=false;
		}
		
		if(isFirstName)
		{
			
			System.out.println("Student firstName      : "+new String(ch, start, length));
			isFirstName=false;
		}
		if(isLastName)
		{
			System.out.println("Student laststName     : "+new String(ch, start, length));
			isLastName=false;
		}
		if(isNickName)
		{
			System.out.println("Student nickName       : "+new String(ch, start, length));
			isNickName=false;
		}
		if(isMarks)
		{
			System.out.println("Student marks          : "+new String(ch, start, length));
			isMarks=false;
		}
		if(isWorksEmail)
		{
			System.out.println("Student work email     : "+new String(ch, start, length));
			isWorksEmail=false;
		}
		if(isPermanentEmail)
		{
			System.out.println("Student prmanent email : "+new String(ch, start, length));
			isPermanentEmail=false;
		}
		if(isCity)
		{
			System.out.println("Student city           : "+new String(ch, start, length));
			isCity=false;
		}
		if(isDistrict)
		{
			System.out.println("Student district       : "+new String(ch, start, length));
			isDistrict=false;
		}
		
		
	}

}
