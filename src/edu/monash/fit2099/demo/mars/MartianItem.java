package edu.monash.fit2099.demo.mars;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Item;

public class MartianItem extends Item{

	public MartianItem(String name, char displayChar, boolean portable, int priceEcoPoints) {
		super(name, displayChar, portable,priceEcoPoints);
	}
	
	public void addAction(Action action) {
		this.allowableActions.add(action);
	}
}
