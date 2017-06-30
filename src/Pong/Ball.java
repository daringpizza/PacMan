package Pong;

import apcs.Window;

public class Ball {
	int x = Window.width() / 2;
	int y = Window.height() / 2;
	int dx = 10;
	int dy = 4;
	int score1 = 0;
	int score2 = 0;
	boolean countdown = true;
	
	public void draw() {
		Window.out.color("white");
		Window.out.circle(x, y, 10);
		
		Window.out.color("white");
		Window.out.print(score1, 50, 100);
		
		Window.out.color("white");
		Window.out.print(score2, 750, 100);
	}
	public void move() {
		x = x + dx;
		y = y + dy;
		score();
	}
	
	public void score() {
		if(x < 10) {
			x = 400;
			y = 300;
			dx = 10;
			dy = 4;
			countdown = true;
			score2++;
			
		}
		if(x > Window.width() - 10) {
			x = 400;
			y = 300;
			dx = -10;
			dy = 4;
			countdown = true;
			score1++;
		}
		if(y < 10) {
			y = 10;
			dy = -dy;
		}
		if(y > Window.height() - 10) {
			y = Window.height() - 10;
			dy = -dy;
		}
	}
	public boolean startCountdown() {
		if(countdown = true) {
			
		}
		return false;
	}
	public boolean isTouching(Paddle p) {
		if(Math.abs(x - p.x) < 10 && Math.abs(y- p.y) < 50) {
			return true;
		}
		return false;
	}
	public void bounceHorizontally(Paddle p) {
		dx = -dx;
		dy = dy + (y - p.y) / 5;
	}
}