import java.util.Scanner;
import java.util.Random;

public class BattleShip {
    private static int[][] map;
    private static int playerShipsSinked = 0;
    private static int computerShipsSinked = 0;
    private static boolean playerhasplayedturn = false;
    private static boolean computerhasplayedturn = false;


    private static void displayMap() {
        System.out.println("   0123456789");
        for (int i = 0 ; i < map.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 3) {     ////missed shots
                    System.out.print("-");
                } else if (map[i][j] == 4){ //player hits his own ships
                    System.out.print("x");
                } else if(map[i][j] == 1) { // player ships
                    System.out.print("@");
                } else if (map[i][j] == 5) { // player hits computer's ships
                    System.out.print("!");
                } else {
                   System.out.print(" "); // blank with no turns played on it
               }
            }
            System.out.println("| " + i);
        }
        System.out.println("   0123456789");
    }

    private static boolean hasvalidxy(int x, int y) {
        if (x > map.length || y > map.length) {
            System.out.println("Co-ordinates out of bound !");
            return false;
        }
        return true;
    }

    private static void placeTheShip(int x, int y, int turn) {
        map[x][y] = turn;
    }
    private static void deployPlayerShips() {
        int playerShipsDeployed = 1;
        Scanner input = new Scanner(System.in);
        while (playerShipsDeployed != 6) {
            System.out.print("Enter X coordinate for your "+ playerShipsDeployed + ". ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your "+ playerShipsDeployed + ". ship: ");
            int y = input.nextInt();
            if (hasvalidxy(x,y)){
                placeTheShip(x,y,1);
                playerShipsDeployed++;
            }
        }
        displayMap();
    }
    private static void deployComputerShips() {
        System.out.println("Computer is deploying ships");
        Random rand = new Random();
        int computeerShipsDeployed = 1;
        while (computeerShipsDeployed != 6) {
            int x = rand.nextInt(map.length);
            int y = rand.nextInt(map.length);
            if (hasvalidxy(x,y)){
                placeTheShip(x,y,2);
                System.out.println(computeerShipsDeployed + ". ship DEPLOYED");
                computeerShipsDeployed++;
            }
        }
        displayMap();
    }


    private static void playerTurn() {
        System.out.println("YOUR TURN");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter X coordinate: ");
        int x = input.nextInt();
        System.out.print("Enter Y coordinate: ");
        int y = input.nextInt();

        if (hasvalidxy(x,y) && map[x][y] != 4 && map[x][y] != 5) {
            if (map[x][y] == 0) {
                System.out.println("Sorry, you missed"); // -
                map[x][y] = 3;
                playerhasplayedturn = true;
            } else if (map[x][y] == 1) {
                System.out.println("Oh no, you sunk your own ship :("); // x
                playerShipsSinked++;
                map[x][y] = 4;
                playerhasplayedturn = true;
            } else if (map[x][y] == 2) {
                System.out.println("Boom! You sunk the ship!");// !
                map[x][y] = 5;
                computerShipsSinked++;
                playerhasplayedturn = true;
            }
        } else {playerhasplayedturn = false;}
    }

    private static void computerTurn() {
        Random rand = new Random();
        int x = rand.nextInt(map.length);
        int y = rand.nextInt(map.length);
        System.out.println("COMPUTER'S TURN");
        if (hasvalidxy(x,y) && map[x][y] != 6 && map[x][y] != 5 && map[x][y] != 4) {// 6 stands for the duplicate wrong gusses of computer
            if (map[x][y] == 0) { //
                map[x][y] = 6;
                computerhasplayedturn = true;
                System.out.println("Computer missed");
            } else if (map[x][y] == 2) {
                System.out.println("The Computer sunk one of its own ships"); // !
                map[x][y] = 5;
                computerhasplayedturn = true;
                computerShipsSinked++;
            } else if (map[x][y] == 1) {
                System.out.println("The Computer sunk one of your ships!");// x
                map[x][y] = 4;
                computerhasplayedturn = true;
                playerShipsSinked++;
            }
        } else {computerhasplayedturn = false;}
    }
    private static boolean hasWon() {
        return playerShipsSinked == 5 || computerShipsSinked != 5;
    }

    private static void beginBattle() {
        while (hasWon()) {
            playerhasplayedturn = false;
            computerhasplayedturn = false;
            while (!playerhasplayedturn) {
                playerTurn();
            }
            while (!computerhasplayedturn) {
                computerTurn();
            }
            displayMap();
            System.out.println("Your ships: " + (5-playerShipsSinked)+ " | Computer ships: " + (5-computerShipsSinked));
            System.out.println("--------------------------------------------------");
        }
    }

    private static void endGame() {
        if (playerShipsSinked == 5) {
            System.out.println("Oops better luck next time!!..:(");
        } else {
            System.out.println("Hooray! You win the battle :)");
        }
    }
    public static void main(String[] args) {
        map = new int[10][10];
        displayMap();

        deployPlayerShips();

        deployComputerShips();

        beginBattle();

        endGame();

    }
}
