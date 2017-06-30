package Basketball;

import java.math.RoundingMode;
import java.text.DecimalFormat;


import apcs.Window;


public class Ball {
	int x = 200;
	int y = Window.height() / 2;
	double dx = 0;
	double dy = 0;
	int time = 0;
	double entropy = 0.5; // amount of energy lost with each bounce 1 = all energy conserved 0 = all energy lost
	double gravityFactor = 0.4;
	boolean shot = false;
	int counter = 0;
	int score = 0;
	
    
    public void draw() {
    	Window.out.color("orange");
		Window.out.circle(x, y, 10);
		Window.out.color("black");
		if(time%32 < 8) {
			Window.out.line(x+10, y, x-10, y);
			Window.out.line(x, y+10, x, y-10);
			Window.out.arc((int) (x-13), (int) y, 20, 20, 45, 90);
			Window.out.arc((int) (x+13), (int) y, 20, 20, 225, 90);
		} else if(time%32 < 16) {
			Window.out.line(x-7, y-7, x+7, y+7);
			Window.out.line(x+7, y-7, x-7, y+7);
			Window.out.arc((int) (x-10), (int) (y-10), 20, 20, 0, 90);
			Window.out.arc((int) (x+10), (int) (y+10), 20, 20, 180, 90);
		
		} else if (time % 32 < 24) {
			Window.out.line(x+10, y, x-10, y);
			Window.out.line(x, y+10, x, y-10);
			Window.out.arc((int) x, (int) (y+13), 20, 20, 135, 90);
			Window.out.arc((int) x, (int) (y-13), 20, 20, 315, 90);
		} else {
			Window.out.line(x-7, y-7, x+7, y+7);
			Window.out.line(x+7, y-7, x-7, y+7);
			Window.out.arc((int) (x+10), (int) (y-10), 20, 20, 270, 90);
			Window.out.arc((int) (x-10), (int) (y+10), 20, 20, 90, 90);
		}
		if(shot == false) {
			Window.out.image("BasketballPlayer.png", 150, 500);
		} else {
			Window.out.image("BasketballPlayerShooting.png", 150, 500);
		}
    }
    public void move() {
    	if(Window.mouse.clicked() && shot==false) {
    		dx = (Window.mouse.getX() - x)/10;
    		dy = (Window.mouse.getY() - y)/10;
    		//x = Window.mouse.getX();
    		//y = Window.mouse.getY();
    		counter++;
    		shot = true;
    	}
    	x += dx;
    	y += dy;
    	dy = dy + (gravityFactor*time)/100;
    	time++;
    }
    
    public void interact() {
    	if(x<10 || x>Window.width()-10 || y<10) {
    		x = 200;
    		y = Window.height() / 2;
    		dx = 0;
    		dy = 0;	
    		shot = false;
    		time = 0;
    	}
    	if(y>Window.height()-10 && shot == false){
    		y = Window.height() -10;
    		dy = -(dy*entropy);
    	} else if (y>Window.height()-10 && shot == true) {
    		x = 200;
    		y = Window.height() / 2;
    		dx = 0;
    		dy = 0;	
    		shot = false;
    		time = 0;
    	}
    	if(Math.abs(x-724)<15 && y>350) {
    		x = 710;
    		dx = -dx;
    	}
    	if(Math.abs(400 - y) < 10 && x < 720 && x > 680) {
    		x = 200;
    		y = Window.height() / 2;
    		dx = 0;
    		dy = 0;
    		score++;
    		shot = false;
    		time = 0;
    	}
    	  	
    }
    public void score() {
    	DecimalFormat df = new DecimalFormat("#.####");
    	df.setRoundingMode(RoundingMode.CEILING);
    	Window.out.color("black");
    	Window.out.print("SCORE:" + score, 100, 100);
    	Window.out.print("NUMBER OF SHOTS TAKEN: " + counter, 250, 100);
    	if(counter != 0) {
    		Window.out.print("RATIO: " + ((1.0*score)/(1.0*counter)), 600, 100);
    	} else {
    		Window.out.print("RATIO: ???", 600, 100);
    	}
    }

}