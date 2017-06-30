package pacMan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import apcs.Window;

public class ReadWorld {
	static int[][] world;
	static int width;
	static int height;
	static int scale = 10;
	static int mouth = 10;
	static int dm = -2;
	static int score = 0;
	static int playerx;
	static int playery;
	static int rotation = 0;
	static boolean mania = false;
	public static void main(String[] args) {	

		loadWorld();
		
		Window.size(width * scale, height * scale);
		
		while(true) {
			Window.frame();
			draw();
			drawPlayer();
			movePlayer();
			mouthMove();
		}
	}
		
	private static void movePlayer() {
		int originalx = playerx;
		int originaly = playery;
		if(Window.key.pressed("up")) {
			 playery -= 3;
			 rotation = 1;
		}
		if(Window.key.pressed("down")) {
			 playery += 3;
			 rotation = 3;
		}
		if(Window.key.pressed("left")) {
			 playerx -= 3;
			 rotation = 0;
		}
		if(Window.key.pressed("right")) {
			 playerx += 3;
			 rotation = 2;
		}
		
		
		int x = playerx  / scale;
		int y = playery  / scale;
		
		if(world[x][y+1] == 1) {
			world[x][y+1] = 3;
			score++;
		}
		if(world[x+1][y+1] == 1) {
			world[x+1][y+1] = 3;
			score++;
		}
		if(world[x+1][y-1] == 1) {
			world[x+1][y-1] = 3;
			score++;
		}
		if(world[x][y+1] == 1) {
			world[x][y+1] = 3;
			score++;
		}
		if(world[x][y+1] == 1) {
			world[x][y+1] = 3;
			score++;
		}
		if(world[x-1][y+1] == 1) {
			world[x-1][y+1] = 3;
			score++;
		}
		if(world[x-1][y-1] == 1) {
			world[x-1][y-1] = 3;
			score++;
		}
		if(world[x-1][y] == 1) {
			world[x-1][y] = 3;
			score++;
		}
		if(world[x+1][y] == 1) {
			world[x+1][y] = 3;
			score++;
		}
		if(world[x+1][y] == 1) {
			world[x+1][y] = 3;
			score++;
		}
		if(world[x+1][y+1] == 1) {
			world[x+1][y+1] = 3;
			score++;
		}
		if(world[x+1][y-1] == 1) {
			world[x+1][y-1] = 3;
			score++;
		}
		if(world[x][y+1] == 0) {
			playerx = originalx;
			playery = originaly;
		}
		if(world[x][y+1] == 0) {
			playerx = originalx;
			playery = originaly;
		}
		if(world[x-1][y+1] == 0) {
			playerx = originalx;
			playery = originaly;
		}
		if(world[x-1][y-1] == 0) {
			playerx = originalx;
			playery = originaly;
		}
		if(world[x-1][y] == 0) {
			playerx = originalx;
			playery = originaly;
		}
		if(world[x+1][y] == 0) {
			playerx = originalx;
			playery = originaly;
		}
		if(playerx > Window.width()-30) {
			playerx = 45;
		}
		if(playerx < 30) {
			playerx = Window.width()-45;
		}
		
	}

	public static void mouthMove() {
		mouth += dm;
		if(mouth == 0 || mouth == 10) {
			dm = -dm;
		}
	}
	public static void drawPlayer() {
		if(rotation == 0) {
			Window.out.color("yellow");
			Window.out.circle(playerx, playery, scale*1.5);
			Window.out.color("black");
			Window.out.polygon(playerx,playery,playerx-15,playery-mouth,playerx-15,playery+mouth);
		} 
		if(rotation == 1) {
			Window.out.color("yellow");
			Window.out.circle(playerx, playery, scale*1.5);
			Window.out.color("black");
			Window.out.polygon(playerx,playery,playerx-mouth,playery-15,playerx+mouth,playery-15);
		}
		if(rotation == 2) {
			Window.out.color("yellow");
			Window.out.circle(playerx, playery, scale*1.5);
			Window.out.color("black");
			Window.out.polygon(playerx,playery,playerx+15,playery-mouth,playerx+15,playery+mouth);
		}
		if(rotation == 3) {
			Window.out.color("yellow");
			Window.out.circle(playerx, playery, scale*1.5);
			Window.out.color("black");
			Window.out.polygon(playerx,playery,playerx-mouth,playery+15,playerx+mouth,playery+15);
		}
	}

	private static void draw() {
		Window.out.background("black");
        for (int x = 0 ; x < width ; x++) {
            for (int y = 0 ; y < height ; y++) {
                if(world[x][y] == 0) {
                    Window.out.color("blue");
                    Window.out.square(x * scale + scale / 2, y * scale + scale / 2, scale);
                }
                if(world[x][y] == 1) {
                	Window.out.color("white");
                	Window.out.square(x*scale + scale/2, y*scale + scale/2, scale/5);
                }
                if(world[x][y] == 2) {
                	Window.out.color("white");
                	Window.out.circle(x*scale + scale/2, y*scale + scale/2, scale/2);
                }
                if(world[x][y] == 3) {
                    Window.out.color("black");
                    Window.out.square(x * scale + scale / 2, y * scale + scale / 2, scale);
                }
            }
            Window.out.color("white");
            Window.out.print("Score: " + score, 25 , Window.height() / 2 - 50);
        }		
	}

	private static void loadWorld() {
		File f = new File("grid.txt");
		try {
			Scanner s = new Scanner(f);
			
			ArrayList<String> lines = new ArrayList <String> ();
			
			while(s.hasNextLine()) {
				String line = s.nextLine();
				
				if(line.length() > 0) {
					lines.add(line);
				}
			}
			s.close();
			width = lines.get(0).length();
			height = lines.size();
			
			world = new int[width][height];
			
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					char c = lines.get(y).charAt(x);
					if(c == '.') {
						world[x][y] = 0;
					}
					if(c == ',') {
						world[x][y] = 3;
					}
					if(c == '/') {
						world[x][y] = 1;
					}
					if(c == '*') {
						world[x][y] = 2;
					}
				}
			}
			playerx = 31 * 10;
            playery = 35 * 10-5;
		}
		catch(FileNotFoundException e) {
			System.out.println("Could not find file.");
		}
	}
}
