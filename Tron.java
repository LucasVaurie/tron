import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Tron {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).
            
            char [][] grille = new char[30][20];
            for (int boucleur_1 = 0 ; boucleur_1 < 30 ; boucleur_1 ++) {
                for (int boucleur_2 = 0 ; boucleur_2 < 20 ; boucleur_2 ++) {
                    grille[boucleur_1][boucleur_2] = 'o';

                }
            }

            //System.err.println(Arrays.toString(grille));
            
            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("LEFT"); // A single line with UP, DOWN, LEFT or RIGHT
        }
    }
}