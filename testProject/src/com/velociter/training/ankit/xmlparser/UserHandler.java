package com.velociter.training.ankit.xmlparser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler{
	//boolean isCmpName=false;
	boolean firstname =false,lastname =false,nickname =false,marks =false,email =false,work =false,perm =false,address =false,city = false,district =false;
    
	// call beginning of the  element
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(qName.equalsIgnoreCase("student"))
		{
			String id=attributes.getValue("rollno");
			System.out.println("............................................");
			System.out.println("Roll_NO : "+id);
		}
		//else if(qName.equalsIgnoreCase("cmp_name"))
		if(qName.equalsIgnoreCase("firstname"))
		   {
			   firstname=true;
		   }
		   
		   else if(qName.equalsIgnoreCase("lastname"))
		   {
			   lastname=true;
		   }
		   
		   else if(qName.equalsIgnoreCase("nickname"))
		   {
			   nickname=true;
		   }
		   else if(qName.equalsIgnoreCase("marks"))
		   {
			   marks=true;
		   }
		   else if(qName.equalsIgnoreCase("email"))
		   {
			   email=true;
		   }
		   else if(qName.equals("work"))
		   {
			   work=true;
		   }
		  else if(qName.equals("perm"))
		   {
			 perm =true;
		   }
		  	 
		   else if(qName.equalsIgnoreCase("address"))
		   {
			   address=true;
		   }
		   else if(qName.equalsIgnoreCase("city"))
		   {
			   city=true;
		   }
		   else if(qName.equalsIgnoreCase("district"))
		   {
			   district=true;
		   } 
	}
	
	//call beginning of the end element
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}
	
	//
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("Begining of the document"+"\n");
		System.out.println("_____________________________________________________________________________________________________________________________________________");
		
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("_____________________________________________________________________________________________________________________________________________");
		System.out.println("\n"+"End of the document");
	}
	
	// if character data encounter then it will call characters method
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
//		if(isCmpName)
//		{
//			System.out.println("First_Name : "+new String(ch, start, length));
//			isCmpName=false;
//		}
		
		if(firstname)
		{
			System.out.println("First_Name         : "+new String(ch, start, length));
			firstname=false;
		}
		if(lastname)
		{
			System.out.println("Last_Name          : "+new String(ch, start, length));
			lastname=false;
		}
		if(nickname)
		{
			System.out.println("Nick_Name          : "+new String(ch, start, length));
			nickname=false;
		}
		if(marks)
		{
			System.out.println("Marks              : "+new String(ch, start, length));
			marks=false;
		}
		if(email)
		{
			System.out.println("Email :");
			email=false;
		}
		if(work)
		{
			System.out.println("\tWork       : "+new String(ch, start, length));
			work=false;
		}
		if(perm)
		{
			System.out.println("\tPermanent  : "+new String(ch, start, length));
			perm=false;
		}
		if(address)
		{
			System.out.println("Address : ");
			address=false;
		}if(city)
		{
			System.out.println("\tCity       : "+new String(ch, start, length));
		    city=false;
		}if(district)
		{
			System.out.println("\tDistrict   : "+new String(ch, start, length));
			district=false;
		}
	
		
	}

}
