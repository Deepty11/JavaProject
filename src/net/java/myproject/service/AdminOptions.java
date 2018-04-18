package net.java.myproject.service;
import net.java.myproject.entities.*;
import java.awt.*;
import java.awt.event.*;

import net.java.myproject.Dao.*;
import java.util.*;
import javax.swing.*;

public class AdminOptions  {
	 private String us=new String();
	 private String pas= new String();
	 private Scanner scan=new Scanner(System.in);
	 private Admin admin= new Admin();
	 private Bag bag=new Bag();
	 private Shoe shoe= new Shoe();
	 private String quality= new String();
	 private int batch_no;
	 private float price;
	 private String category= new String();
	 private BagDao bagDao= new BagDao();
	 private InformationDao infoDao= new InformationDao();
	 private ShoeDao shoeDao= new ShoeDao();
	 private String brand= new String();
	 private int size;
	 
	 
	  
     public void VerificationID() throws Exception
     {
    	System.out.println("\tVerification:");
    	 System.out.print("\tEnter User:");
    	 us=scan.next();
    	 System.out.print("\tEnter Password:");
    	 pas=scan.next();
    	 
    	 if((admin.getName()).equals(us) && (admin.getPass()).equals(pas))
		 {
			try{
				 
				 
    			 System.out.println("Congratulation ! Your Account Has Been Verified .");
    			 menuOption();
			}catch(Exception e1){
				e1.printStackTrace();
			}
			 
		 }
	
		
		 else{
			 System.out.println("Incorrect.Try it again! ");
			 try {
				VerificationID();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
	}
	 
		 }
     public void menuOption() throws Exception
     {
    	 bagDao.CreateTable();
    	 shoeDao.CreateTable();
    	 System.out.print("\tOPTIONS:"+"\n"+"\t1.Add Products"+"\n"+"\t2.Show available products."+"\n"+"\t3. Check users informations."
         +"\n"+"\t4.Exit\n");
    	 int ch;
    	 ch=scan.nextInt();
    	 
    	 if(ch==1)
    	 {
    		 Option1();
    		 
    	 }
    	 else if(ch==2)
    	 {
    		 Option2();
    	 }
    	 else if(ch==3)
    	 {
    		 Option3();
    	 }
    	 else{
             System.out.println("***********************************************************");
             System.out.println("\tThanks for visiting us!"+"\n"+"\tCome back soon!");
             System.out.println("***********************************************************");
             System.exit(0);
          }
    	
    		 
    	 
     }
     public void Option1()  throws Exception  // adds products.
     {
    	 char cs;
    	 do{

             System.out.println("bags or shoes?(b/s)");
             
             char c;
             c=scan.next(".").charAt(0);
             if(c=='b')
             {
                System.out.println("\tEnter Data for  Bags:");              
                System.out.print("\tEnter quality:");
       		 quality=scan.next();
       		  
       		 System.out.print("\tbatch no:");
       		 batch_no=scan.nextInt();
       		 System.out.print("\tPrice:");
       		 price=scan.nextFloat();
       		System.out.print("\tCategory:");
    		category=scan.next();
    		
       		bag.setBatch_no(batch_no);
       		bag.setCategory(category);
       		bag.setPrice(price);
       		bag.setQuality(quality);
       		
       		bagDao.Insertion(bag);
       		 


             }
             else if(c=='s')
             {
                System.out.println("\tEnter Data for  Shoes:");
                
        		
        		 System.out.print("\tEnter quality:");
           		 quality=scan.next();
           		
           		 
           		 System.out.print("\tbatch no:");
           		 batch_no=scan.nextInt();
           		 System.out.print("\tPrice:");
           		 price=scan.nextFloat();
        		System.out.print("\tEnter Brand:");
        		brand=scan.next();
        		System.out.print("\tEnter size:");
        		size=scan.nextInt();

           		shoe.setBatch_no(batch_no);
           		shoe.setBrand(brand);
           		shoe.setSize(size);
           		shoe.setPrice(price);
           		shoe.setQuality(quality);
                shoeDao.Insertion(shoe);
             }
             System.out.println("Add another?(y/n)");
             
             cs=scan.next(".").charAt(0);
              } while(cs=='y');
    	 menuOption();
     }
     public void Option2() throws Exception  // shows available products.
     {
    	 System.out.println("\tShoe or Bag?(b/s)");
         char c;
         c=scan.next(".").charAt(0);
         if(c=='b')
         {
              int n1=bagDao.CountRecords();
              if(n1==0){
                  System.out.println("Empty!!");
                  menuOption();

              }
              else{
                      
              System.out.println("/n***********************************************************************");
              System.out.println("There are "+n1+" bags available");
              
                  //System.out.println("Bags:"+i+1);;
                  bagDao.showAllRecords();
                  
                  System.out.println("\n");
              
               System.out.println("***********************************************************************");
               menuOption();
              }

         }
         else if(c=='s'){

               int n2=shoeDao.CountRecords();
               if(n2==0)
               {
                   System.out.println("Empty!!!");
                   menuOption();

               }
               else{
               System.out.println("\n");
               System.out.println("***********************************************************************");
               System.out.println("There are "+n2+" shoes available");
                shoeDao.showAllRecords();
                  System.out.println("\n");
                System.out.println("***********************************************************************");
                menuOption();
               }

         }
     }
     public void Option3()throws Exception// shows All users Informations.
     {
    	
		int n3=infoDao.CountRecords();
         if(n3==0)
         {
             System.out.println("\nNo User Registered!");
             menuOption();
         }
         else{
        	 System.out.println("\n");
           System.out.println("***********************************************************************");
           System.out.println("\tThere are "+n3+" user account");
       
            // System.out.println("\tUsers::"+i+1);
             infoDao.ShowAllRecords();
             
             System.out.println("\n");
         
             System.out.println("***********************************************************************");
             menuOption();
         }


    	 
     }
     
}
