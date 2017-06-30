import apcs.Window;
public class ShapeWorld {
	public static void main(String[] args) {
		Circle c = new Circle();
		Circle c2 = new Circle();
		Square sq = new Square();
		//int dX = 10;
		//int dY = 10;
		
		while(true) {
			Window.frame();
			drawBackground();
			
			c.draw();
			c2.draw();	
			sq.draw();
			if(c.isClicked()) {
				c.moveToMouse();
			}
			if(Window.key.pressed("space")) {
				c2.moveToMouse();
			}
			if(Window.key.pressed("m")) {
				sq.moveToMouse();
			}
		}
		
	}
	private static void drawBackground() {
		Window.out.background("blue");
	}
}
