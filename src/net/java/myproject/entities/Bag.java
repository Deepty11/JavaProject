package net.java.myproject.entities;

import java.util.Scanner;

public class Bag extends Product {
	 private String category=new String() ;
	 private Scanner scan;

	public Bag() {
		category=" ";
	}
	
	public Bag(String category,String quality,int batch_no,float price,int id) {
		super(id,quality,batch_no,price);
		this.category = category;
	}

	

	public void display()
	{
		 System.out.print(super.toString());
		System.out.println("Category:"+category);
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQuality() {
		return super.getQuality();
	}
	public int getBatch_no() {
		return super.getBatch_no();
	}
	public float getPrice() {
		return super.getPrice();
	}
	public void setQuality(String quality) {
		super.setQuality(quality);
	}
	public void setBatch_no(int batch_no) {
		super.setBatch_no(batch_no);
	}
	public void setPrice(float price) {
		super.setPrice(price);
	}
	public void setId(int id)
	{
		super.setId(id);
	}
	public int getId()
	{
		return super.getId();
	}
}
