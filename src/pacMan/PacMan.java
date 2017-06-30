package pacMan;
import apcs.Window;
public class PacMan {
	int x = 250;
	int y = 250;
	int mouth = 10;
	int dm = -2;
	
	public void mouthMove() {
		mouth += dm;
		if(mouth == 0 || mouth == 10) {
			dm = -dm;
		}
	}
	public void draw() {
		Window.out.color("yellow");
		Window.out.circle(x, y, 20);
		Window.out.color("black");
		Window.out.polygon(x,y,x+20,y-mouth,x-mouth,y+20);
	}
}
