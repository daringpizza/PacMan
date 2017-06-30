package fallingSand;

import apcs.Window;

public class FallingSand {
	public static void main(String[] args) {
		int[][] world = new int[500][500];
		
		while(true) {
			Window.frame();
			draw(world);
			world = next(world);
			
			if(Window.mouse.clicked()) {
				
				for(int i=0;i<10; i++) {
					int x = Window.mouse.getX() + Window.random(-11, 10);
					int y = Window.mouse.getY() + Window.random(-11, 10);
					if(x >= 0 && x <500 && y >= 0 && y < 500) {
						world[x][y] = 1;
					}
				}				
			}
		}
	}

	private static int[][] next(int[][] world) {
		//int[][] nextWorld = new int[500][500];
		
		for (int x=0;x<500;x++) {
			for (int y=499;y>=0;y--) {
				if(world[x][y] == 0) {
					if(y>0 && world[x][y-1] != 0) {
						world[x][y] = world[x][y-1];
						world[x][y-1] = 0;
					}
					else if (x > 0 && world[x - 1][y] != 0 && Math.random() < 0.1) {
                        world[x][y] = 1;
                        world[x - 1][y] = 0;
                    }
                    else if (x < 499 && world[x + 1][y] != 0 && Math.random() < 0.1) {
                        world[x][y] = 1;
                        world[x + 1][y] = 0;
                    }
				} else {
					
				}
			}
		}
		return world;
	}

	private static void draw(int[][] world) {
		Window.out.background("black");
		
		for(int x = 0; x< 500; x++) {
			for(int y = 0; y<500; y++) {
				if(world[x][y] == 1) {
					Window.out.color("tan");
                    Window.out.square(x, y, 1);
				}
			}
		}
	}
}
