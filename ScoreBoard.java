import greenfoot.*;
import java.util.List;

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
        World world = getWorld(); 
        List<mario> marios = world.getObjects(mario.class); // verifies that there is a Mario actor in the world was getting a null type error otherwise
        if (!marios.isEmpty()) { 
            gameover gameover= new gameover();
            mario mario = marios.get(0); 
            if (mario.isTouchingBarrel()) // Check if mario is touching a barrel
            {
                mario.removeTouchingBarrel(); // Remove the barrel from the world
                
                life--; // Decrease the lives by one
                setImage(new GreenfootImage("Life: " + life, 24, Color.WHITE, Color.BLACK)); // Update the image of the actor to show the new score
                if (life == 0) // Check if the life is zero 
                { 
                    getWorld().addObject(gameover, 300, 350); // Show a game over message 
                    Greenfoot.stop(); // Stop the game 
                    
                }
            }
        }
    }
}
