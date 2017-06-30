package ctf;

import apcs.Window;

public abstract class Thing {
	int x = 0;
	int y = 0;
	String name;
	String xKey;
	String yKey;
	public Thing(String name) {
		this.name = name;
		xKey = name + "x";
		yKey = name + "y";
	}
	public void update() {
		x = Window.mesh.read(xKey);
		y = Window.mesh.read(yKey);
	}
	public void push() {
		Window.mesh.write(xKey, x);
		Window.mesh.write(yKey, y);
	}
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
		push();
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
		push();
	}	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
		push();
	}
	
	public boolean isTouching(Thing other) {
		double distance = Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y-other.y, 2));
		
		return distance <= 20;
	}
	
	public void moveWithKey() {
		update();
		
		if(Window.key.pressed("right") && x < Window.width()) {
			x = x + 10;
		}
		if(Window.key.pressed("left") && x > 0) {
			x = x - 10;
		}
		if(Window.key.pressed("up") && y > 0) {
			y = y - 10;
		}
		if(Window.key.pressed("down") && y < Window.height()) {
			y = y + 10;
		}
		if(Window.key.pressed("space")) {
			x = 770;
			y = 300;
		}
		
		push();
	}
	public abstract void draw();
	public abstract void contactWith(Thing other);
}
