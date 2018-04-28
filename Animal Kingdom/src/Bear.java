import java.awt.*;

class Bear extends Critter {

    private boolean polar;
    private boolean slashMove = true;
    public Bear(boolean polar) {
        this.polar = polar;
    }

    public Action getMove(CritterInfo info) {
        slashMove = !slashMove;
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

    public Color getColor() {
        if (polar) {
            return Color.WHITE;
        }
        return Color.BLACK;
    }

    public String toString() {
        if(slashMove){
            return "/";
        } else {
            return "\\";
        }
    }
}