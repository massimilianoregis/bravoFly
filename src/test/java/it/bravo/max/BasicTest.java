package it.bravo.max;

import it.bravo.max.index.Basket;
import it.bravo.max.index.Index;
import it.bravo.max.index.concrete.IndexMemory;
import it.bravo.max.index.concrete.bravo.BasketBravo;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class BasicTest {
	private Basket basket;	
	private Index index;
	
	@Before
	public void getBasket()
		{
		basket = new BasketBravo("CH");
		}
	@Before
	public void getIndex()
		{
		index = new IndexMemory();
		index.addBook("BK1","book",12.49D,"CH");
		index.addCD("CD1","music CD",14.99D,"CH");
		index.addFood("CH1","chocolate bar",0.85D,"CH");
		
		index.addFood("CH2","chocolate bar",10D,"IT");
		index.addCosmetic("CO1","perfum",47.50D,"IT");
		
		index.addCosmetic("CO2","perfum",27.99D,"IT");
		index.addCosmetic("CO3","perfum",18.99D,"CH");
		index.addMedical("MD1","pills",9.75D,"CH");
		index.addFood("CH3","chocolate",11.25D,"IT");		
		}
	@Test
	public void test1()
		{		
		basket.add(index.getGood("BK1"));
		basket.add(index.getGood("CD1"));
		basket.add(index.getGood("CH1"));
		
		Assert.assertEquals(12.49D,basket.getRows().get(0).getTotalWithTax().getValue());
		Assert.assertEquals(16.49D,basket.getRows().get(1).getTotalWithTax().getValue());
		Assert.assertEquals(0.85D, basket.getRows().get(2).getTotalWithTax().getValue());
		
		Assert.assertEquals(1.50D,basket.getTax().getValue());
		Assert.assertEquals(29.83D,basket.getTotalWithTax().getValue());
		}
	
	@Test
	public void test2()
		{		
		basket.add(index.getGood("CH2"));
		basket.add(index.getGood("CO1"));
		
		Assert.assertEquals(10.50D,basket.getRows().get(0).getTotalWithTax().getValue());
		Assert.assertEquals(54.65D,basket.getRows().get(1).getTotalWithTax().getValue());
		
		Assert.assertEquals(7.65D,basket.getTax().getValue());
		Assert.assertEquals(65.15D,basket.getTotalWithTax().getValue());		
		}
	
	@Test
	public void test3()
		{		
		basket.add(index.getGood("CO2"));
		basket.add(index.getGood("CO3"));
		basket.add(index.getGood("MD1"));
		basket.add(index.getGood("CH3"));
		
		Assert.assertEquals(32.19D,basket.getRows().get(0).getTotalWithTax().getValue());
		Assert.assertEquals(20.89D,basket.getRows().get(1).getTotalWithTax().getValue());
		Assert.assertEquals(9.75D,basket.getRows().get(2).getTotalWithTax().getValue());
		Assert.assertEquals(11.85D,basket.getRows().get(3).getTotalWithTax().getValue());
		
		Assert.assertEquals(6.7D,basket.getTax().getValue());
		Assert.assertEquals(74.68D,basket.getTotalWithTax().getValue());
		}
}
