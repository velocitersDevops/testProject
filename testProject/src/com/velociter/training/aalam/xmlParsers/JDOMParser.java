package com.velociter.training.aalam.xmlParsers;

import java.io.File;
import java.util.List;

import org.jdom2.input.SAXBuilder;

import org.jdom2.Document;
import org.jdom2.Element;




public class JDOMParser 
{

	public static void main(String[] args) 
	{
		try
		{
		/*	File fileObject = new File("e:\\programingExample\\xmlParser\\employee.txt");
		    SAXBuilder saxBuilderObject = new SAXBuilder();
			//it is represent of the xml document
			Document documentObject = saxBuilderObject.build(fileObject);
			System.out.println("Root Element    :"+documentObject.getRootElement().getName());
			Element element = documentObject.getRootElement();
			
			//stored childe element of company in list
			List<Element> companyListObject =element.getChildren();
			for(int i=0; i< companyListObject.size() ; i++)
			{
				//access .modify and create of xml element
				Element childElement  = companyListObject.get(i);
				
				//List<Attribute> attributes  = elementStudent.getAttribute();
				System.out.println("\n========================================");
				System.out.println("childe Element  "+companyListObject.get(i).getName());
				System.out.println("Campany Name   "+childElement.getChild("cmp_name").getText());
				System.out.println("Address        "+childElement.getChild("Address").getText());
				System.out.println("\n=======================================");
			}
		*/	
			
			System.out.println("");
			System.out.println("\t==================student records===============");
			System.out.println("");
			File studentFileObject = new File("e:\\programingExample\\xmlParser\\input.txt");
			SAXBuilder studentSaxBuilderObject  = new SAXBuilder();
			
			//document object of the xml document
			Document studentDocumentObject  = studentSaxBuilderObject.build(studentFileObject);
			
			//getting root element
			System.out.println("\t\tRoot element        :"+studentDocumentObject.getRootElement().getName());
			
			//creating Element object to get Child element of current root element
			Element elementObject  = studentDocumentObject.getRootElement();
			
			//stored childe element of student in list
			List<Element> studentListObject = elementObject.getChildren();
			Element childeElementOfStudent = studentListObject.get(1);
			System.out.println("\t\tchild Element is    :"+studentListObject.get(1).getName());      //here getting child name
			System.out.println("\t\t-------------------------------------");
			for(int i= 0 ;i<  studentListObject.size(); i++ )
			{
				//access .modify and create of xml element
				childeElementOfStudent = studentListObject.get(i);
				
				//now we can access student records one by one
				if((childeElementOfStudent.getAttributeValue("rollno") != null))
				{
			    	System.out.println("\t\troll number         :"+childeElementOfStudent.getAttributeValue("rollno"));
				    System.out.println("\t\tFirst Name          :"+childeElementOfStudent.getChildText("firstname"));
				    System.out.println("\t\tLast Name           :"+childeElementOfStudent.getChildText("lastname"));
				    System.out.println("\t\tNick Name           :"+childeElementOfStudent.getChildText("nickname"));
				    System.out.println("\t\tMarks               :"+childeElementOfStudent.getChildText("marks"));
				    System.out.println("\t\tworking email       :"+childeElementOfStudent.getChild("email").getChildText("work"));
				    System.out.println("\t\tpermanent email     :"+childeElementOfStudent.getChild("email").getChildText("perm"));
			        	if((childeElementOfStudent.getChild("address") != null))   //if address found then print otherwise not display
				       {
					    System.out.println("\t\tCity                :"+childeElementOfStudent.getChild("address").getChildText("city"));
					    System.out.println("\t\tDistrict            :"+childeElementOfStudent.getChild("address").getChildText("district"));		
				       }
				        System.out.println();
				}else
				{
					System.out.print("");
				}
				
			}
			
			
			
			//creating list object to store company records
		}catch(Exception e)
		{
			System.out.println("something wrong");
		}
	}
}
