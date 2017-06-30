import apcs.Window;
public class Square extends Circle {
	public void draw() {
		Window.out.color("yellow");
		Window.out.square(0, 0, 10);
	}
}
