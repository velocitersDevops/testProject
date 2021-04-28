package com.velociter.training.aalam.xmlParsers;

import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler
{
//	boolean id =false;
//	boolean isCompanyName = false;
//	boolean companyAddress = false;
    boolean firstname =false;
    boolean lastname =false;
    boolean nickname =false;
    boolean marks =false;
    boolean email =false; 
    boolean work =false;
    boolean perm =false;
    boolean address =false;
    boolean city = false;
    boolean district =false;
    
    //call begining of the element
    @Override
    public void startElement(String uri,String localName,String qName,Attributes attributes) throws SAXException
    {
    	
	   super.startElement(uri, localName, qName, attributes);
	   if(attributes.getLength()  > 0)
	   {
		 //  System.out.println(" \t\t\t"+qName);
		   for(int i=0;i<attributes.getLength();i++)
		   {
			   System.out.println();
			   System.out.print(" \t\t\t"+attributes.getQName(i)+"           : "+attributes.getValue(i));
			   System.out.println();
		   }
	   }
	   
	
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
     //call begining of the end element
     public void endElement(String uri , String localName , String qName) throws SAXException
     {
	    super.endElement(uri, localName , qName);
     }

     //
 	@Override
 	public void startDocument() throws SAXException 
 	{
 		// TODO Auto-generated method stub
 		super.startDocument();
 		//System.out.println("\t\t      Begining of the document");
 		System.out.println("\t----------------Begining of the document--------------\n");
 	}
 	
 
 	
 	// if character data encounter then it will call characters method
 	
 	@Override
 	public void characters(char[] ch, int start, int length) throws SAXException
 	{
 		// TODO Auto-generated method stub
 		super.characters(ch, start, length);
 
 		if(firstname)
 		{
 			System.out.println("\t\t\tfirstname        : "+new String(ch, start, length));
 			firstname=false;
 		}
 		if(lastname)
 		{
 			System.out.println("\t\t\tlastname         :"+new String(ch,start , length));
 			lastname = false;	
 		}
 		if(nickname)
 		{
 			System.out.println("\t\t\tnickname         :"+new String(ch,start , length));
 			nickname = false;
 		}
 		if(marks)
 		{
 			System.out.println("\t\t\tmarks            :"+new String(ch,start , length));
 			marks = false;	
 		}
 		
 		if(work)
		{
			System.out.println("\t\t\tworking Email    :"+new String(ch,start , length));
			work =false;
		}
			
		if(perm)
		{
		    System.out.println("\t\t\tpermanent Email  :"+new String(ch,start , length));
			perm = false;
		}
 	     
 		if(city)
 		{
 			System.out.println("\t\t\tCity             :"+new String(ch,start , length));
 			city = false;	
 			
 		}
 		if(district)
 		{
 			System.out.println("\t\t\tDistrict         :"+new String(ch,start , length));
 			district = false;	
 			
 		}
 		
 	}
 	
	@Override
 	public void endDocument() throws SAXException
 	{
 		// TODO Auto-generated method stub
 		super.endDocument();
 		System.out.println("\t----------------End of the document------------------\n");
 	}

    }

