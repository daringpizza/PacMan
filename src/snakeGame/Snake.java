package snakeGame;
import apcs.Window;
public class Snake {
	int x = Window.width() / 2;
	int y = Window.height() /2;
	
	int dx = 0;
	int dy = 0;
	
	Snake next;
	public Snake(int x, int y) {
		this.x = x;
		this.y = y;
		this.dx = 0;
		this.dy = 0;
	}
	public Snake(int x, int y, int dx, int dy) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
	}
	
	public void grow() {
		if(next != null) {
			next.grow();
		} else {
			next = new Snake(this.x - this.dx, this.y - this.dy, this.dx, this.dy);
		}
	}
	
	public void draw() {
		Window.out.color("red");
		Window.out.square(x, y, 10);
		
		if(next !=null) {
			next.draw();
		}
	}
	public void move() {
		x += dx;
		y += dy;
		
			if(next !=null) {
				next.move();
				
				next.dx = dx;
				next.dy = dy;
			}
	}
	public void control() {
		if(Window.key.pressed("up")) {
			dy = -10;
			dx = 0;
		}
		if(Window.key.pressed("down")) {
			dy = 10;
			dx = 0;
		}
		if(Window.key.pressed("left")) {
			dx = -10;
			dy = 0;
		}
		if(Window.key.pressed("right")) {
			dx = 10;
			dy = 0;
		}
	}
}
