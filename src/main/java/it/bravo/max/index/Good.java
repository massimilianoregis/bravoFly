package it.bravo.max.index;

import java.util.List;

public interface Good 
	{
	public String getCode();
	public String getName();
	public String getMadeIn();
	public Money getPrice();
	public List<String> getTags();
	}
