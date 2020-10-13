package game;

import edu.monash.fit2099.engine.*;

public class Tree extends Ground {
	private int age = 0;

	public Tree() {
		super('+');
	}

	public SearchTreeAction getSearchTreeAction() {
		return new SearchTreeAction(this);
	}


	@Override
	public void tick(Location location) {
		super.tick(location);

		age++;
		if (age == 10)
			displayChar = 't';
		if (age == 20)
			displayChar = 'T';
		// Tree has small % chance of dropping a fruit
		if(Math.random()<=0.05){
			FruitItem newFruit = new FruitItem();
			location.addItem(newFruit);
		}
	}
}
