package it.bravo.max.index.concrete;

import it.bravo.max.index.Good;
import it.bravo.max.index.Index;
import it.bravo.max.index.Tags;

import java.util.ArrayList;
import java.util.List;

public class IndexMemory implements Index {


	private List<Good> goods = new ArrayList<Good>();
	@Override
	public Good getGood(String id) {
		System.out.println(goods);
		return goods.get(goods.indexOf(new GoodFinder(id)));
	}

	@Override
	public List<String> getTags() {
		return null;
	}

	@Override
	public void addBook(String id, String name, Double money,String madein) {
		addGood(new GoodMemory(id,name,madein,money,Tags.BOOK));
	}

	@Override
	public void addCD(String id, String name, Double money, String madein) {
		addGood(new GoodMemory(id,name,madein,money,Tags.CD));
	}

	@Override
	public void addFood(String id, String name, Double money, String madein) {
		addGood(new GoodMemory(id,name,madein,money,Tags.FOOD));
	}

	@Override
	public void addCosmetic(String id, String name, Double money,String madein) {
		addGood(new GoodMemory(id,name,madein,money,Tags.COSMETIC));		
	}
	public void addGood(Good good)	{
		this.goods.add(good);
		System.out.println(this.goods);
	}
	@Override
	public void addMedical(String id, String name, Double money, String madein) {
		addGood(new GoodMemory(id,name,madein,money,Tags.MEDICAL));
	}
	static public class GoodFinder
		{
		private String code;
		public GoodFinder(String code){
			this.code=code;
			}
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Good)
				return ((Good)obj).getCode().equals(code);
			return super.equals(obj);
		}
		}
}
