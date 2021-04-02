package com.velociter.training.ankit;

public class Weightclass 
{
	
	public static final int KG_TON = 1000;
	  public static final int GRAMS_KG = 1000;
	  public static final int GRAMS_TON = GRAMS_KG*KG_TON;
	 static int total_ton;
	static int total_kilogram;
	static int total_gram;
	 int ton=0,kilogram=0,gram=0;
	Weightclass()
	{
		
	}
	Weightclass(double kg)
	{
		 this((int)Math.round(kg*GRAMS_KG)); 
	}
	Weightclass(int g)
	{
		    ton = g/GRAMS_TON;
		    kilogram = (g - ton*GRAMS_TON)/GRAMS_KG;
		    gram = g - ton*GRAMS_TON - kilogram*GRAMS_KG;

	}
	
	  public Weightclass(int t, int kg, int g) {
		    this(t*GRAMS_TON + kg*GRAMS_KG + g);
		  }

	
	 public String toString() {
		    total_ton+=ton;
		    total_kilogram+=kilogram;
		    total_gram+=gram;
		    return Integer.toString(ton) + "ton " + kilogram + "kilogram " + gram + "gram";
		  }
	 
	
	 

	public static void main(String ar[])
	{
		Weightclass[] weight=new Weightclass[4];
		weight[0]=new Weightclass(1202500);
		weight[1]=new Weightclass(12025);
		weight[2]=new Weightclass(8,85,5);
		weight[3]=new Weightclass(15522500);
		for(int i=0;i<4;i++)
		{	
		System.out.println(weight[i].toString());
	    }
		
		//System.out.println("Total Weight is="+total_ton+"ton"+total_kilogram+"kilogram"+total_gram+"gram");
		
		
		
	}
}