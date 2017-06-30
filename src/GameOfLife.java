import apcs.Window;
public class GameOfLife {
	private static final int width = 50;
	private static final int height = 50;
	private static final int scale = 10;
	
	public static void main(String[] args) {
		Window.size(width*scale, height * scale);
		boolean[][] world = new boolean[width][height];
			while(true) {
				Window.frame();
				
				draw(world);
				world = next(world);
				if(Window.mouse.clicked()) {
					editAtMouse(world);
				}
				while(Window.key.pressed("space") == false) {
					if(Window.mouse.clicked() == true) {
						editAtMouse(world);
						Window.frame();
						draw(world);
				}
			}
		}
	}
	private static boolean[][] next(boolean[][] world) {
		boolean[][] nextWorld = new boolean[width][height];
			
			for(int x = 0; x < width ; x++) {
				for(int y = 0; y < height; y++) {
					int count = neighbors(world, x, y);
					
					if(world[x][y]) {
						//lonely
						if(count < 2) nextWorld[x][y] = false;
						//survival
						if(count == 2 || count == 3) nextWorld[x][y] = true;
						//crowded
						if(count > 3) nextWorld[x][y] = false;
						
					} else {
						//It's Alive!!!
						if(count == 3) nextWorld[x][y] = true;
						
					}
				}
			}
		
		return nextWorld;
	}
	private static int neighbors(boolean[][] world, int x, int y) {
		int count = 0;
		if(x != 0 && world[x - 1][y]) {
			count++;
		}
		if(x != 0 && y != 0 && world[x - 1][y - 1]) {
			count++;
		}
		if(x != 0 && y != height - 1 && world[x - 1][y + 1]) {
			count++;
		}
		if(x != width - 1 && y != 0 && world[x + 1][y - 1]) {
			count++;
		}
		if(y != 0 && world[x][y - 1]) {
			count++;
		}
		if(x != width - 1 && y !=  height - 1 && world[x + 1][y + 1]) {
			count++;
		}
		if(x != width - 1 && world[x + 1][y]) {
			count++;
		}
		if(x != 0 && y != height - 1 && world[x][y + 1]) {
			count++;s
		}
		return count;
	}
	private static void editAtMouse(boolean[][] world) {
		int x = Window.mouse.getX() / scale;
		int y = Window.mouse.getY() / scale;
		
		if(world[x][y] = false){
			insert(world, x, y);
		} else {
			delete(world, x, y);
		}
	}
	
	private static void insert(boolean[][] world, int x, int y) {
		world[x][y] = true;
	}
	
	
	private static void delete(boolean[][] world, int x, int y) {
		world[x][y] = false;
	}
	
	private static void draw(boolean[][] world) {
		Window.out.background("white");
		Window.out.color("black");
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				if(world[x][y]) {
					Window.out.square(x*scale, y*scale, scale);
				}
			}
		}
	
	}
}
