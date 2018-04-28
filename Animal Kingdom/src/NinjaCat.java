import java.awt.*;

class NinjaCat extends Critter {
    public NinjaCat() {

    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public String toString() {
        return "Meow!";
    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.getFront() != Neighbor.WALL) {
            return Action.HOP;
        } else if(info.frontThreat()) {
            return Action.LEFT;
        }
        else {
            return Action.RIGHT;
        }
    }
}