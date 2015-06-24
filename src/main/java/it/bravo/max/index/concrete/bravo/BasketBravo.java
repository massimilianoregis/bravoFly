package it.bravo.max.index.concrete.bravo;

import java.util.ArrayList;
import java.util.List;

import it.bravo.max.index.Basket;
import it.bravo.max.index.Good;
import it.bravo.max.index.Money;
import it.bravo.max.index.Row;
import it.bravo.max.index.concrete.Eur;

/**
 * 
 * @author max
 * This is a specific 'Bravo' basket that contains the custum Business logic 
 */
public class BasketBravo implements Basket{
	
	private String country;
	private List<Row> rows;
	public BasketBravo(String country)
		{
		rows = new ArrayList<Row>();
		this.country=country;
		}
	
	@Override
	public String getCountry() {
		return country;
	}
	@Override
	public List<Row> getRows() {		
		return rows;
	}
	@Override
	public void add(Good good) {
		rows.add(new RowBravo(this,good));
	}
	@Override
	public Money getTax() {
		Money total=new Eur(0D);
		for(Row item:rows)
			total= total.add(item.getTax());
		return total;
	}
	@Override
	public Money getTotal() {
		Money total=new Eur(0D);
		for(Row item:rows)
			total= total.add(item.getTotal());
		return total;
	}
	
	@Override
	public String toString() {	
		return getRows().toString()+" "+getTotalWithTax();
	}
	@Override
	public Money getTotalWithTax() {
		Money total=new Eur(0D);
		for(Row item:rows)
			total= total.add(item.getTotalWithTax());
		return total;
	}
}
