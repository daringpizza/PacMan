package duckhunt;
import apcs.Window;
public class DuckHunt {
	public static void main(String[] args) {
		Duck[] ducks = new Duck[20];
		
		for (int index = 0; index < 20; index++) {
			ducks[index] = new Duck();
		}
		while(true) {
			Window.frame();
			
			for(int index = 0 ; index < 20; index++) {
				Duck d = ducks[index];
				d.draw();
				//d.move();
			}
		}
	}
}