package game;

import edu.monash.fit2099.engine.Display;

import java.util.Scanner;

public class DisplayInt extends Display {

    private Scanner keyboard = new Scanner(System.in);

    public int readInt() {
        int num = Integer.parseInt(String.valueOf(keyboard.nextLine()));
        return num;
    }

}
