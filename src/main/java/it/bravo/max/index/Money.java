package it.bravo.max.index;

public interface Money {
	public Double getValue();
	public String getCurrency();
	public Money mul(Float value);
	public Money add(Money value);
	public Money roundUp();
}
