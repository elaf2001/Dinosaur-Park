package game;

import edu.monash.fit2099.engine.*;


public class VendingMachine extends Ground {
    /**
     * Constructor.
     *
     *
     */
    public VendingMachine() {
        super('V');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        return new Actions(new BuyItemAction(this));
    }

    public int getRequiredPoints(Item boughtItem){
        int requiredPoints =0;
        if (boughtItem instanceof BoughtItem){
            requiredPoints = ((BoughtItem) boughtItem).getPriceEcoPoints();
        } else if (boughtItem instanceof LaserGun ){
            requiredPoints = ((LaserGun) boughtItem).getPriceEcoPoints();
        }
        return requiredPoints;
    }

    public Item menuVendingMachine()
    {
        Item boughtItem;
        Display display= new Display();
        display.println("What would you like to purchase?");
        display.println("1. Hay - 20 EP ");
        display.println("2. Fruit - 30 EP ");
        display.println("3. Vegetarian meal kit - 100 EP ");
        display.println("4. Carnivore meal kit - 500 EP ");
        display.println("5. Stegosaur eggs  - 200 EP ");
        display.println("6. Allosaur eggs  - 1000 EP ");
        display.println("7. Laser gun - 500 EP \n");
        char playerChoice=display.readChar();
        if (playerChoice == '1'){
            boughtItem=new HayItem();
        }
        else if(playerChoice == '2')
        {
            boughtItem=new FruitItem();
        }
        else if(playerChoice == '3')
        {
            boughtItem=new VegetarianMealKitItem("VMK",'>');
        }
        else if(playerChoice == '4')
        {
            boughtItem=new CarnivoreMealKitItem("CMK",'<');
        }
        else if(playerChoice == '5')
        {
            boughtItem=new StegosaurEgg("SG");
        }
        else if(playerChoice == '6')
        {
            boughtItem=new AllosaurEgg("AG");
        }
        else if(playerChoice == '7')
        {
            boughtItem=new LaserGun();
        }
        else
        {
            return null;
        }
        return boughtItem;
    }
}
