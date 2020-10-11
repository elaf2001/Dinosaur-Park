package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import java.lang.Math;

/**
 * An abstract class that holds all the attributes and methods shared by any kind of the dinosaur.
 * It inherits {PortableItem}.
 */
public abstract class Dinosaur extends Actor {


    protected int foodLevel; //not sure about the protected thingy
    private Behaviour behaviour;


    private String gender; //female or male
    private int age;
    private boolean is_alive=true;
    private int turn=0;
    private int hitPoints=100;

    /**
     * Constructor.
     *
     * @param name        Name to of the dinosaur
     * @param displayChar Character to represent the dinosaur in the UI
     * @param hitPoints   Dinosaur's starting number of hitpoints
     */
    public Dinosaur(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        setGender();
        behaviour = new WanderBehaviour();
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new AttackAction(this));
    }

    /**
     * Returns the current age, that will be used to make sur that the dinosaur is able to breed.
     */
    public int getAge() {
        return age;
    }
    /**
     *Returns the current food level, which is used for breeding
     */
    public int getFoodLevel() {
        return foodLevel;
    }
    /**
     * Returns the gender, which is used for breeding
     */
    public String getGender() {
        return gender;
    }
    /**
     * Returns if the dinosaur is alive
     */
    public boolean getIs_alive() {
        return is_alive;
    }


    /**
     * Decreases dinosaur food level by 1
     * This method is called once per turn, if the food level of the dinosaur is more than 0 and the dinosaur is alive.
     */
    public void decreaseFoodLevel()
    {
        this.foodLevel-=1;
    }
    /**
     * Decreases dinosaurs hit points by the amount passed as a parameter.
     * This method is called, if the dinosaur is attacked by another actor.
     * @param damage the damage that dinosaur gets from the attack
     */
    public void decreaseHitPoints(int damage)
    {
        this.hitPoints-=damage;
    }
    /**
     * Allows the dinosaur to eat food, which increases its food points
     * This method is called if the dinosaur is fed or eating that it found
     * @param food is the food object that dinosuar is eating
     */
    public void eat(FoodItem food){
        //if mealKit increases dinosaur food level to maximum
        if (food instanceof MealKitItem){
            this.foodLevel=100;
        }
        // if not mealKit increases dinosaur food level by amount food points of this food
        else {
            int increment = food.getFoodPoints();
            if (increment < 100 - foodLevel) {
                this.foodLevel += increment;
            } else {
                this.foodLevel = 100;
            }
        }
    }
    /**
     * Increases the current dinosaur age by 1
     * This method is called once per turn, if the dinosaur is alive.
     */
    public void increaseAge() {
        this.age+=1;
    }

    /**
     * Checks the dinosaur food level and hit points to see if the dinosaur is conscious.
     * This method is called once per turn, if the dinosaur is alive
     */
    @Override
    public boolean isConscious(){
        boolean consciousness=false;
        if (super.isConscious()&&foodLevel>0)
            consciousness=true;
        return consciousness;
    }

    /**
     * This method randomly sets the gender: female/ male to the dinosaur
     * This method is called once, when the dinosaur object is created
     *
     */
    public void setGender() {
        String[] genders= new String[]{"male", "female"};
        double randomChoice =  Math.random();
        if(randomChoice<0.5){
            randomChoice= 0;
        }
        else{
            randomChoice= 1;
        }
        this.gender=genders[(int) randomChoice];
    }

    /**
     * This method counts how many rounds does the dinosaur stay unconsious.
     * If the counter reaches 20, the dinosaur dies
     * This method is called once per iteration, if the dinosaur is alive
     */
    public void countToDie() {
        if (!isConscious())
        {
            this.turn+=1;
        }
        else
        {
            this.turn=0;
        }
        if (this.turn==20)
        {
            this.is_alive=false;
            //the dinosaur dies and becomes a meat
        }
    }


    //actions and behaviours are not done


    /**
     * Figure out what to do next.
     *
     * FIXME: Stegosaur wanders around at random, or if no suitable MoveActions are available, it
     * just stands there.  That's boring.
     *
     * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        Action wander = behaviour.getAction(this, map);
        if (wander != null)
            return wander;

        return new DoNothingAction();
    }

}
