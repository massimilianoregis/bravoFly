package it.bravo.max.index;

public interface Row {
	public Float getQta();
	public Good getGood();
	public Money getTotal();
	public Money getTax();
	public Money getTotalWithTax();
}
