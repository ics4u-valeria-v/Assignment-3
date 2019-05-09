import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RandomWalkGuess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * 
	 */
	static int color1;
	int shapeMain;
	int width, height;
    int colorTarget;
    int dotColour;
    int targetX, targetY;
    int dotX, dotY;
    int frameW, frameH;
    int guess_;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomWalkGuess frame = new RandomWalkGuess(color1, color1, color1, color1, color1, color1, color1, color1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param guess 
	 * @param dot_color 
	 * @param color 
	 * @param shape 
	 * @param targetHeight 
	 * @param targetWidth 
	 * @param frameHeight 
	 * @param frameWidth 
	 */
	public RandomWalkGuess(int frameWidth, int frameHeight, int targetWidth, int targetHeight, int shape, int color, int dot_color, int guess) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, frameWidth, frameHeight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//drawing the target
				shapeMain = shape;
				width = targetWidth;
				height = targetHeight;
				colorTarget = color;
				dotColour = dot_color;
				frameW = frameWidth;
				frameH = frameHeight;
				guess_ = guess;
				
				int maxX = frameWidth - (targetWidth+10);
				int minX = 0 + (targetWidth+10);
				targetX = (int)(Math.random() * ((maxX - minX) + 1)) + minX;
				
				int minY = 0 + (targetHeight+10);
				int maxY = frameHeight - (targetHeight+10);
				targetY = (int)(Math.random() * ((maxY - minY) + 1)) + minY;
				
				//set dots position
				FindDotX( minX,  maxX, targetWidth, minY, maxY, targetHeight);
				
	}
	
	public void FindDotX(int minX, int maxX, int targetWidth, int minY, int maxY, int targetHeight)
	{
		//Find x position of the first dot
		dotX = (int)(Math.random() * ((maxX - minX) + 1)) + minX;	
		//Find y position of the first dot
				dotY =(int)(Math.random() * ((maxY - minY) + 1)) + minY;
		//if the dot has the same position as the object
		while(dotX <= targetX+targetWidth && dotX >= targetX-6 && dotY <= targetY+targetHeight && dotY >= targetY-6)
		{
			dotX = (int)(Math.random() * ((maxX - minX) + 1)) + minX;	
			dotY =(int)(Math.random() * ((maxY - minY) + 1)) + minY;
		}
	}
	
	public void paint(Graphics g){
		//create 
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
		
		//create the shape
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
				g.setColor(new Color(255, 0, 0));
			}
			else if (dotColour == 2)
			{
				g.setColor(new Color(255, 255, 0));
			}
			else if (dotColour == 3)
			{
				g.setColor(new Color(0, 255, 0));
			}
			else if (dotColour == 4)
			{
				g.setColor(new Color(0, 0, 255));
			}
			//create the object/dot
			g.fillOval(dotX, dotY, 10, 10);
			
			int counter = 1;
			
			for (int count = 1; count <= guess_; count ++)
			{
				//pick randomly where should the object move
				int position = (int)(Math.random() * ((4 - 1) + 1)) + 1;
				//move the object right
				if (position == 1)
				{ 
					if (dotX >= frameW )
					{
						dotX = dotX - 5;
						g.fillOval(dotX, dotY, 10, 10);
					}
					else
					{
						dotX = dotX + 5;
						g.fillOval(dotX, dotY, 10, 10);
					}
					
				}
				//move the object left
				else if (position == 2)
				{
					if (dotX <= 0)
					{
						dotX = dotX + 5;
						g.fillOval(dotX, dotY, 10, 10);
					}
					else
					{
						dotX = dotX - 5;
						g.fillOval(dotX, dotY, 10, 10);
					}
					
				}
				//move the object up
				else if (position == 3)
				{
					if (dotY >= frameH)
					{
						dotY = dotY-5;
						g.fillOval(dotX, dotY, 10, 10);
					}
					else
					{
						dotY = dotY+5;
						g.fillOval(dotX, dotY, 10, 10);
					}
				}
				//move the object up
				else if (position == 4)
				{
					if (dotY <= 0)
					{
						dotY = dotY+5;
						g.fillOval(dotX, dotY, 10, 10);
					}
					else
					{
						dotY = dotY-5;
						g.fillOval(dotX, dotY, 10, 10);
					}
				}
				
				//change the color gradually
				if (counter == 1)//SUPER LIGHT COLORS
				{
					//set the color of the dot based on the color that the user picked
					if (dotColour == 1)
					{
						g.setColor(new Color(255, 204, 204));
					}
					else if (dotColour == 2)
					{
						g.setColor(new Color(255,255,153));
					}
					else if (dotColour == 3)
					{
						g.setColor(new Color(204, 255, 153));
					}
					else if (dotColour == 4)
					{
						g.setColor(new Color(204, 229, 255));
					}
				}
				else if (counter == 2) //LIGHT COLOR
				{
					//set the color of the dot based on the color that the user picked
					if (dotColour == 1)
					{
						g.setColor(new Color(255, 102, 102));
					}
					else if (dotColour == 2)
					{
						g.setColor(new Color(255,255,89));
					}
					else if (dotColour == 3)
					{
						g.setColor(new Color(153, 255, 51));
					}
					else if (dotColour == 4)
					{
						g.setColor(new Color(102, 178, 255));
					}
				}
				else if (counter == 3) //BASIC COLOR
				{
					//set the color of the dot based on the color that the user picked
					if (dotColour == 1)
					{
						g.setColor(new Color(255, 0, 0));
					}
					else if (dotColour == 2)
					{
						g.setColor(new Color(255,255,0));
					}
					else if (dotColour == 3)
					{
						g.setColor(new Color(0, 255, 0));
					}
					else if (dotColour == 4)
					{
						g.setColor(new Color(0, 0, 255));
					}
				}
				else if (counter == 4) //DARKER COLOR
				{
					//set the color of the dot based on the color that the user picked
					if (dotColour == 1)
					{
						g.setColor(new Color(204, 0, 0));
					}
					else if (dotColour == 2)
					{
						g.setColor(new Color(218,206,37));
					}
					else if (dotColour == 3)
					{
						g.setColor(new Color(0, 153, 0));
					}
					else if (dotColour == 4)
					{
						g.setColor(new Color(0, 0, 153));
					}
				}
				else if (counter == 5) //DARKER COLOR
				{
					//set the color of the dot based on the color that the user picked
					if (dotColour == 1)
					{
						g.setColor(new Color(102, 0, 0));
					}
					else if (dotColour == 2)
					{
						g.setColor(new Color(176,165,23));
					}
					else if (dotColour == 3)
					{
						g.setColor(new Color(25, 51, 0));
					}
					else if (dotColour == 4)
					{
						g.setColor(new Color(0, 0, 51));
					}
				}
			
				//make a pause
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (counter == 5)
				{
					counter = 1;
				}
				else
				{
					counter ++;
				}
				
				//check if they hit the boundary
				if ((dotX <= targetX+width && dotX >= targetX-5 && dotY <= targetY+height && dotY >= targetY-5))
				{
					//if the user entered something different than an integer, display a warning message
					JOptionPane.showMessageDialog(null,"You guessed it right","Random Generator Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			
			if ((dotX <= targetX+width && dotX >= targetX-5 && dotY <= targetY+height && dotY >= targetY-5))
			{
				//if the user entered something different than an integer, display a warning message
				JOptionPane.showMessageDialog(null,"You guessed it right","Random Generator Warning",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				//if the user entered something different than an integer, display a warning message
				JOptionPane.showMessageDialog(null,"You didn't guess correctly","Random Generator Warning",JOptionPane.WARNING_MESSAGE);
			}
	   }
}
