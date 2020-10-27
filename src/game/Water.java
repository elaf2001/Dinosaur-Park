package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

public class Water extends Ground {
    /**
     * Constructor.
     *
     */
    private int DRINK_POINTS=25;

    public Water() {
        super('~');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor instanceof Archaeopteryx)
        {
            return true;
        }
        return false;
    }

    /**
     * Override this to implement terrain that blocks thrown objects but not movement, or vice versa
     * @return true
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }


    public DrinkAction getDrinkAction(){
        return new DrinkAction(this);
    }

    public int getDRINK_POINTS()
    {
        return DRINK_POINTS;
    }
}
