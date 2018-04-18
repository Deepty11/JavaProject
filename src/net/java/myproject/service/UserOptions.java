package net.java.myproject.service;


import java.util.Scanner;
import java.lang.*;
import net.java.myproject.Dao.BagDao;
import net.java.myproject.Dao.InformationDao;
import net.java.myproject.Dao.ShoeDao;

import net.java.myproject.entities.Information;


public class UserOptions {
	 
	 private Scanner scan=new Scanner(System.in);
	 private Information info=new Information();
	 private BagDao bagDao= new BagDao();
	 private InformationDao infoDao= new InformationDao();
	 private ShoeDao shoeDao= new ShoeDao();
	 private String name = new String();
	 private float balance;
	 private String dateOfBirth= new String();
	 private String user= new String();
	 private String pass= new String();
	  int m=0,n,k=0,g;
	  
	 public void Access()throws Exception
	 {
		 System.out.println("\tYOu must log in first!");
         System.out.println("\tNew in this site?(y/n)");
         char ch;
         ch=scan.next(".").charAt(0);
         LogIn(ch);
	 }
	 public void LogIn(char ch) throws Exception
	 {
		 infoDao.createTable();
		 if(ch=='y')
		 {
			  System.out.println("\tYou need to register First!"+"\n"+"\tRegister?(y/n)");
	            char p;
	           p=scan.next(".").charAt(0);
	            if(p=='y')
	               {
	                  System.out.println("\n");
	                  System.out.println("***********************************************************************");
	                   System.out.println("\tUSER INFORMATION:");
	                    System.out.print("\tEnter name :");
	                    name=scan.nextLine();
	                    name=scan.nextLine();
	                    info.setName(name);
	                    System.out.print("\tEnter Date of Birth :");
	                    dateOfBirth=scan.nextLine();
	                    info.setDateOfBirth(dateOfBirth);
	                   // dateOfBirth=scan.nextLine();
	                    System.out.print("\tUser Name:");
	                   user=scan.next();
	                   info.setUser(user);
	                   System.out.print("\tPassword:");
	                   pass=scan.next();
	                   info.setPass(pass);
	                   System.out.print("\tBalance:");
	           		    balance=scan.nextFloat();
	           		    info.setBalance(balance);
	                   
	                    infoDao.Insertion(info);
	                    
	                  System.out.println("***********************************************************************");
	                    
	                   Access();
	               }
	               else if(p=='n')
	               {
	                  Access();
	               }
		 }
		 else if(ch=='n' )
		 {
			
	         Match();      
	                
		 }
	 }
	 public void Match() throws Exception {
		 String u=new String();
         String p= new String();
         System.out.println("\tUSER LOGIN:");
         System.out.print("\tuser name:");
         u=scan.next();
         System.out.print("\tPassword:");
         p=scan.next();
         n=infoDao.CountRecords();
         m=infoDao.UserPasswordMatch(u,p);
         
         if(m>0){
        	 UserOption(m);
         }
         else{
        	 Access();
         }
  
	 }
	 public void UserOption(int m) throws Exception
	 {
		   System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		    int q;
	        System.out.println("\n");
	        System.out.println("\tOPTIONS::");
	        System.out.println("\t1.check the available products"+"\n"+"\t2.check my account"+"\n");
	        q=scan.nextInt();
	        if(q==1){
	        	Option1();
	        }
	        else if(q==2)
	        {
	        	Option2(m);
	        }
	       
	 }
	 public void Option1() throws Exception
	 {
		 System.out.println("\tWhich product?(1/2)\n\t\t1.Shoes\n\t\t2.Bags");
         int k;
         k=scan.nextInt();
         if(k==1){
           int n;
           n=shoeDao.CountRecords();
           if(n==0){
               System.out.println("there is nothing to show!!");
               UserOption(m);
           }
           else{
           System.out.println("\n");
           System.out.println("************************************************************************************");
           System.out.println("\tThere are "+n+" shoes available in this site !");
           shoeDao.showAllRecords();
           System.out.println("\n");

           
           System.out.println("***********************************************************************************");
           }

           System.out.println("\tAdd to cart?(y/n)");
           char p;
           p=scan.next(".").charAt(0);
           if(p=='y')
           {
               System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
               System.out.println("\tEnter number:"+"(from 1 to "+n+")");
               int a;
               a=scan.nextInt();
               System.out.println("\tDetails of the product:");
               shoeDao.selection(a);
               
               System.out.println("\tYour previous balance:"+infoDao.selectBalance(m));
              
               float set1=deduction(infoDao.selectBalance(m),shoeDao.selectPrice(a));
               System.out.println("\tAfter deducing , your current balance:"+set1+"TK");
               infoDao.UpdateBalance(set1, m);
           
           }
           else{
                UserOption(m);
           }
         }
         else if(k==2){
        	 int n1;
             n1=bagDao.CountRecords();
             if(n==0)
             {
                 System.out.println("there is nothing to show!!");
                 UserOption(m);
             }
             else{
             System.out.println("\n");
             System.out.println("************************************************************************************");
             System.out.println("\tThere are "+n1+" bags available in this site !");
             bagDao.showAllRecords();
             System.out.println("\n");
             System.out.println("***********************************************************************************");
             }

             System.out.println("\tAdd to cart?(y/n)");
             char p;
             p=scan.next(".").charAt(0);
             if(p=='y')
             {
                 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                 System.out.println("\tEnter number:"+"(from 1 to "+n1+")");
                 int a1;
                 a1=scan.nextInt();
                 System.out.println("\tDetails of the product:");
                 bagDao.selection(a1);
                 System.out.println("\tYour previous balance:"+infoDao.selectBalance(m));
                 float set2=deduction(infoDao.selectBalance(m),bagDao.selectPrice(a1));
                 System.out.println("\tAfter deducing , your current balance:"+set2+"TK");
                 infoDao.UpdateBalance(set2, m);
           
           }
           else{
                 UserOption(m);
           }
         }
         System.out.println("\tTry more?(y/n)");
         char l;
         l=scan.next(".").charAt(0);
         if(l=='y')
         {
             UserOption(m);
         }
         else{
            System.out.println("***********************************************************");
            System.out.println("\tThanks for visiting us!"+"\n"+"\tCome back soon!");
            System.out.println("***********************************************************");
         }
}
	 public void Option2(int g) throws Exception
	 {
		 
		 infoDao.selection(g);
        
         UserOption(m);
	 }
         
	 
public float deduction(float a,float b)
{
	return a-b;
}
	 
}

