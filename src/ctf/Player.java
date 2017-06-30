package ctf;

import apcs.Window;

public class Player extends Thing {
	String color;
	public Player(String name, String color) {
		super(name);
		this.color = color;
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.circle(getX(), getY(), 10);
		Window.out.color("white");
		Window.out.print(name, getX(), getY());
	}
	public void contactWith(Thing other) {
		if(other instanceof Player) {
			Player p = (Player) other;
			if(isSafe() && ! color.equals(p.color) && ! p.isSafe()) {
				p.reset();
			}
		}
	}
	public boolean isSafe() {
		if(color.equals("red") && getX() < 500) {
			return true;
		}
		if(color.equals("blue") && getX() > 500) {
			return true;
		}
		return false;
	}
	public void reset() {
		if(color.equals("red")) {
			set(250,250);
		} else {
			set(800,250);
		}
		
	}
}
