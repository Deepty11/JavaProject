package net.java.myproject.entities;

import java.util.Scanner;

public class Information extends Balance {
	public static int max=80;
	private int id;
	private String dateOfBirth=new String();
     private String name=new String();
     private String pass=new String();
     private String user=new String();
     private Scanner scan;

	public Information() {
		super();
		id=0;
   	     dateOfBirth=" " ;
         name=" ";
         pass=" ";
         user=" ";

	}
  
	  public Information( int id,String name, String dateOfBirth, String user, String pass,float balance) {
		super(balance);
		this.id=id;
		this.dateOfBirth = dateOfBirth;
		this.name = name;
		this.pass = pass;
		this.user = user;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void display()
	  {
		  System.out.println("Name:"+name);
		  System.out.println("Date of Birth:"+dateOfBirth);
		  System.out.println("User Name:"+user);
		  System.out.println("Password:");
		  for(int i=0;i<pass.length();i++)
		  {
			  System.out.print("*");
		  }
		 
		  
	  }
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String getName() {
		return name;
	}
	public String getPass() {

		return pass;
	}
	public String getUser() {
		return user;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public float getBalance(){
		 return super.getBalance();
	}
	  
	 
}
