package net.java.myproject.Dao;

import java.sql.*;

import java.util.ArrayList;

import net.java.myproject.entities.Bag;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class BagDao {
	public Connection getConnection()
	{
		Connection con= null;
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
    public void CreateTable() throws Exception // table Creation
    {
    	Connection con=null;
    	Statement pst= null;
    	try{
    		 con= getConnection();
        	 pst= con.createStatement();
        	pst.executeUpdate("create table if not exists BagList(id int unsigned auto_increment not null,batch_no int not null,quality varchar(255) not null,price float not null,category varchar(255) not null, primary key(id));");
    	}
    	catch(Exception e)
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
    @SuppressWarnings("finally")
	public int CountRecords() throws Exception //Count the rows
	{
		int count=0;
		ResultSet rs= null;
		  Connection con=null;
		  Statement pst=null;
		
		try
		{
			 con= getConnection();
		     pst= con.createStatement();
			 rs= pst.executeQuery("select *  from BagList ");
		 while(rs.next())
		 {
			 count++;
		 }
			return count;
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
				rs.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return count;
		}
	}
    
    public void Insertion(Bag I) throws Exception   //Insertion into the table
	{
    	
		  Connection con=null;
		  Statement pst=null;
		
    try{
    	 con= getConnection();
    	
       pst= con.createStatement();
    
    	pst.executeUpdate("insert into BagList(batch_no,quality,price,category)values("+I.getBatch_no()+",'"+I.getQuality()+"'"+","+I.getPrice()+",'"+I.getCategory()+"')");
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
	@SuppressWarnings("finally")
	public void showAllRecords() throws Exception//shows all records for Information
	{
		
	
		ResultSet rs= null;
		  Connection con=null;
		  Statement pst=null;
		
    try{
    	  con = getConnection();
    	 pst= con.createStatement();
    	 rs=pst.executeQuery("Select * from BagList");
    	 JFrame frame= new JFrame("BagList");
    	
    	 
    			 
    	 String[][]data= new String[40][22];
    	int k=0;
    	while(rs.next())
    	{
    		//Bag bag= new Bag(rs.getString(5),rs.getString(3),rs.getInt(2),rs.getFloat(4),rs.getInt(1));
    		
    		/*System.out.println("ID:"+rs.getInt(1));
    		System.out.println("Batch no:"+rs.getInt(2));
    		System.out.println("Quality:"+rs.getString(3));
    		System.out.println("Price:"+rs.getFloat(4));
    		System.out.println("Category:"+rs.getString(5));
    		
    		
    		System.out.println("\n");*/
    		data[k][0]=String.valueOf(rs.getInt(1));
    		data[k][1]=String.valueOf(rs.getInt(2));
    		data[k][2]=rs.getString(3);
    		data[k][3]=String.valueOf(rs.getFloat(4));
    		data[k][4]=rs.getString(5);
    		
    		//array.add(bag);
    		k++;
    		
    	}
    	String column[]={"ID","Batch No","Quality","Price","Category"};
    	JTable table= new JTable(data,column);
    	table.setBounds(30,40,400,300);
    	 JScrollPane sp = new JScrollPane(table);
         frame.add(sp);
         frame.setVisible(true);
    	 frame.setSize(900,800);
    	
    	System.out.println("All selected!");
    	//return array;
    	
    	
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
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	}
	
	public void selection( int p) throws Exception    //show an individual information 
	{
		ResultSet rs= null;
		  Connection con=null;
		  Statement pst=null;
		
		try
		{
		  con= getConnection();
			 pst=con.createStatement();
			rs = pst.executeQuery("select * from BagList where ID="+p);
			while(rs.next())
			{
			System.out.println("ID:"+rs.getInt(1));
    		System.out.println("Batch no:"+rs.getInt(2));
    		System.out.println("Quality:"+rs.getString(3));
    		System.out.println("Price:"+rs.getFloat(4));
    		System.out.println("Category:"+rs.getString(5));
    		System.out.println("\n");
			}
			
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
				rs.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public float selectPrice( int p) throws Exception    //returns individual's price 
	{
		Connection con=null;
    	Statement pst= null;
    	ResultSet rs=null;
    	float price=0;
    	int count=0;
		try
		{
			 con= getConnection();
			 pst=con.createStatement();
		     rs = pst.executeQuery("select * from baglist ");
			while(rs.next())
			{
				count++;
				if(count==p){
				price= rs.getFloat(4) ;
				}
			}
			con.close();
			pst.close();
			rs.close();
			return price;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
			return price;
		
	}
	
}
