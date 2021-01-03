import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Tron {
    public static String actionChoisie(char[][] grilleJeu, int currentX, int currentY, String direction) {
        boolean enCours = true;
        
        if (direction == "LEFT") {
            if (currentX-1 != -1 && enCours) {
                if (grilleJeu[currentY][currentX-1] == 'o') {
                    enCours = false;
                    return "LEFT";
                }
            }
        } else if (direction == "UP") {
            if (currentY-1 != -1 && enCours) {   
                if (grilleJeu[currentY-1][currentX] == 'o') {
                    enCours = false;
                    return "UP";
                }
            }
        } else if (direction == "DOWN") {
            if (currentY+1 <= 19 && enCours){
                if (grilleJeu[currentY+1][currentX] == 'o') {
                    enCours = false;
                    return "DOWN";
                }
            }
        } else if (direction == "RIGHT") {
            if (currentX+1 <= 29 && enCours) {
                if (grilleJeu[currentY][currentX+1] == 'o') {
                    enCours = false;
                    return "RIGHT";
                }
            }
        }

        
        // Gestion de 'Aller à gauche'
        if (currentX-1 != -1 && enCours) {
            if (grilleJeu[currentY][currentX-1] == 'o') {
                enCours = false;
                return "LEFT";
            }
        }

        // Gestion de 'Aller en haut'
        if (currentY-1 != -1 && enCours) {   
            if (grilleJeu[currentY-1][currentX] == 'o') {
                enCours = false;
                return "UP";
            }
        }

        // Gestion de 'Aller en bas'
        if (currentY+1 <= 19 && enCours){
            if (grilleJeu[currentY+1][currentX] == 'o') {
                enCours = false;
                return "DOWN";
            }
        }

        // Gestion de 'Aller à droite'
        if (currentX+1 <= 29 && enCours) {
            if (grilleJeu[currentY][currentX+1] == 'o') {
                enCours = false;
                return "RIGHT";
            }
        }
        return "null";
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        char [][] grille = new char[20][30];
        String direction = "null";
        // Initialisation à 0 de la grille de jeu
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
            // boolean enCours = true;
            
            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
                grille[Y0][X0] = Character.forDigit(i, 16);
                grille[Y1][X1] = Character.forDigit(i, 16);
                if (i == P) {
                    currentX = X1;
                    currentY = Y1;
                }
            }

            direction = actionChoisie(grille, currentX, currentY, direction);
            System.out.println(direction);
        }
    }
    
}