import greenfoot.*;

class dk extends Actor {
  String[] imgz = { "pickup.png", "ragin.png", "throw.png" };
  int currentImageIndex = 0;
  int timeToChangeImage = 120;
  int probability = 1;
  int randomnumber = Greenfoot.getRandomNumber(3);
  boolean throwing = false;
  int timer = 0; 
  
  public void act() {
    animate();
    throwBarrel();
  }

  public void animate() {
    timeToChangeImage--;
    if (timeToChangeImage == 0) {
      currentImageIndex++;
      if (currentImageIndex >= imgz.length) {
        currentImageIndex = 0;
      }
      setImage(imgz[currentImageIndex]);
      timeToChangeImage = 180;
      // set throwing to true if the image is "throw.png"
      throwing = imgz[currentImageIndex].equals("throw.png");
    }
  }

  public void throwBarrel() {
    // throws a new barrel if the corrosponding throw image is set
    if (throwing) {
      // check if the timer is 0
      if (timer == 0) {
        Barrel barrel = new Barrel();
        getWorld().addObject(barrel,180, 95);
  
        setImage(imgz[2]);
        randomnumber = Greenfoot.getRandomNumber(3);
        setImage(imgz[randomnumber]);
        
        // timer that dictates how many barrels will be thrown
        timer = Greenfoot.getRandomNumber(20) + 80;
      }
      else {
        // decrement the timer by 1
        timer--;
      }
    }

}
}