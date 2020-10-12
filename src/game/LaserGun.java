package game;

import edu.monash.fit2099.engine.Weapon;
import edu.monash.fit2099.engine.WeaponItem;

public class LaserGun extends WeaponItem implements Weapon {
    //constant and has to be capital !!!

    private int priceEcoPoint = 500;
    /**
     * Constructor.
     */
    public LaserGun() {
        super("LaserGun", 'L', 50, "shooting");
    }

    public int getPriceEcoPoints() {
        return priceEcoPoint;
    }
}
