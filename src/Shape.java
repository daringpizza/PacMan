import apcs.Window;
public class Shape {
	int x;
	int y;
	
	public Shape() {
		
	}
	public void draw() {
		Window.out.color("red");
		Window.out.circle(x, y, 10);
	}
	
	public boolean isClicked() {
		if(Window.mouse.clicked() &&
				Math.abs(x - Window.mouse.getX())< 20 &&
				Math.abs(y - Window.mouse.getY()) < 20) {
			return true;
		}
		return false;
	}
}
