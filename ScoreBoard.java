import greenfoot.*;

public class ScoreBoard extends Actor
{
    private int life; // A variable to store the score
    
    
    public ScoreBoard()
    {
        life = 0; // Initialize the score to zero
        setImage(new GreenfootImage("Life: " + life, 24, Color.WHITE, Color.BLACK)); // Set the image of the actor to show the score
    }
    
    public void update()
    {
        World world = getWorld(); // Get a reference to the world
        mario mario = world.getObjects(mario.class).get(0); // import the mario actor
        if (mario.isTouchingBarrel()) // Check if mario is touching a barrel
        {
            life++;
            mario.removeTouchingBarrel(); // Remove the barrel object from the world
            setImage(new GreenfootImage("Life: " + life, 24, Color.WHITE, Color.BLACK)); // Update the image of the actor to show that it has lost one life
        }
    }
}