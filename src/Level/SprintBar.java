package Level;

import Engine.GraphicsHandler;
import java.awt.*;


// Represents the game's sprint bar
// Will display and update the sprint bar through a visual rectangle that parallels the sprint bar value based on the player's running status
public class SprintBar {
    // whether sprint bar is shown or not
    protected boolean isActive;

    // sprint bar constants
    protected final int x = 680;
    protected final int y = 22;
    protected int width = 0;
    protected final int height = 10;

    private Map map;

    public SprintBar(Map map) {
        this.map = map;
    }

    public void draw(double sprintBar, GraphicsHandler graphicsHandler) {
        int width = (int) Math.floor(sprintBar*10);

        // draw sprint bar
        if(sprintBar != 0){
            graphicsHandler.drawFilledRectangle(x, y, width, height, Color.red);
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
