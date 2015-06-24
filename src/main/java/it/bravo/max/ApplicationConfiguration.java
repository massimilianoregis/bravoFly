package it.bravo.max;

import it.bravo.max.index.Basket;
import it.bravo.max.index.Index;
import it.bravo.max.index.concrete.IndexMemory;
import it.bravo.max.index.concrete.bravo.BasketBravo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
	@Bean
	public Index indexBravo()
		{
		return new IndexMemory();
		}
	@Bean Basket basketBravo()
		{
		return new BasketBravo("CH");
		}
}
