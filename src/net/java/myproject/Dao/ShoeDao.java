package net.java.myproject.Dao;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.java.myproject.entities.Shoe;

public class ShoeDao {
	public Connection getConnection()
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
   public void CreateTable() // table Creation
    {
    	Connection con=null;
    	Statement pst= null;
    	
    	try{
    		con= getConnection();
         pst= con.createStatement();
        	pst.executeUpdate("create table if not exists ShoeList(id int unsigned auto_increment not null,batch_no int not null, quality varchar(255) not null, price float not null,sizes int not null,brand varchar(255) not null, primary key(id));");
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
    
    public void Insertion(Shoe I)   //Insertion into the table
	{
    	Connection con=null;
    	Statement pst= null;
    	
    
    try{
    	 con= getConnection();
        pst= con.createStatement();
    	pst.executeUpdate("insert into ShoeList(batch_no,quality,price,sizes,brand)values("+I.getBatch_no()+",'"+I.getQuality()+"'"+","+I.getPrice()+","+I.getSize()+",'"+I.getBrand()+"')");
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

	public void showAllRecords() throws Exception         //shows all records for Information
	{
		Connection con=null;
    	Statement pst= null;
    	ResultSet rs=null;
    	
    	ArrayList<String> array=new ArrayList<String>();
    try{
    	 con = getConnection();
    	 pst= con.createStatement();
    	 rs=pst.executeQuery("Select * from shoelist");
    	 JFrame frame= new JFrame("Shoe List");
    	 String[][]data= new String[40][22];
    	int k=0;
    	while(rs.next())
    	{
    		/*System.out.println("ID:"+rs.getInt(1));
    		System.out.println("Batch no:"+rs.getInt(2));
    		System.out.println("Quality:"+rs.getString(3));
    		System.out.println("Price:"+rs.getFloat(4));
    		System.out.println("Sizes:"+rs.getInt(5));
    		System.out.println("Brand:"+rs.getString(6));
    		System.out.println("\n");
    		array.add(rs.getString(6));*/
    		data[k][0]=String.valueOf(rs.getInt(1));
    		data[k][1]=String.valueOf(rs.getInt(2));
    		data[k][2]=rs.getString(3);
    		data[k][3]=String.valueOf(rs.getFloat(4));
    		data[k][4]=String.valueOf(rs.getInt(5));
    		data[k][5]=rs.getString(6);
    		k++;
    		
    	}
    	String column[]={"ID","Batch No","Quality","Price","Sizes","Brand"};
    	JTable table= new JTable(data,column);
    	table.setBounds(30,40,400,300);
    	 JScrollPane sp = new JScrollPane(table);
         frame.add(sp);
         frame.setVisible(true);
    	 frame.setSize(900,800);
    	
    	System.out.println("All selected!");
    	con.close();
		pst.close();
		rs.close();
    	
    	
    	
    }catch(Exception x)
    {
    	System.out.println(x);
    }
  

	}
	public void selection( int p)     //show an individual information 
	{
		Connection con=null;
    	Statement pst= null;
    	ResultSet rs=null;
    	//ArrayList<String> array=new ArrayList<String>();
    	int count=0;
		try
		{
			 con= getConnection();
			 pst=con.createStatement();
		    rs = pst.executeQuery("select * from ShoeList ");
		    while(rs.next())
		    {
		    	count++;
		    	if(count==p){
			System.out.println("ID:"+rs.getInt(1));
    		System.out.println("Batch no:"+rs.getInt(2));
    		System.out.println("Quality:"+rs.getString(3));
    		System.out.println("Price:"+rs.getFloat(4));
    		System.out.println("Sizes:"+rs.getInt(5));
    		System.out.println("Brand:"+rs.getString(6));
    		
    		System.out.println("\n");
		    	}
		    }
		    con.close();
			pst.close();
			rs.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	@SuppressWarnings("finally")
	public int CountRecords() throws Exception//Count the rows
	{
		int count=0;
		Connection con=null;
    	Statement pst= null;
    	ResultSet rs=null;
		
		try
		{
		   con= getConnection();
		    pst= con.createStatement();
		     rs= pst.executeQuery("select *  from ShoeList ");
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
	
	public float selectPrice( int p) throws Exception     //show an individual information 
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
		     rs = pst.executeQuery("select *  from ShoeList ");
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
		
			return -1;
	
	}
}

