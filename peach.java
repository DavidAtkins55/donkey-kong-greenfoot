import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class peach extends Actor
{

    
    public boolean istouchpeach() {

    Actor mario= getOneIntersectingObject(mario.class);
    return mario != null;
    }

    
    public void act() {
    // Check if mario is touching the peach object
    List<mario> marios = getObjectsAtOffset(0, 0, mario.class);
    if (!marios.isEmpty()) {
        // Change the image of the peach object
        setImage("toosmalltosee.png");
    }
    }
}

