package com.velociter.training.mukesh.chapter2;

public class Volumes 
{
  public static void main(String args[]) 
  {
    double sunRadius = 865000.0/2.0; 
    double earthRadius = 7600.0/2.0;  
    double fourOverThree = 4.0/3.0; // A convenient constant, 4/3
    
    double sunVolume = 0;
    double earthVolume = 0; 
    double ratioVolume = 0;             
  

    // Find the volumes of earth and sun
   
    earthVolume = fourOverThree * Math.PI * Math.pow(earthRadius,3);
    
    sunVolume = fourOverThree * Math.PI * Math.pow(sunRadius,3);
    
    // Find the ratio of their volumes:
    
    ratioVolume = sunVolume/earthVolume;

    // Output the results:
    
    System.out.println("Volume of the earth is " + earthVolume + " cubic miles");
    System.out.println("Volume of the sun is " + sunVolume + " cubic miles");
    System.out.println("The sun's volume is " + ratioVolume +" times greater than the earth's.");
  }
}

