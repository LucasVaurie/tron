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
        char [][] grille = new char[20][30];
        grille = initGrille(grille); // Initialisation à 0 de la grille de jeu
        String direction = "null";    
        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).
            int currentX = 0, currentY = 0;
            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
                grille[Y0][X0] = Character.forDigit(i, 16); //Conversion en caractère
                grille[Y1][X1] = Character.forDigit(i, 16);
                if (i == P) {
                    currentX = X1; // récupération coordonnées quand tour du joueur
                    currentY = Y1;
                }
            }
            direction = actionChoisie(grille, currentX, currentY, direction);
            System.out.println(direction);
        }
    }
    /**
    * Initialise un tableau de caractère pour la grille de jeu
    * Cases du tableau initialisées à 'o'
    *
    * @param grilleVide
    *     Double tableau de char
    * @return Le tableau remplit de caractèress 'o'
    */
    public static char[][] initGrille(char[][] grilleVide) {
        for (int i = 0 ; i < 20 ; i ++) {
            for (int j = 0 ; j < 30 ; j ++) {
                grilleVide[i][j] = 'o';
            }
        }
        return grilleVide;
    }
    
    /**
    * Décide de la direction à prendre pour le joueur
    *
    * @param grilleJeu
    *     Grille de jeu en temps réelle, remplie par les mouvements des diff. joueurs
    * @param currentX
    *     Position actuelle du joueur en abscisses
    * @param currentY
    *     Position actuelle du joueur en ordonnée
    * @param direction
    *     Direction prise par le joueur au tour d'avant
    * @return La direction choisie, soit "LEFT", "RIGHT", "UP" ou "DOWN"
    */
    public static String actionChoisie(char[][] grilleJeu, int currentX, int currentY, String direction) {
        boolean enCours = true; 
        String decision = "null";
        if (direction != "null") {
            decision = maintienDirection(grilleJeu, currentX, currentY, enCours, direction);
            if (decision != "null")
                return decision;
        }
        // Gestion de 'Aller à gauche'
        if (currentX-1 != -1 && enCours) {
            decision = dirGauche(grilleJeu, currentX, currentY, enCours);
            if (decision != "null")
                return decision;
        }
        // Gestion de 'Aller en haut'
        if (currentY-1 != -1 && enCours) {   
            decision = dirHaut(grilleJeu, currentX, currentY, enCours);
            if (decision != "null")
                return decision;
        }
        // Gestion de 'Aller en bas'
        if (currentY+1 <= 19 && enCours){
            decision = dirBas(grilleJeu, currentX, currentY, enCours);
            if (decision != "null")
                return decision;
        }
        // Gestion de 'Aller à droite'
        if (currentX+1 <= 29 && enCours) {
            decision = dirDroite(grilleJeu, currentX, currentY, enCours);
            if (decision != "null")
                return decision;
        }
        return "null";
    }

    /**
    * Fonction permettant le maintien dans une direction dès lors qu'elle est engagée
    *
    * @param currentGrille
    *     Grille de jeu en temps réelle, remplie par les mouvements des diff. joueurs
    * @param currentX
    *     Position actuelle du joueur en abscisses
    * @param currentY
    *     Position actuelle du joueur en ordonnée
    * @param running
    *     Booléen indiquant si une direction est active ou non
    * @return La direction choisie, soit "LEFT", "RIGHT", "UP" ou "DOWN"
    */
    public static String maintienDirection(char[][] currentGrille, int currentX, int currentY, boolean running, String dir) {
        if (dir == "LEFT") {
            if (currentX-1 != -1 && running)
                return dirGauche(currentGrille, currentX, currentY, running);
        } else if (dir == "UP") {
            if (currentY-1 != -1 && running)   
                return dirHaut(currentGrille, currentX, currentY, running);
        } else if (dir == "DOWN") {
            if (currentY+1 <= 19 && running)
                return dirBas(currentGrille, currentX, currentY, running);
        } else if (dir == "RIGHT") {
            if (currentX+1 <= 29 && running)
                return dirDroite(currentGrille, currentX, currentY, running);
        }
        return "null";
    }

    /**
    * Fonction permettant de prendre la direction "LEFT"
    */
    public static String dirGauche(char[][] currentGrille, int currentX, int currentY, boolean running) {
        if (currentGrille[currentY][currentX-1] == 'o') {
            running = false;
            return "LEFT";
        } 
        return "null";  
    }
    /**
    * Fonction permettant de prendre la direction "RIGHt"
    */
    public static String dirDroite(char[][] currentGrille, int currentX, int currentY, boolean running) {
        if (currentGrille[currentY][currentX+1] == 'o') {
            running = false;
            return "RIGHT";
        } 
        return "null";  
    }
    /**
    * Fonction permettant de prendre la direction "UP"
    */
    public static String dirHaut(char[][] currentGrille, int currentX, int currentY, boolean running) {
        if (currentGrille[currentY-1][currentX] == 'o') {
            running = false;
            return "UP";
        } 
        return "null";  
    }
    /**
    * Fonction permettant de prendre la direction "DOWN"
    */
    public static String dirBas(char[][] currentGrille, int currentX, int currentY, boolean running) {
        if (currentGrille[currentY+1][currentX] == 'o') {
            running = false;
            return "DOWN";
        } 
        return "null";  
    }
}