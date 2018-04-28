import java.awt.*;

class WhiteTiger extends Tiger {

    private boolean hasInfeted = false;

    public WhiteTiger() {

    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public String toString() {
        if(hasInfeted) {
            return "TGR";
        }return "tgr";
    }

    @Override
    public Action getMove(CritterInfo info) {
        if(super.hasInfected()) {
            hasInfeted = true;
        }
        return super.getMove(info);
    }
}