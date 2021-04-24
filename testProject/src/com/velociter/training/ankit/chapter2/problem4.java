package com.velociter.training.ankit.chapter2;
public class problem4 {
public static void main(String ar[])
{
	double sun=865000/2.0;
	double earth=7600/2.0;
	double cons=4.0/3.0;
	double sunvol=0,earthvol=0,ratiovol=0;
	sunvol=(cons*sun*sun*sun)*(3.14);
	earthvol=(cons*earth*earth*earth)*(3.14);
	ratiovol= sunvol/earthvol;
	System.out.println(sunvol);
	System.out.println(earthvol);
	System.out.println(ratiovol);
	
}
}
