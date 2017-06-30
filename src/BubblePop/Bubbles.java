package BubblePop;

import apcs.Window;

public class Bubbles {
	int x, y;
	double dx, dy;
	boolean popped = false;
	
	public Bubbles() {
		y = 800;
		x = Window.rollDice(600);		
	}

	public void draw() {
		
	}

	public void move() {
		x += dx;
		y += dy;
	}
	
}