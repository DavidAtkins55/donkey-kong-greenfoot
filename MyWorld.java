import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{
    private mario mario;
    private ScoreBoard scoreboard;
    
    public MyWorld()
    {    
        super(600, 800, 1); 
        scoreboard = new ScoreBoard(); // Instantiate the scoreboard object first
        mario = new mario(); // Then pass it to the mario constructor
        addObject(scoreboard, 35, 10); 
        act();
        level();
    }

    public void act(){
        scoreboard.update();
    }


    public void level() 
    {
        addObject(new dk(), 165, 67);
        addObject(new mario(),110 , 775);
        addObject(new peach(),350 , 35);

        //first platforms
        addObject(new platform(), 0, 800);
        addObject(new platform(), 50, 800);
        addObject(new platform(), 100, 800);
        addObject(new platform(), 150, 800);
        addObject(new platform(), 220, 790);
        addObject(new platform(), 290, 780);
        addObject(new platform(), 360, 770);
        addObject(new platform(), 430, 760);
        addObject(new platform(), 500, 750);
        addObject(new platform(), 570, 740);
        addObject(new Ladder(), 455, 710);

        //second platform
        addObject(new platform(), 500, 665);
        addObject(new NSldPltfrm(), 430, 660);
        addObject(new platform(), 360, 655);
        addObject(new platform(), 290, 650);
        addObject(new platform(), 220, 645);
        addObject(new platform(), 150, 640);
        addObject(new platform(), 80, 635);
        addObject(new platform(), 10, 630);
        addObject(new Ladder(), 150, 580);
        


        //third platforms
        addObject(new NSldPltfrm(), 150, 530);
        addObject(new platform(), 220, 520);
        addObject(new platform(), 290, 510);
        addObject(new platform(), 360, 500);
        addObject(new platform(), 430, 490);
        addObject(new platform(), 500, 480);
        addObject(new platform(), 570, 470);
        addObject(new Ladder(), 520, 430);
        
        
        
        //fourth platform
        addObject(new NSldPltfrm(), 500, 380);
        addObject(new platform(), 430, 375);
        addObject(new platform(), 360, 370);
        addObject(new platform(), 290, 365);
        addObject(new platform(), 220, 360);
        addObject(new platform(), 150, 355);
        addObject(new platform(), 80, 350);
        addObject(new platform(), 10, 345);
        addObject(new Ladder(), 160, 305);
        
        //fifth platforms
        addObject(new NSldPltfrm(), 150, 250);
        addObject(new platform(), 220, 245);
        addObject(new platform(), 290, 240);
        addObject(new platform(), 360, 235);
        addObject(new platform(), 430, 230);
        addObject(new platform(), 500, 225);
        addObject(new platform(), 570, 220);
        addObject(new Ladder(), 500, 200);

        //donkey kong platform
        addObject(new platform(), 20, 130);
        addObject(new platform(), 70, 130);
        addObject(new platform(), 120, 130);
        addObject(new platform(), 170, 130);
        addObject(new platform(), 220, 130);
        addObject(new platform(), 270, 130);
        addObject(new platform(), 320, 130);
        addObject(new platform(), 390, 135);
        addObject(new platform(), 440, 140);
        addObject(new NSldPltfrm(), 510, 145);
        
        //princess peach platform
        addObject(new platform(), 330, 70);
        addObject(new platform(), 370, 70);
        
        
        //deadbarrels for athestic
        addObject(new deadbarrel(), 70, 70);
        addObject(new deadbarrel(), 70, 100); 
        addObject(new deadbarrel(), 30, 70);
        addObject(new deadbarrel(), 30, 100);
        addObject(new Ladder(), 250, 70);
        addObject(new finish_ladder(), 300, 70);

        //addObject(new Barrel(), 245, 105);
        
        
    }

}
