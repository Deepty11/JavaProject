package net.java.myproject.entities;

import java.util.Scanner;

public class Balance {
	private float balance;

	public Balance() {
	   this.balance=(float)0.00;
	}

	public Balance(float balance) {
		
		this.balance = balance;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	public void getData()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("\n\tBalance:");
		balance=scan.nextFloat();
	}
	

	@Override
	public String toString() {
		return "Balance :" + balance ;
	}

}
