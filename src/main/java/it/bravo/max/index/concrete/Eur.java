package it.bravo.max.index.concrete;

import it.bravo.max.index.Money;

public class Eur implements Money {
	private Double value;
	public Eur(Double value)	{
		this.value=(Math.round(value*100)/100D);		
	}
	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public String getCurrency() {
		return "EUR";
	}
	@Override
	public Eur mul(Float value) {	
		return new Eur(this.value*value);
	}
	@Override
	public Eur add(Money value) {		
		return new Eur(this.value+value.getValue());
	}
	@Override
	public String toString() {		
		return value+" Eur";
	}
	public Money roundUp(){
		double round = java.lang.Math.ceil((value / 0.05)) * 0.05;
			
		return new Eur(round);
	}	
}
