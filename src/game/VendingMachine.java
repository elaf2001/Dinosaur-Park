package game;

import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;


public class VendingMachine extends Ground {
    /**
     * Constructor.
     *
     *
     */
    public VendingMachine() {
        super('V');
    }


    public int getRequiredPoints(BoughtItem boughtItem){
        return boughtItem.getPriceEcoPoints();
    }

    public BoughtItem menuVendingMachine()
    {
        BoughtItem boughtItem;
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
        if (String.valueOf(playerChoice).equals('1')){
            boughtItem=new HayItem();
        }
        else if(String.valueOf(playerChoice).equals('2'))
        {
            boughtItem=new FruitItem();
        }
        else if(String.valueOf(playerChoice).equals('3'))
        {
            boughtItem=new VegetarianMealKitItem("VMK",'>');
        }
        else if(String.valueOf(playerChoice).equals('4'))
        {
            boughtItem=new CarnivoreMealKitItem("CMK",'<');
        }
        else if(String.valueOf(playerChoice).equals('5'))
        {
            boughtItem=new AllosaurEgg("AG");
        }
        else if(String.valueOf(playerChoice).equals('6'))
        {
            boughtItem=new StegosaurEgg("SG");
        }
        else if(String.valueOf(playerChoice).equals('7'))
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
