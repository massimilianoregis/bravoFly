package it.bravo.max.index.concrete;

import it.bravo.max.index.Good;
import it.bravo.max.index.Money;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GoodMemory implements Good{
	@Id
	private String code;
	private String made;
	private String name;
	private Money price;
	private List<String> tags;
	
	public GoodMemory(
				String code, 
				String name,
				String made,
				Double price,
				String tag)
		{
		this.tags	= new ArrayList<String>();
		this.code	=code;
		this.made	=made;
		this.name	=name;
		this.price  = new Eur(price);
		this.tags.add(tag);
		}
	@Override
	public String getMadeIn() {	
		return made;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public Money getPrice() {
		return price;
	}
	@Override
	public List<String> getTags() {
		return tags;
	}
	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {		
		return name+" "+tags.toString();
	}
}
