import java.awt.*;
import java.util.Random;

class Tiger extends Critter {

    private int rnd;
    private int moves;
    private boolean hasInfected = false;
    public Tiger() {
    }

    public Color getColor() {
        rnd = new Random().nextInt(4);
        if(rnd == 1) {
            return Color.RED;
        } else if (rnd == 2) {
            return Color.GREEN;
        } else {
            return Color.BLUE;
        }
    }

    public String toString() {
        return "TGR";
    }

    public boolean hasInfected(){
        return hasInfected;
    }

    public Action getMove(CritterInfo info) {
        if (info.frontThreat()) {
            hasInfected = true;
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }
}