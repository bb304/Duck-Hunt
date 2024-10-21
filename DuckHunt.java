import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

//declares variables
public class DuckHunt extends JPanel implements MouseMotionListener, ActionListener, MouseListener  {
private Timer timer = new Timer(10,this);
private JFrame frame = new JFrame("Duck Hunt");
private Container can = frame.getContentPane();
private Color sky = new Color(5, 240, 240);
private int counter;
private String sleep = new String("You uh... Put the ducks to sleep! Yeah, put them to sleep! Nice!");
private ImageIcon bg = new ImageIcon("duckHunt_Logo.jpg"); 
private Image background = bg.getImage(); 


private JLabel jlabel = new JLabel("Welcome to Duck Hunt! Have Fun, and take 'em down");
Hair hair = new Hair(500, 325, 25);
Duck duck[] = new Duck[7];



//main class finds ducks and adds listeners
	public DuckHunt() {
		
		
		can.add(this);
		setPreferredSize(new Dimension(1000,650));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		duck[0] = new Duck((int)((950 - 55 +1) * Math.random() + 55),(int)((500 - 55 +1) * Math.random() + 55));
		duck[1] = new Duck((int)((950 - 55 +1) * Math.random() + 55),(int)((500 - 55 +1) * Math.random() + 55));
		duck[2] = new Duck((int)((950 - 55 +1) * Math.random() + 55),(int)((500 - 55 +1) * Math.random() + 55));
		duck[3] = new Duck((int)((950 - 55 +1) * Math.random() + 55),(int)((500 - 55 +1) * Math.random() + 55));
		duck[4] = new Duck((int)((950 - 55 +1) * Math.random() + 55),(int)((500 - 55 +1) * Math.random() + 55));
		duck[5] = new Duck((int)((950 - 55 +1) * Math.random() + 55),(int)((500 - 55 +1) * Math.random() + 55));
		duck[6] = new Duck((int)((950 - 55 +1) * Math.random() + 55),(int)((500 - 55 +1) * Math.random() + 55));
		
		timer.start();
		counter = 0;
		can.add(jlabel, BorderLayout.NORTH);
		
		addMouseMotionListener(this);
		addMouseListener(this);
	
		
		
		frame.setCursor(frame.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null"));
		
		
		
		frame.pack();
		frame.setVisible(true);
		
	}

	
//draws scene and other classes	
	public void paintComponent(Graphics g) {
		g.setColor(sky);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.GREEN);
		g.fillOval(-50, 575, 400, 200);
		g.fillOval(275, 575, 400, 200);
		g.fillOval(625, 575, 400, 200);
		g.setColor(Color.WHITE);
		g.fillOval(0, 100, 100, 100);
		g.fillOval(50, 55, 100, 100);
		g.fillOval(110, 55, 100, 100);
		g.fillOval(160, 100, 100, 100);
		g.fillOval(110, 145, 100, 100);
		g.fillOval(50, 145, 100, 100);
		g.fillOval(50, 100, 100, 100);
		
		g.fillOval(400, 100, 100, 100);
		g.fillOval(450, 55, 100, 100);
		g.fillOval(510, 55, 100, 100);
		g.fillOval(560, 100, 100, 100);
		g.fillOval(510, 145, 100, 100);
		g.fillOval(450, 145, 100, 100);
		g.fillOval(450, 100, 100, 100);
		//duck drawing
		g.drawImage(background, 15, 15, this);
		for(int i =0; i < 7; i++) {
		duck[i].drawDuck(g);
		}
		g.setColor(Color.BLACK);
		Font myFont = new Font ("Courier New", 1, 19);
		g.setFont (myFont);
		g.drawString (counter + " ducks uh... put to sleep!", 500, 325);
		//crosshair drawing
		hair.drawHair(g);
		
	}
	
	
	
	
//prints out code	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DuckHunt();
	}


//machine gun bird destroyer
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//puts hair on mouse
		hair.setLocation(e.getX(), e.getY());
		//put cursor in the center of 
		hair.centerHair();
		mouseClicked(e);
	}

//moves crosshair
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		hair.setLocation(e.getX(), e.getY());
		hair.centerHair();
		repaint();
	}


//makes ducks move with timer
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if (source == timer) {
			for(int i =0; i < 7; i++) {
				duck[i].borderCheck();
			}
		}
		repaint();
	}


//single shot duck shooter
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<7; i++) {
			if(duck[i].isAlive() && hair.hairCollision(duck[i].getlocX(), duck[i].getlocY(), 75, 40)) {
				duck[i].gotHit();
				//add to jtext to update score
				counter++;
				jlabel.setText(counter + " Ducks Uh... put to sleep!");
				if (counter >= 7) {
					jlabel.setText(sleep);
					frame.pack();
					
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();
					new DuckHunt();
				}
			}
		}
		
		
		repaint();
	}


//nothing
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


//nothing
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


//nothing
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


//nothing
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
