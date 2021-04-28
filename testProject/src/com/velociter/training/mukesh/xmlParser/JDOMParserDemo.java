package com.velociter.training.mukesh.xmlParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JDOMParserDemo 
{
		  public static void main(String [] args)
		  {
			  try
			  {
				  File xmlfile=new File("E:\\xmlDocument\\saxInput.xml");
				  
				  SAXBuilder saxBuilder=new SAXBuilder();
				
				  Document document=saxBuilder.build(xmlfile);
				  
				  System.out.println("Root Element : "+document.getRootElement().getName());
				
				  Element root = document.getRootElement();
				  
				  // Stored child elements of student in list 
				  List<Element>  listElement=root.getChildren();				 
				 
				  for(int i=0;i<listElement.size();i++)
					{
						
						Element classElement=listElement.get(i);						
						System.out.println("\n============================================================");
						if(listElement.get(i).getName()=="student") 
						{
							System.out.println("Child Element        : "+ listElement.get(i).getName());						
							System.out.println("Student rollno       : "+ listElement.get(i).getAttributeValue("rollno"));						
							System.out.println("Student firstName    : "+ classElement.getChild("firstname").getText());
							System.out.println("Student lastName     : "+ classElement.getChild("lastname").getText());
							System.out.println("Student nickName     : "+ classElement.getChild("nickname").getText());
							System.out.println("Student marks        : "+ classElement.getChild("marks").getText());
							System.out.println("Student work mail    : "+ classElement.getChild("email").getChildText("work"));
							System.out.println("permanent mail       : "+ classElement.getChild("email").getChildText("perm"));
							
							if(classElement.getChild("address")==null)
							{
								System.out.println(" ");
							}
							else
							{
								System.out.println("Student city         : "+ classElement.getChild("address").getChildText("city"));
								System.out.println("Student district     : "+ classElement.getChild("address").getChildText("district"));
							}
						}
						else if(listElement.get(i).getName()=="company")
						{
							System.out.println("Child Element        : "+ listElement.get(i).getName());						
							System.out.println("Student rollno       : "+ listElement.get(i).getAttributeValue("id"));
							System.out.println("Company Name         : "+ classElement.getChild("cmp_name").getText());
							System.out.println("Address              : "+ classElement.getChild("Address").getText());
						}
					}
				  
						
			}
			  catch (JDOMException e) 
			  {
				e.printStackTrace();
			  } 
			  catch (IOException e) 
			  {
				e.printStackTrace();
			  }
			  
		  }
}
