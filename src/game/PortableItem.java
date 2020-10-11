package game;

import edu.monash.fit2099.engine.Item;

/**
 * Base class for any item that can be picked up and dropped.
 */
public class PortableItem extends Item {

	public PortableItem(String name, char displayChar, int priceEcoPoints) {
		super(name, displayChar, true,priceEcoPoints );
	}
}
