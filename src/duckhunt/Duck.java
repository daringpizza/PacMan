package duckhunt;

import apcs.Window;

public class Duck {
	 int x = Window.random(0, Window.width());
	 int y = Window.random(400, 500);
	 int dx = 0;
	 int dy = 0;
	 boolean flying = false;
	 boolean dying = false;
	 
	 
	 public void draw() {
		 Window.out.color("red");
		 Window.out.circle(x, y, 12);
		 Window.out.color("white");
		 Window.out.circle(x, y, 8);
		 Window.out.color("red");
		 Window.out.circle(x, y, 4);
	 }
	 
	 public void move() {
	        // If the duck is flying, move the duck
	        if (flying) {
	            x = x + dx;
	            y = y + dy;
	            
	            if (dying) {
	                dy = dy + 2;
	            }
	        }
	        // Otherwise
	        else {
	            // Possibly move around on the ground
	            
	            // Randomly decide to take flight
	            if (Window.rollDice(1000) == 1) {
	                flying = true;
	                dx = Window.rollDice(11) - 6;
	                dy = Window.random(-15, -10);
	            }
	        }
	    }

	    public boolean isHit() {
	        if (Window.mouse.clicked() &&
	            Math.abs(Window.mouse.getX() - x) < 10 &&
	            Math.abs(Window.mouse.getY() - y) < 10) {
	            return true;
	        }
	        return false;
	    }

	    public void die() {
	        if (! dying) {
	            //score = score + 1;
	            dying = true;
	            dx = Window.rollDice(3) - 2;
	            dy = 5;
	        }
	    }

	}