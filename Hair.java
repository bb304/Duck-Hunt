import java.awt.Color;
import java.awt.Graphics;
//declares variables
public class Hair {
private int mX = 175;
private int mY = 175;
private int diameter;
private int width;
private int height;
private int locX ;
private int locY;
private boolean hairCollision;
	
//set variables		
	public Hair(int x, int y, int d) {
			locX = x;
			locY = y;
			diameter = d;
	}
//draws cross hair where coursor is
	public void drawHair(Graphics g) {
			
		g.setColor(Color.RED);
		g.drawOval(locX, locY, diameter, diameter);
		g.drawLine(locX + diameter/2, locY, locX + diameter/2, locY + diameter);
		g.drawLine(locX,locY + diameter/2 ,locX + diameter , locY+ diameter/2);
			
	}
//keeps cursor centered on the crosshair	
	public void centerHair() {
		// TODO Auto-generated method stub
		locX = (getlocX()- (diameter/2));
		locY = (getlocY()-(diameter/2));
			
	}
		

		
		
//sets location of the x and y cords for the crosshair		
	public void setLocation(int x, int y) {
		locX = x;
		locY = y;
	}
//Sees if the duck is being shot		
	boolean hairCollision(int x, int y, int w, int h){
			 
		if(locX > x && locX < x + w) {
			if(locY > y && locY < y+h) {
				return true;
			}
		}
			
			
			return false;
			
			
	}
//keeps getting the x cord		
	public int getlocX() {
			return locX;
	}
//keeps getting the y cord	
	public int getlocY() {
			return locY;
	}
}


