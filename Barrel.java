import greenfoot.*; 

public class Barrel extends Actor { 
 
    int xspeed = 3; int yspeed = 1; 
    public void act() { 
        setImage("barrel.png");
        moveLeft();
        switchdir();
        onFloor();
        adjustY();
        disappear();
    } 
    
    public void moveLeft() { 
        setLocation(getX() + xspeed, getY() + yspeed); 
    } 
        
    public void switchdir() {
        if (getX () <= 2 || getX () >= getWorld (). getWidth () - 2)
        { 
            xspeed = -xspeed; 
        } 
    }
        
    public boolean onFloor() {
        Actor below = getOneObjectAtOffset(0, getImage().getHeight()/5, platform.class);
        return below != null;
    }

    public void adjustY() {
        if (onFloor()) {
            Actor below = getOneObjectAtOffset(0, getImage().getHeight()/2, platform.class);
            setLocation(getX(), below.getY() - getImage().getHeight()/2);
        }
    }
    
    public void disappear() {
    World world = getWorld();
    // get the coordinates of the barrel
    int x = getX();
    int y = getY();
    // check if the barrel is within 30px of the bottom left corner
    if (x <= 30 && y >= world.getHeight() - 30) {
        // remove the barrel from the world
        world.removeObject(this);
        }
    }
}
    