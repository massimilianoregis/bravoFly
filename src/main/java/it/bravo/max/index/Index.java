package it.bravo.max.index;

import java.util.List;

public interface Index {	
	public Good getGood(String id);
	public List<String> getTags();
	
	public void addBook(String id, String name, Double money, String madein);
	public void addCD(String id, String name, Double money, String madein);
	public void addFood(String id, String name, Double money, String madein);
	public void addCosmetic(String id, String name, Double money, String madein);
	public void addMedical(String id, String name, Double money, String madein);
}
