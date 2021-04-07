// create 12 random decimal values between 0.0 and 100.0 and assign with months name.
//also calculate average of decimal values.


package com.velociters.chapter4;
import java.text.DecimalFormat;
public class ArrayProblem
{
		enum MONTHS
		{
			January,February,March,April,May,June,July,August,September,October,November,December;
		}
	 
			    static DecimalFormat decimal = new DecimalFormat("0.0");    // create decimalFormat object to write values in  decimal  format
				
			    public static void randomValueWithMonths()
				{
						MONTHS monthsName[]=MONTHS.values();		// get all months as a constant and store monthsName array of MONTHS type
						
						
						// start to convert string array from MONTHS array
						
						String getMonths="";
						
						for(MONTHS enumMonths:monthsName)
						{
							getMonths=getMonths+enumMonths+" ";
						}
						String months[] = getMonths.split(" ");
						
						// converted into string array of months type
					
						
						double randomValue[]= new double[months.length];
						double sumOfRandomValue=0.0;
						
						for(int i=0;i<randomValue.length;i++)
						{
							randomValue[i]=(Math.random()*100.0);			//here generate random value between 0.0 and 100.0
							sumOfRandomValue +=(randomValue[i]);
						}
					
						for(int i =0;i<randomValue.length;i++)
							
						{
								int space= months[8].length()-months[i].length();
								StringBuilder stringBuilder = new StringBuilder();
								
								for(int k=0;k<space;k++)
								{
									stringBuilder.append(" ");
								}
								System.out.println(months[i]+"  "+stringBuilder+ decimal.format(randomValue[i])); //print months name assign with random decimal value 
						}
				
						System.out.println("average of decimal =  "+decimal.format(sumOfRandomValue/randomValue.length));		//print average  of random decimal value
				
				}		// end randomValueWithMonths method body 
				
			   
			    public static void main(String[] args)
				{
				 randomValueWithMonths();
				}

}
