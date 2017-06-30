package ctf;
import java.util.ArrayList;


import apcs.Window;
public class CaptureTheFlag {
	public static void main(String[] args) {
		Window.size(1000, 500);
		Window.mesh.join("10.1.10.30");
		ArrayList<Thing> things = new ArrayList <Thing> ();
	
		Player mithil = new Player("mithil", "red");
		mithil.set(250, 250);
		things.add(mithil);
		things.add( new Player ("keshav", "red") );
		things.add( new Player ("alexander", "red") );
		things.add( new Player ("ved", "red") );
		things.add( new Player ("aum", "red") );
		things.add( new Player ("daya", "red") );
		things.add( new Player ("mithil", "blue") );
		things.add( new Player ("xander", "blue") );
		things.add( new Player ("colin", "blue") );
		things.add( new Player ("ben", "blue") );
		things.add( new Player ("riya", "blue") );
		
		things.add(new Flag("red") );
		things.add(new Flag("blue") );
		
		while(true) {
			Window.frame();
			drawBackground();
			mithil.moveWithKey();
			
			for(Thing t : things) {
				t.draw();
				t.update();
				
				
				if(t != mithil && t.isTouching(mithil)) {
					t.contactWith(mithil);
					
				}
			}
		}
	}
	private static void drawBackground() {
		Window.out.background("green");
		Window.out.color("white");
		Window.out.line(500, 0, 500, 500);
		
	}
}
