import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreBoard extends Actor
{
    private int life; // A variable to store the score
    
    public ScoreBoard()
    {
        life = 3; // Initialize the score to zero
        setImage(new GreenfootImage("Life: " + life, 24, Color.WHITE, Color.BLACK)); // Set the image of the actor to show the score
    }
    
    public void update()
    {
        World world = getWorld(); // Get a reference to the world
        mario mario = world.getObjects(mario.class).get(0); // Get a reference to the catcher object
        if (mario.isTouchingBarrel()) // Check if the catcher is touching any leaf object
        {
            life--;
            mario.removeTouchingBarrel(); // Remove the leaf object from the world
            setImage(new GreenfootImage("Life: " + life, 24, Color.WHITE, Color.BLACK)); // Update the image of the actor to show the new score
        }
    }
}