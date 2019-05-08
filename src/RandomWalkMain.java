import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class RandomWalkMain extends JFrame {

	private JPanel contentPane;

	//declare global variables
	static int color1;
	int shapeMain;
	int width, height;
    int colorTarget;
    int dotColour;
    int targetX, targetY;
    int dotX, dotY;

	
	//create the object that connect with RandomWalkSetting
	RandomWalkSetting rndSetting = new RandomWalkSetting();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomWalkMain frame = new RandomWalkMain(color1, color1, color1, color1, color1, color1, color1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param color 
	 * @param shape 
	 * @param targetHeight 
	 * @param targetWidth 
	 * @param frameHeight 
	 * @param frameWidth 
	 * @param dot_color 
	 */
	public RandomWalkMain(int frameWidth, int frameHeight, int targetWidth, int targetHeight, int shape, int color, int dotColor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, frameWidth, frameHeight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 10, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//drawing the target
		shapeMain = shape;
		width = targetWidth;
		height = targetHeight;
		colorTarget = color;
		dotColour = dotColor;
		
		int maxX = frameWidth - (targetWidth+10);
		System.out.print("Max X "+ maxX+"\n");
		int minX = 0 + (targetWidth+10);
		System.out.print("Min X"+ minX +"\n");
		targetX = (int)(Math.random() * ((maxX - minX) + 1)) + minX;
		
		int minY = 0 + (targetHeight+10);
		System.out.print("Min Y"+ minY +"\n");
		int maxY = frameHeight - (targetHeight+10);
		System.out.print("Max Y "+ maxY+"\n");
		targetY = (int)(Math.random() * ((maxY - minY) + 1)) + minY;
		
		//set dots position
		FindDotX( minX,  maxX, targetWidth);
		FindDotY( minY, maxY, targetHeight);
		
		
	}
	
	public void FindDotX(int minX, int maxX, int targetWidth)
	{
		int min = minX;
		int max = maxX;
		int width = targetWidth;
		
		//Find x position of the first dot
		dotX = (int)(Math.random() * ((maxX - minX) + 1)) + minX;	
		System.out.println(dotX);
		System.out.println(targetX);
		//if the dot has the same position as the object
		while(dotX <= targetX+targetWidth && dotX >= targetX-targetWidth)
		{
			dotX = (int)(Math.random() * ((maxX - minX) + 1)) + minX;	
			System.out.print("inside 1"+ "\n");
			System.out.println(dotX);
			System.out.println(targetX);
		}
		
		
	}
	
	public void FindDotY(int minY, int maxY, int targetHeight)
	{
		
		int min = minY;
		int max = maxY;
		int height = targetHeight;
		//Find x position of the first dot
		dotY =(int)(Math.random() * ((maxY - minY) + 1)) + minY;
		System.out.println(dotY);
		System.out.println(targetY);
		//if the dot has the same position as the object
		while (dotY <= targetY+targetHeight && dotY >= targetY-targetHeight)
		{
			dotY =(int)(Math.random() * ((maxY - minY) + 1)) + minY;
			System.out.print("inside 2"+ "\n");	
			System.out.println(dotY);
			System.out.println(targetY);
		}
		
	}
	

	public void paint(Graphics g){
		
		//set the color based on the color that the user picked
		if (colorTarget == 1)
		{
			g.setColor(Color.red);
		}
		else if (colorTarget == 2)
		{
			g.setColor(Color.yellow);
		}
		else if (colorTarget == 3)
		{
			g.setColor(Color.green);
		}
		else if (colorTarget == 4)
		{
			g.setColor(Color.blue);
		}
		
		
		 if (shapeMain == 1)
		 {
			 g.fillOval(targetX, targetY, width, height); //FOR CIRCLE
		 }
		 else if (shapeMain == 2)
		 {
			 g.fillRect(targetX, targetY, width, height);
		 }
		 
		 
		//set the color of the dot based on the color that the user picked
			if (dotColour == 1)
			{
				g.setColor(Color.red);
			}
			else if (dotColour == 2)
			{
				g.setColor(Color.yellow);
			}
			else if (dotColour == 3)
			{
				g.setColor(Color.green);
			}
			else if (dotColour == 4)
			{
				g.setColor(Color.blue);
			}
			
			g.fillOval(dotX, dotY, 5, 5);
        
   }
}
