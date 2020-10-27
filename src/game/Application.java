package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

/**
 * The main class for the Jurassic World game.
 *
 */
public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new GrassDirt(), new Wall(), new Floor(), new Tree(), new VendingMachine(), new Water());

		List<String> map = Arrays.asList(
				"................................................................................",
				"................................................................................",
				".....#######....................................................................",
				".....#V____#..................................~~~~~~............................",
				".....#_____#.........................................~~~~~~~....................",
				".....###.###................................................~~~~~~..............",
				"................................................................................",
				"......................................+++.......................................",
				".......................................++++.....................................",
				"...........~~~~....................+++++........................................",
				"..............~~~~...................++++++.....................................",
				".................~~~~.................+++.......................................",
				".....................................+++........................................",
				"................................................................................",
				"............+++.................................................................",
				".............+++++..............................................................",
				"...............++........................................+++++..................",
				".............+++....................................++++++++....................",
				"............+++..............~~~~~~...................+++.......................",
				".........................~~~~~~...~~~~~~........................................",
				".........................................................................++.....",
				"........................................................................++.++...",
				".........................................................................++++...",
				"..........................................................................++....",
				"................................................................................");
		GameMap gameMap = new GameMap(groundFactory, map );
		world.addGameMap(gameMap);

		Actor player = new Player("Player", '@', 100);
		world.addPlayer(player, gameMap.at(9, 4));

		// Place a pair of stegosaurs in the middle of the map
		gameMap.at(10, 12).addActor(new Stegosaur("Stegosaur", 10));
		gameMap.at(15, 12).addActor(new Stegosaur("Stegosaur", 10));


		world.run();
	}
}
