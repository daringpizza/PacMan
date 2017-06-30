package snakeGame;

import apcs.Window;

public class SnakeGame {
	public static void main(String[] args) {
		Snake head = new Snake(250,250);
		Foodzies yummy = new Foodzies(0, 0);
		while(true) {
			Window.frame();
			head.draw();
			head.move();
			head.control();
			yummy.draw();
			if(Window.key.pressed("space")) {
				head.grow();
			}
		}
	}
}
