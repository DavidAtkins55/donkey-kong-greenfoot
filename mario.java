import greenfoot.*;


public class mario extends Actor
{
    private GreenfootImage marioRight = new GreenfootImage("mario_right.png");
    private GreenfootImage marioLeft = new GreenfootImage("mario_left.png");
    private GreenfootImage marioJump = new GreenfootImage("mario_jump.png");
    private int life = 3; 
    private double vSpeed = 0; 
    private int jumpStrength = -11; 
    private double gravity = 0.5; 
    boolean plEnding = false;
    //ScoreBoard scoreboard = new ScoreBoard();
    
    public int getLives()
    {
        return life;
    }
    
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
        //scoreboard.update();
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
        //method checks if mario is on the floor and that mario cannot jump through the platform above him 
        if (onFloor()) {
        Actor platform = getOneIntersectingObject(platform.class);
            if (vSpeed >= 0 && platform != null) {
                vSpeed = 0;
                int newY = platform.getY() - (platform.getImage().getHeight() + getImage().getHeight())/2;
                setLocation(getX(), newY);
            }
            } else {
                // check for collision with platform from below
                Actor platformBelow = getOneObjectAtOffset(0, getImage().getHeight()/2, platform.class);
                if (vSpeed > 0 && platformBelow != null) {
                    vSpeed = 0;
                    int newY = platformBelow.getY() - (platformBelow.getImage().getHeight() + getImage().getHeight())/2;
                    setLocation(getX(), newY);
                }
                // check for collision with platform from above
                Actor platformAbove = getOneObjectAtOffset(0, -getImage().getHeight()/2 - 5, platform.class);
                if (vSpeed < 0 && platformAbove != null) {
                    vSpeed = 0;
                    int newY = platformAbove.getY() + (platformAbove.getImage().getHeight() + getImage().getHeight())/2;
                    setLocation(getX(), newY);
                }
            }
            youwin youwin = new youwin();
        if (plEnding == true){
            getWorld().addObject(youwin, 300, 350);
            Greenfoot.stop();
        }
    }
    
    public void moving() {
        if(Greenfoot.isKeyDown("Left")) {
            move(-5);
            setImage(marioLeft);
        }
        if(Greenfoot.isKeyDown("Right")) {
            move(5);
            setImage(marioRight);       
        }
        if(Greenfoot.isKeyDown("Space") && onPlatform()){ // only jump when on a platform
            vSpeed = jumpStrength; // set the vertical speed to 10 for the first jump 
            setImage(marioJump);              
        }   
        vSpeed = vSpeed + gravity;// increase the vertical speed by the gravity 
        int vxSpeed = (int) vSpeed;
        setLocation(getX(), getY() + vxSpeed); // move the actor vertically by the vertical speed
    }
    
    public boolean onFloor() {
        Actor below = getOneObjectAtOffset(0, getImage().getHeight()/2, platform.class);
        return below != null;
    }
    
}