import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        char [][] grille = new char[20][30];
        
        // Initialisation de la grille de jeu à 0
        for (int boucleur_1 = 0 ; boucleur_1 < 20 ; boucleur_1 ++) {
            for (int boucleur_2 = 0 ; boucleur_2 < 30 ; boucleur_2 ++) {
                grille[boucleur_1][boucleur_2] = 'o';
            }
        }
        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).
            int currentX = 0, currentY = 0;
            boolean enCours = true;
            
            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
                grille[Y1][X1] = Character.forDigit(i, 16);
                if (i == P) {
                    currentX = X1;
                    currentY = Y1;
                }
            }

            /* // AFFICHAGE GRILLE DE JEU
            for (int i = 0 ; i < 20 ; i ++) {
                for (int y = 0 ; y < 30 ; y ++)
                    System.err.print(grille[i][y] + " "); //debug
                System.err.println(); //debug
            }
            */

            if (currentX-1 != -1 && enCours) {
                if (grille[currentY][currentX-1] == 'o') {
                    System.out.println("LEFT");
                    enCours = false;
                }
            }
            if (currentY-1 != -1 && enCours) {   
                if (grille[currentY-1][currentX] == 'o') {
                    System.out.println("UP");
                    enCours = false;
                }
            }
            if (currentX+1 <= 29 && enCours) {
                if (grille[currentY][currentX+1] == 'o') {
                    System.out.println("RIGHT");
                    enCours = false;
                }
            }
            if (currentY+1 <= 19 && enCours){
                if (grille[currentY+1][currentX] == 'o') {
                    System.out.println("DOWN");
                    enCours = false;
                }
            }
        
        }
    }
}