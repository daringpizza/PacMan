import apcs.Window;
public class Circle {
	public boolean isClicked(){
		if(Window.mouse.clicked() &&
			Math.abs(x - Window.mouse.getX())< 20 &&
			Math.abs(y - Window.mouse.getY()) < 20) {
			return true;
		}
		return false;
	}
	int x;
	int y;
	
	public void draw() {
	Window.out.color("red");
	Window.out.circle(x, y, 20);;	
	}
	public void moveToMouse() {
		x = Window.mouse.getX();
		y = Window.mouse.getY();
	}
}
