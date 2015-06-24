package it.bravo.max.index;

import java.util.List;

public interface Basket {
	public String getCountry();
	public List<Row> getRows();
	public void add(Good good);
	public Money getTotal();
	public Money getTax();
	public Money getTotalWithTax();
}
