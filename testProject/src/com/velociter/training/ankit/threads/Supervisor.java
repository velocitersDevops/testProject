package com.velociter.training.ankit.threads;

public class Supervisor {

	public static void main(String ar[])
	{
		new SupervisorClerk();
		new Clerk2();
	 //m1.start();
	}
}
class SupervisorClerk
{
	SupervisorClerk()
	{
		System.out.println("Supervision");
	new Clerk1();
	new Clerk2();
	}
}
