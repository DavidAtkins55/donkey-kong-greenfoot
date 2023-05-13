import greenfoot.*;

public class mario extends Actor
{
    private String[] img = {"mario_left.png", "mario_right.png","mario_jump.png"};
    private int jumpStrength = -10; 
    private int life = 3; 
    private double gravity = 0.5;
    private double vSpeed = 0; 
    boolean plEnding = false;
    private int score = 0;
    private ScoreBoard scoreBoard;
    
    
    public boolean onPlatform() {
    if (vSpeed >= 0) { 
        Actor platformAbove = getOneObjectAtOffset(0, -getImage().getHeight()/2 - 5, platform.class); // check for a platform above Mario's head
        if (platformAbove != null) {
            return false;
        }
    }
    Actor platformBelow = getOneIntersectingObject(platform.class);
    return platformBelow != null;
    }
    
    public void act() {
        moving();
        checkCollision();
        if (isTouching(Ladder.class)) {
            if (Greenfoot.isKeyDown("up")) {
                setLocation(getX(), getY() - 5);
                move(-5);
            }
        }
        if (isTouching(half_ladder.class)) {
            if (Greenfoot.isKeyDown("up")) {
                setLocation(getX(), getY() - 5);
                move(-5);
            }
        }
        if (isTouching(peach.class)) {
            setImage("peach_end.png");
            
            setLocation(350, 35);
            plEnding = true; //short for play-ending will set mario to behind the image stop the player being able to move and allow the gif or image of the ending to play.
        }
        if (onFloor()) {
        Actor platform = getOneIntersectingObject(platform.class);
        if (vSpeed >= 0 && platform != null) {
            vSpeed = 0; //method checks if mario is on the floor and that mario cannot jump through the platform above him 
            int newY = platform.getY() - (platform.getImage().getHeight() + getImage().getHeight())/2;
            setLocation(getX(), newY);
        }
        } else {
        Actor platformBelow = getOneObjectAtOffset(0, getImage().getHeight()/2, platform.class);
        if (vSpeed > 0 && platformBelow != null) { // check for collision with platform from below
            vSpeed = 0;
            int newY = platformBelow.getY() - (platformBelow.getImage().getHeight() + getImage().getHeight())/2;
            setLocation(getX(), newY);
        }
        Actor platformAbove = getOneObjectAtOffset(0, -getImage().getHeight()/2 - 5, platform.class);
        if (vSpeed < 0 && platformAbove != null) { // check for collision with platform from above
            vSpeed = 0;
            int newY = platformAbove.getY() + (platformAbove.getImage().getHeight() + getImage().getHeight())/2;
            setLocation(getX(), newY);
        }
        }
        youwin youwin = new youwin();
        if (plEnding == true){
            getWorld().addObject(youwin, 300, 350);
            Greenfoot.stop(); //plays the ending and stops the game.
        }
    }
    
    public void moving() {
        if(Greenfoot.isKeyDown("Left")) {
            move(-5);
            setImage(img[0]);
        }
        if(Greenfoot.isKeyDown("Right")) {
            move(5);
            setImage(img[1]);       
        }
        if(Greenfoot.isKeyDown("Space") && onPlatform()){ // only jump when on a platform
            vSpeed = jumpStrength; // set the vertical speed to 10 for the first jump 
            setImage(img[2]);              
        }   
        vSpeed = vSpeed + gravity;// increase the vertical speed by the gravity 
        int vxSpeed = (int) vSpeed;
        setLocation(getX(), getY() + vxSpeed); // move the actor vertically by the vertical speed
    }
    
    public boolean onFloor() {
        Actor below = getOneObjectAtOffset(0, getImage().getHeight()/2, platform.class);
        return below != null;
    }
    
    public void checkCollision() {
        Barrel barrel = (Barrel) getOneIntersectingObject(Barrel.class);
        if (barrel != null) {
            life--;
            getWorld().removeObject(barrel);
        }
    }
    //methods that the scoreboard will call
    public boolean isTouchingBarrel()
    {
        return (getOneIntersectingObject(Barrel.class) != null);
    }
    
        
    public void removeTouchingBarrel()
    {
        removeTouching(Barrel.class);
    }
    
    public int getScore() {
        return life;
    }
}