import java.awt.*;

class Giant extends Critter {

    private int i = 0;
    private int mmoves = 0;
    public Giant() {

    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public String toString() {
        if(i == 0) {
            return "fee";
        } else if (i == 1) {
            return "fie";
        } else if (i == 2) {
            return "foe";
        } else {
            return "fum";
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        this.mmoves += 1;
        if(this.mmoves > 6) {
            this.mmoves = 0;
            this.i += 1;
        }
        if (this.i == 4) {
            this.i = 0;
        }
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront() != Neighbor.WALL) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }
}