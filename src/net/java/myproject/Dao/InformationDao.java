package net.java.myproject.Dao;
import net.java.myproject.entities.Information;

import java.sql.*;
import java.util.ArrayList;

public class InformationDao {
	public Connection  getConnection()
	{
		Connection con=null;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
    	 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root",null);
        return con;
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
public void createTable()  throws Exception // table creation
    {
    	Connection con=null;
    	Statement pst= null;
    	
    	try{
    	 con=	getConnection();
    		
    		pst= con.createStatement();
    		pst.executeUpdate("create table if not exists Information(ID int auto_increment not null,Name varchar(255) not null,DateOfBirth varchar(255) not null,UserName varchar(255) not null,Password varchar(255) not null,Balance float not null, Primary key (Id))" );
    		//System.out.println("Table Created!");
    	}catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	finally
		{
			try
			{
				con.close();
				pst.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
    }
public void Insertion(Information I) throws Exception   //Insertion into the table
	{
		
		  Connection con=null;
		  Statement pst=null;
    	
    try{
    	 con= getConnection();
    	 pst= con.createStatement();
    	pst.executeUpdate("insert into Information(Name,DateOfBirth,Username,Password,Balance)values('"+I.getName()+"'"+",'"+I.getDateOfBirth()+"','"+I.getUser()+"','"+I.getPass()+"',"+I.getBalance()+")");
    	System.out.println("Insertion Successfull! ");
    }catch(Exception x)
    {
    	System.out.println(x);
    }
    finally
	{
		try
		{
			con.close();
			pst.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}
public void ShowAllRecords() throws Exception//shows all records for Information
	{
	  ResultSet rs= null;
	  Connection con=null;
	  Statement pst=null;
	
    try{
    	 con = getConnection();
    	 pst= con.createStatement();
    	 rs=pst.executeQuery("Select * from Information");
    	
    	while(rs.next())
    	{
    		System.out.println("Id:"+rs.getInt(1));
    		System.out.println("Name:"+rs.getString(2));
    		System.out.println("Date Of Birth:"+rs.getString(3));
    		System.out.println("User Name:"+rs.getString(4));
    		System.out.println("Balance:"+rs.getFloat(6));
    		 System.out.println("All are selected!");
    	    
    	}
    	con.close();
		pst.close();
		rs.close();
	
    	
    	
    }catch(Exception x)
    {
    	System.out.println(x);
    }
  
	
	}
public int UserPasswordMatch(String u,String p) //shows all records for Information
{
  ResultSet rs= null;
  Connection con=null;
  Statement pst=null;
  boolean chkU,chkP;

try{
	 con = getConnection();
	 pst= con.createStatement();
	 rs=pst.executeQuery("Select * from Information");
	 
	
	while(rs.next()){
		chkU=u.equals(rs.getString("Username"));
		chkP=p.equals(rs.getString("Password"));
		if(chkU){
			if(chkP){
				System.out.println("Logged in!!!");
				return rs.getInt("ID");
				
			}
		}
		
   }
	
	con.close();
	pst.close();
	rs.close();
	return 0;
	
}catch(Exception x)
{
	System.out.println(x);
}
return 0;


}


public void selection( int p) throws Exception     //show an individual information 
	{
		  ResultSet rs= null;
		  Connection con=null;
		  Statement pst=null;
		  int count=0;
		
		try
		{
			con= getConnection();
		    pst=con.createStatement();
			rs = pst.executeQuery("select * from Information ");
			while(rs.next())
			{
			 count++;
			 if(count==p){
				    System.out.println("Id:"+rs.getInt(1));
		    		System.out.println("Name:"+rs.getString(2));
		    		System.out.println("Date Of Birth:"+rs.getString(3));
		    		System.out.println("User Name:"+rs.getString(4));
		    		System.out.println("Balance:"+rs.getFloat(6));
			 }
			}
			con.close();
			pst.close();
			rs.close();
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
public float selectBalance( int p)    //show an individual balance 
	{
		  ResultSet rs= null;
		  Connection con=null;
		  Statement pst=null;
		  float bal=0;
		  int count=0;
		try
		{
			 con= getConnection();
		   	pst=con.createStatement();
			 rs = pst.executeQuery("select * from Information ");
			while(rs.next())
			{
				count++;
				if(count==p){
					bal=rs.getFloat(6);
				}
				
			}
			con.close();
			pst.close();
			rs.close();
			return bal;
		
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return bal;
		
	}
	@SuppressWarnings("finally")
public int CountRecords() throws Exception
	{
		ResultSet rs= null;
		Connection con=null;
		Statement pst=null;
		int count=0;
		try
		{
		 con= getConnection();
		 pst= con.createStatement();
		 rs= pst.executeQuery("select *  from Information ");
	    while(rs.next())
	    {
	    	count++;
	    }
	    con.close();
		pst.close();
		rs.close();
		
			return count;
	    }catch(Exception e){
				System.out.println(e);
		}
		
			return count;
		
	}
public void UpdateBalance(float n , int p) throws Exception
	{
		
		  Connection con=null;
		  Statement pst=null;
		  ResultSet rs= null;
		  int count=0;
		  int temp=0;
		
		try
		{
			con=getConnection();
		    pst=con.createStatement();
		    rs=pst.executeQuery("select * from Information");
		    while(rs.next()){
		    	count++;
		    	if(count==p){
		    		temp=rs.getInt("Id");
		    	}
		    }
		    
			pst.executeUpdate("Update information set balance="+n+"where id="+temp);
			System.out.println("Updated!");
			con.close();
			pst.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
