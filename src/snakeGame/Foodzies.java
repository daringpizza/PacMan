package snakeGame;

import apcs.Window;

public class Foodzies {
	double x = Math.random() * 500;
	double y = Math.random() * 500;
	public Foodzies(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void draw() {
		Window.out.color("red");
		Window.out.square((int) x, (int) y, 10);
	}
}
