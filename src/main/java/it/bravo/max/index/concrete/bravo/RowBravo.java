package it.bravo.max.index.concrete.bravo;

import it.bravo.max.index.Basket;
import it.bravo.max.index.Good;
import it.bravo.max.index.Money;
import it.bravo.max.index.Row;
import it.bravo.max.index.Tags;

import java.math.BigDecimal;

/**
 * 
 * @author max
 *
 * In the specific the BL is contained in the Row class in the complex real case
 * is possible to move into external command pattern
 */
public class RowBravo implements Row {
	private Float qta;
	private Good good;
	private Basket basket;
	public RowBravo(Basket basket, Good good) {
		this.good=good;
		this.qta=1F;
		this.basket=basket;
		}
	@Override
	public Float getQta() {
		return qta;
	}

	@Override
	public Good getGood() {
		return good;
	}

	@Override
	public Money getTotal() {
		return good.getPrice().mul(getQta());
	}

	/**
	 * the BL is contained here
	 */
	@Override
	public Money getTax() {
		Float tax = .10F;
		if(good.getTags().contains(Tags.BOOK)) 		tax=0F;
		if(good.getTags().contains(Tags.FOOD)) 		tax=0F;
		if(good.getTags().contains(Tags.MEDICAL))	tax=0F;
		
		if(!good.getMadeIn().equals(basket.getCountry())) tax+=0.05F;			
		return getTotal().mul(tax).roundUp();
	}

	@Override
	public Money getTotalWithTax() {
		return getTotal().add(getTax());
	}

	@Override
	public String toString() {
		return good.getName()+" "+getTotal()+" ("+getTax()+") = "+getTotalWithTax();
	}
}
