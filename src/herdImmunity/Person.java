package herdImmunity;

import apcs.Window;

public class Person {
	
	double x = Math.random() * Window.width();
	double y = Math.random() * Window.height();
	
	double dx = Math.random() * 10 - 5;
	double dy = Math.random() * 10 - 5;
	
	boolean infected = false;
	int recovery = HerdImmunity.recoveryTime;
	boolean immunized = false;
	boolean dead = false;
	
	public void update() {
		Window.out.color("tan");
			if(this.infected) {
				if(recovery == 0) {
					this.infected = false;
				} else {
				Window.out.color("green");
				recovery--;
				}
			}
		/*int skinColor = Window.random(0, 2);
			if(skinColor == 0) {
				Window.out.color("tan");
			} else if(skinColor == 1) {
				Window.out.color("brown");
			} else if(skinColor == 2) {
				Window.out.color("lightbrown");
			}*/
		Window.out.circle(x, y, 5);
	}
	
	public void move() {
		x += dx;
		y += dy;
		
		if(x<0 || x > Window.width()) {
			x = Math.min(Math.max(x, 0), Window.width());
			dx = -dx;
		}
		if(y<0 || y > Window.height()) {
			y = Math.min(Math.max(y, 0), Window.height());
			dy = -dy;
		}
	}
	

	public void contactWith(Person other) {
		double tempdx = this.dx;
		this.dx = other.dx;
		other.dx = tempdx;
		if(other.infected) {
			if(Math.random() < HerdImmunity.contagious) {
				this.infected = true;
				this.immunized = true;
			}
		}
		if(other.infected && recovery == 0) {
			if(Math.random() < HerdImmunity.immunizedContagious)
				recovery = 300;
				this.infected = true;
		}
	}
	public void death() {
		
	}

	public boolean isTouching(Person other) {
		double distance = Math.sqrt(Math.pow(x - other.x, 2)) + Math.sqrt(Math.pow(y - other.y, 2));
		return distance <= 10;
	}
}