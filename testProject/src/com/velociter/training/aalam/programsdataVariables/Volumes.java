package com.velociter.training.aalam.programsdataVariables;

public class Volumes 
{

	public static void main(String[] args) 
	{
	  double diameterofSun = 865000.0;
	  double diaMeterOfEarth = 7600.0;
	  double rediusOfSun  = diameterofSun /2.0;      //radius is always half of te diameter
      double rediusOfEarth = diaMeterOfEarth /2.0;
      double fourOverThree = 4.0/3.0;               //it means 4/3
      double volumeOfSun = 0.0;
      double volumeOfEarth = 0.0; 
      double ratioVolume = 0.0;    
      
      volumeOfEarth = fourOverThree * Math.PI * Math.pow(rediusOfEarth,3); //rediusOfEarth * 3 times
      volumeOfSun = fourOverThree * Math.PI * Math.pow(rediusOfSun,3);     ////rediusOfSun * 3 times
      
      // Find the ratio of their volumes:
      ratioVolume = volumeOfSun/volumeOfEarth; //diffrence volume  between sun and earth volume
      
   // Output the results:
      System.out.println("Volume of the earth is " + volumeOfEarth + " cubic miles");
      System.out.println("Volume of the sun is " + volumeOfSun + " cubic miles");
      System.out.println("The sun's volume is " + ratioVolume +
  					" times greater than the earth's.");
      
	}

}
