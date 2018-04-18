package net.java.myproject.service;
import java.util.*;
import net.java.myproject.service.*;


public class Interface {
	 Scanner scan=new Scanner(System.in);
	AdminOptions ad= new AdminOptions();
	UserOptions us=new UserOptions();
	int n;
	public void welcome() throws Exception
	{
		 System.out.println("|======================================================================================================|");
	     System.out.println("|                                    WELCOME TO E-SHOP                                                 |");
	     System.out.println("|======================================================================================================|");
	     System.out.println("\tChoose:");
	     System.out.println("\t1.Admin"+"\n"+"\t2.User");
	     n=scan.nextInt();
	     Choice(n);
	     
	}
    
	public void Choice(int n) throws Exception
	{
	     
	     
	     
	      if(n==1)
	      {
	    	  ad.VerificationID();
	    	 
	      }
	      else{
	    	  us.Access();
	      }
	      
	     
	}
}
