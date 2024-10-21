import java.awt.Color;
import java.awt.Graphics;
//declares variables
public class Duck {
private boolean border;
private Color brown = new Color(102, 51, 0);
private int locX;
private int locY;
private int diameter;
boolean fall;

//sets variables
	public Duck(int x, int y) {
		locX = x;
		locY= y;		
		border = false;
		fall = false;
	}
//draws duck	
	public void drawDuck(Graphics g) {
		g.setColor(brown);
		g.fillRect(locX, locY, 75, 40);
		
	}
//tells fall to be true so duck can fall	
	public void gotHit() {
		fall = true;
	}
//tells fall to be false if the duck is still alive	
	public boolean isAlive() {
		return !fall;
	}
//Moves duck and decides if the duck will fall or if it will go back and forth	
	public void borderCheck(){
		if (fall == false) {
			if(locX<=0) {
				border=true;
			}
			if(locX>= 925) {
				border = false;
			}
			if(border == true) {
				locX++;
			}
			if(border == false) {
				locX--;
			}
		}
		if (fall == true) {
			locY= locY+5;
		}
	}
//tells what locX is equal to	
	public int getlocX() {
		return locX;
	}
//tells what locY is equal to 	
	public int getlocY() {
		return locY;
	}
}
