package net.java.myproject.main;
import net.java.myproject.service.*;


public class AdminMain {
   // AdminOptions a= new AdminOptions();
    Interface in= new Interface();
     public void AdminGo() throws Exception
     {try{
    	 in.welcome();
     }catch(Exception e)
     {
    	 System.out.println(e);
     }
    	
     }
}
