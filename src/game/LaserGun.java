package game;

import edu.monash.fit2099.engine.WeaponItem;

public class LaserGun extends WeaponItem {
    private int priceEcoPoint;
    /**
     * Constructor.
     */
    public LaserGun() {
        super("LaserGun", 'L', 50, "shooting");
        this.priceEcoPoint=500;
    }

}
