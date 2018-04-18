package net.java.myproject.entities;

import java.util.*;

public class Product {
	public static int  max=80;
	protected String quality=new String();
    protected int batch_no;
    protected  float price;
    private int id;
    Scanner scan;

	public Product() {
	     quality=" ";
	     batch_no= 0;
	     price=(float)0.00;
	     id=0;
	     
	}
	
	public Product( int id,String quality, int batch_no, float price) {
		
		this.quality = quality;
		this.batch_no = batch_no;
		this.price = price;
		this.id=id;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuality() {
		return quality;
	}
	public int getBatch_no() {
		return batch_no;
	}
	public float getPrice() {
		return price;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public void setBatch_no(int batch_no) {
		this.batch_no = batch_no;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Quality=" + quality + "\nBatch no=" + batch_no + "\nPrice=" + price ;
	}
	
}
