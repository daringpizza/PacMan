package Pong;

import apcs.Window;

public class Paddle {
	int x = 50;
	int y = 300;
	String upKey = "up";
	String downKey = "down";
	
	public Paddle(int newX, String up, String down) {
		x = newX;
		upKey = up;
		downKey = down;
	}
	
	public void draw() {
		Window.out.color("red");
		Window.out.rectangle(x, y, 10, 100);
	}
	public void move(){
		if(Window.key.pressed(upKey) && y > 50) {
			y = y - 10;
		}
		if(Window.key.pressed(downKey) && y < 550) {
			y = y + 10;
		}
	}
}