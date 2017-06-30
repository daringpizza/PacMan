package ctf;

import apcs.Window;

public class Flag  extends Thing {

	String color;
	public Flag(String name) {
		super(name);
	}
	
	public void draw() {
		Window.out.color(name);
		Window.out.square(getX(), getY(), 25);
	}
	
	public void contactWith(Thing other) {
		if(other instanceof Player) {
			Player p = (Player) other;
			if(! p.color.equals(name)) {
				set(p.getX(), p.getY());
				if(p.isSafe()) {
					reset();
				}
			}
		}
	}
	private void reset() {
		if (name.equals("red")) {
			set(50, 250);
		} else {
			set(950,250);
		}
	}
}
