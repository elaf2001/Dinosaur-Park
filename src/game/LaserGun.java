package game;

import edu.monash.fit2099.engine.Weapon;
import edu.monash.fit2099.engine.WeaponItem;

public class LaserGun extends BoughtItem implements Weapon {
    private int priceEcoPoint;
    /**
     * Constructor.
     */
    public LaserGun() {
        super("LaserGun", 'L', 500);
    }

    @Override
    public int damage() {
        return 50;
    }

    @Override
    public String verb() {
        return "shooting";
    }
}
