package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

public class Archaeopteryx extends Dinosaur {

    /**
     * Constructor.
     * Sets the gender of the dinosaur by random.
     * Both dinosaurs have Wander and Hungry behaviours.
     *
     * @param name        Name to of the dinosaur
     */
    public Archaeopteryx(String name) {
        super(name, 'x', 100, 20, true, false);
    }

    /**
     * Select and return an action to perform on the current turn. If the
     * Allosaur is next to the stegosaur ( in the adjacent cells), it will attack
     * the Stegosaur.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        return super.playTurn(actions, lastAction, map, display);
    }

}
