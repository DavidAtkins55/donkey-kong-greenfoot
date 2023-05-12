import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreBoard extends Actor
{
    private int lives; // A variable to store the number of lives
    private mario mario = new mario(); // A reference to the Mario actor
    
    
    public ScoreBoard()
    {
        this.mario = mario;//Store a reference to the Mario actor
        lives = mario.getLives(); // Get the initial number of lives from the Mario actor
        setImage(new GreenfootImage("Lives: " + lives, 24, Color.WHITE, Color.BLACK)); // Set the image of the actor to show the score
        update();
    }
    
    public void update()
    {
        setImage(new GreenfootImage("Lives: " + lives, 24, Color.WHITE, Color.BLACK)); // Update the image to show the current number of lives
    }
    
    public void isbarrelled(){
        
        if (isTouching(Barrel.class)) {
            removeTouching(Barrel.class);
            lives--;
            if (lives == 0) {
                Greenfoot.stop();
            }
        }   
    }
}
