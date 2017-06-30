package Agar;

import apcs.Window;

public class Agar {
	double radius = 10;
	double x = Math.random() * Window.width();
	double y = Math.random() * Window.height();
	
	double dx = Math.random() * 10 - 5;
	double dy = Math.random() * 10 - 5;
	public void draw() {
		Window.out.color("red");
		Window.out.circle(x, y, radius);
		
	}

	public void move() {
		x += dx;
		y += dy;
		
		/*if(Math.random() < 0.1) {
			dx = Math.random() * 10 - 5;
			dy = Math.random() * 10 - 5;
		}*/
		if(x < 10) {
			x = 10;
			dx = -dx;
		}
		if(x > 990) {
			x = 990;
			dx = -dx;
		}
		if(y < 10) {
			y = 10;
			dy = -dy;
		}
		if(y > 990) {
			y = 990;
			dy = -dy;
		}
	}

	public boolean isEating(Food f) {
		return Math.sqrt(Math.pow(x-f.x, 2) + Math.pow(y-f.y, 2)) <= 15;
	}
	public void control() {
		double angle = Math.atan2(Window.mouse.getY()-y, Window.mouse.getX() - x);
		dx = 10 * Math.cos(angle);
		dy = 10 * Math.sin(angle);
	}
	public void eat(Food f) {
		radius = Math.sqrt(Math.pow(radius, 2) + 9);
	}
}