package fruitNinja;

import apcs.Window;

public class Fruit {
	double x = 0;
	double y = 0;
	
	double dx = 0;
	double dy = 0;
	
	public Fruit() {
		y = Math.random() * 400;
		
		if(Math.random() < 0.5) {
			x = -50;
		} else {
			x = Window.width() + 50;
		}
	}
	
	public void draw() {
		
	}
	public void move() {
		
	}
}