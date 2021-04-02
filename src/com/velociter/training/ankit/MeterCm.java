package com.velociter.training.ankit;

public class MeterCm
  {
	
	  public static  int CM_M = 100;
	  public static final int MM_CM = 10;
	  public static  int MM_M = 1000;
	 
	int meter=0,centimeter=0,millimeter=0;
	MeterCm()
	{
		
	}
	MeterCm(double cm)
	{
		 this((int)Math.round(cm*MM_CM)); 
	}
	MeterCm(int mm)
	{
		meter = mm/MM_M;
	    centimeter = (mm - meter*MM_M)/MM_CM;
	    millimeter = mm - meter*MM_M - centimeter*MM_CM;
	}
	
	 public MeterCm(int m, int cm, int mm) {
		    this(m*MM_M + cm*MM_CM + mm);
		  }
	
	 public String toString() {
		    return Integer.toString(meter) + "m " + centimeter + "cm " + millimeter + "mm";
		  }

	public static void main(String ar[])
	{
		MeterCm value = new MeterCm(1400.85);
		MeterCm value1=new MeterCm(8.5);
		System.out.println(value.toString());
		System.out.println(value1.toString());
	}
}
