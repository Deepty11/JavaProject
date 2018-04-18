package net.java.myproject.entities;

import java.util.Scanner;

public class Shoe  extends Product{
	private int size;
	private String brand= new String();
	private Scanner scan;
	 


	public int getSize() {
		return size;
	}
	public String getBrand() {
		return brand;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
	public Shoe() 
	{
		size=0;
		brand=" ";
	}
	
	public Shoe(int size, String brand,String quality,int batch_no,float price,int id) {
		super(id,quality,batch_no,price);
		this.size = size;
		this.brand = brand;
	}
	
	public void display()
	{
		System.out.println(super.toString());
		System.out.print("Brand:"+brand+"\nSize:"+size);
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
