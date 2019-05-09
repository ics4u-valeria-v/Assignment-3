import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class RandomWalkSetting {

	private JFrame frmRandomWalkSetting;

	//declare global variables
	JSpinner spinFWidth = new JSpinner();
	JSpinner spinFHeight = new JSpinner();
	JSpinner spinTWidth = new JSpinner();
	JSpinner spinTHeight = new JSpinner();
	JRadioButton radRect = new JRadioButton("Rectangle");
	JRadioButton radCircle = new JRadioButton("Circle");
	JRadioButton radRed = new JRadioButton("");
	JRadioButton radYellow = new JRadioButton("");
	JRadioButton radGreen = new JRadioButton("");
	JRadioButton radBlue = new JRadioButton("");
	JRadioButton dotRed = new JRadioButton("");
	JRadioButton dotYellow = new JRadioButton("");
	JRadioButton dotGreen = new JRadioButton("");
	JRadioButton dotBlue = new JRadioButton("");	
	
	
	int frameWidth , frameHeight , targetWidth, targetHeight, shape, color, dot_color;
	private JTextField txtGuess;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomWalkSetting window = new RandomWalkSetting();
					window.frmRandomWalkSetting.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RandomWalkSetting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frmRandomWalkSetting = new JFrame();
		frmRandomWalkSetting.setTitle("Random Walk Setting");
		frmRandomWalkSetting.setBounds(100, 100, 240, 483);
		frmRandomWalkSetting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRandomWalkSetting.getContentPane().setLayout(null);
		
		//Create groups of buttons and add the buttons to the group
		ButtonGroup shapeBut = new ButtonGroup();
		shapeBut.add(radRect);
		shapeBut.add(radCircle);
		
		ButtonGroup targetColor = new ButtonGroup();
		targetColor.add(radBlue);
		targetColor.add(radGreen);
		targetColor.add(radYellow);
		targetColor.add(radRed);
		
		ButtonGroup dotColor = new ButtonGroup();
		dotColor.add(dotBlue);
		dotColor.add(dotGreen);
		dotColor.add(dotYellow);
		dotColor.add(dotRed);
		
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				//get the width and height of the target from the user
				targetWidth = (Integer) spinTWidth.getValue();
				targetHeight = (Integer) spinTHeight.getValue();
				
				//get the width and height of the frame
				frameWidth = (Integer) spinFWidth.getValue();
				frameHeight = (Integer)spinFHeight.getValue();
				
				//get the shape based on what radio button was selected
				if (radCircle.isSelected())
				{
					shape = 1;
					
				}
				else if (radRect.isSelected())
				{
					shape = 2;
				}
				else
				{
					shape = -1;
					//ask the user to pick a shape
					JOptionPane.showMessageDialog(null,"Warning: Choose a shape","Random Walk Warning",JOptionPane.WARNING_MESSAGE);
				}
				
				//get the color based on what radio button was selected
				if (radRed.isSelected())
				{
					color = 1;
					
				}
				else if (radYellow.isSelected())
				{
					color = 2;
				}
				else if (radGreen.isSelected())
				{
					color = 3;
				}
				else if (radBlue.isSelected())
				{
					color = 4;
				}
				else
				{
					shape = -1;
					//ask the user to pick a shape
					JOptionPane.showMessageDialog(null,"Warning: Choose a color","Random Walk Warning",JOptionPane.WARNING_MESSAGE);
				}
				
				//get the color based on what radio button was selected
				if (dotRed.isSelected())
				{
					dot_color = 1;
				}
				else if (dotYellow.isSelected())
				{
					dot_color = 2;
				}
				else if (dotGreen.isSelected())
				{
					dot_color = 3;
				}
				else if (dotBlue.isSelected())
				{
					dot_color = 4;
				}
				else
				{
					shape = -1;
					//ask the user to pick a shape
					JOptionPane.showMessageDialog(null,"Warning: Choose a color","Random Walk Warning",JOptionPane.WARNING_MESSAGE);
				}
				
				//convert the text from the text box
				try
				{
					int guess = Integer.parseInt(txtGuess.getText());
					if (guess == 0)
					{
						new RandomWalkMain(frameWidth, frameHeight, targetWidth, targetHeight, shape, color, dot_color).setVisible(true);
					}
					else
					{
						new RandomWalkGuess(frameWidth, frameHeight, targetWidth, targetHeight, shape, color, dot_color, guess).setVisible(true);
					}
				}
				catch (Exception e1)
				{
					new RandomWalkMain(frameWidth, frameHeight, targetWidth, targetHeight, shape, color, dot_color).setVisible(true);
				}
			}
		});
		btnApply.setBounds(8, 410, 89, 23);
		frmRandomWalkSetting.getContentPane().add(btnApply);
		
		JLabel lblFrame = new JLabel("Frame:");
		lblFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFrame.setBounds(10, 11, 46, 14);
		frmRandomWalkSetting.getContentPane().add(lblFrame);
		
		JLabel lblFWidth = new JLabel("Frame Width");
		lblFWidth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFWidth.setBounds(10, 36, 76, 14);
		frmRandomWalkSetting.getContentPane().add(lblFWidth);
		
		
		spinFWidth.setModel(new SpinnerNumberModel(200, 200, 800, 1));
		spinFWidth.setBounds(78, 33, 46, 20);
		frmRandomWalkSetting.getContentPane().add(spinFWidth);
		
		JLabel lblFHeight = new JLabel("Frame Height");
		lblFHeight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFHeight.setBounds(10, 64, 76, 14);
		frmRandomWalkSetting.getContentPane().add(lblFHeight);
		
		
		spinFHeight.setModel(new SpinnerNumberModel(200, 200, 800, 1));
		spinFHeight.setBounds(78, 61, 46, 20);
		frmRandomWalkSetting.getContentPane().add(spinFHeight);
		
		JLabel lblTarget = new JLabel("Target:");
		lblTarget.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTarget.setBounds(10, 89, 58, 14);
		frmRandomWalkSetting.getContentPane().add(lblTarget);
		
		JLabel lblTWidth = new JLabel("Target Width");
		lblTWidth.setBackground(new Color(0, 0, 128));
		lblTWidth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTWidth.setBounds(10, 114, 76, 14);
		frmRandomWalkSetting.getContentPane().add(lblTWidth);
		
		spinTWidth.setModel(new SpinnerNumberModel(20, 20, 100, 1));
		spinTWidth.setBounds(78, 108, 46, 20);
		frmRandomWalkSetting.getContentPane().add(spinTWidth);
		
		JLabel lblTHeight = new JLabel("Target Height");
		lblTHeight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTHeight.setBounds(10, 139, 76, 14);
		frmRandomWalkSetting.getContentPane().add(lblTHeight);
		
		spinTHeight.setModel(new SpinnerNumberModel(20, 20, 100, 1));
		spinTHeight.setBounds(78, 136, 46, 20);
		frmRandomWalkSetting.getContentPane().add(spinTHeight);
		
		JLabel lblTShape = new JLabel("Target Shape:");
		lblTShape.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTShape.setBounds(10, 164, 76, 14);
		frmRandomWalkSetting.getContentPane().add(lblTShape);
		
		radRect.setFont(new Font("Tahoma", Font.BOLD, 11));
		radRect.setBounds(10, 185, 89, 23);
		frmRandomWalkSetting.getContentPane().add(radRect);
		
		radCircle.setFont(new Font("Tahoma", Font.BOLD, 11));
		radCircle.setBounds(100, 185, 109, 23);
		frmRandomWalkSetting.getContentPane().add(radCircle);
		
		JLabel lblTColor = new JLabel("Target Color:");
		lblTColor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTColor.setBounds(10, 215, 76, 14);
		frmRandomWalkSetting.getContentPane().add(lblTColor);
		
		radRed.setFont(new Font("Tahoma", Font.BOLD, 11));
		radRed.setBounds(10, 236, 20, 23);
		frmRandomWalkSetting.getContentPane().add(radRed);
		
		JLabel red = new JLabel("");
		red.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\ICS4U\\Assignment 3\\Images\\RED.jpg"));
		red.setBounds(33, 239, 40, 17);
		frmRandomWalkSetting.getContentPane().add(red);
		
		
		radYellow.setFont(new Font("Tahoma", Font.BOLD, 11));
		radYellow.setBounds(100, 236, 20, 23);
		frmRandomWalkSetting.getContentPane().add(radYellow);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\ICS4U\\Assignment 3\\Images\\yellow.png"));
		label.setBounds(126, 239, 40, 17);
		frmRandomWalkSetting.getContentPane().add(label);
		
		radGreen.setFont(new Font("Tahoma", Font.BOLD, 11));
		radGreen.setBounds(10, 268, 20, 23);
		frmRandomWalkSetting.getContentPane().add(radGreen);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\ICS4U\\Assignment 3\\Images\\green.jpg"));
		label_1.setBounds(33, 270, 40, 17);
		frmRandomWalkSetting.getContentPane().add(label_1);
		
		radBlue.setFont(new Font("Tahoma", Font.BOLD, 11));
		radBlue.setBounds(100, 268, 20, 23);
		frmRandomWalkSetting.getContentPane().add(radBlue);
		
		JLabel blue = new JLabel("");
		blue.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\ICS4U\\Assignment 3\\Images\\blue.jpg"));
		blue.setBounds(126, 270, 40, 17);
		frmRandomWalkSetting.getContentPane().add(blue);
		
		JLabel lblDots = new JLabel("Dots:");
		lblDots.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDots.setBounds(10, 298, 58, 14);
		frmRandomWalkSetting.getContentPane().add(lblDots);
		dotRed.setFont(new Font("Tahoma", Font.BOLD, 11));
		dotRed.setBounds(10, 316, 20, 23);
		frmRandomWalkSetting.getContentPane().add(dotRed);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\ICS4U\\Assignment 3\\Images\\RED.jpg"));
		label_2.setBounds(33, 318, 40, 17);
		frmRandomWalkSetting.getContentPane().add(label_2);
		dotGreen.setFont(new Font("Tahoma", Font.BOLD, 11));
		dotGreen.setBounds(10, 346, 20, 23);
		frmRandomWalkSetting.getContentPane().add(dotGreen);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\ICS4U\\Assignment 3\\Images\\green.jpg"));
		label_3.setBounds(33, 348, 40, 17);
		frmRandomWalkSetting.getContentPane().add(label_3);
		dotYellow.setFont(new Font("Tahoma", Font.BOLD, 11));
		dotYellow.setBounds(100, 316, 20, 23);
		frmRandomWalkSetting.getContentPane().add(dotYellow);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\ICS4U\\Assignment 3\\Images\\yellow.png"));
		label_4.setBounds(126, 318, 40, 17);
		frmRandomWalkSetting.getContentPane().add(label_4);
		dotBlue.setFont(new Font("Tahoma", Font.BOLD, 11));
		dotBlue.setBounds(100, 346, 20, 23);
		frmRandomWalkSetting.getContentPane().add(dotBlue);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\ICS4U\\Assignment 3\\Images\\blue.jpg"));
		label_5.setBounds(126, 348, 40, 17);
		frmRandomWalkSetting.getContentPane().add(label_5);
		
		JLabel lblGuess = new JLabel("Guess:");
		lblGuess.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGuess.setBounds(10, 380, 58, 14);
		frmRandomWalkSetting.getContentPane().add(lblGuess);
		
		txtGuess = new JTextField();
		txtGuess.setBounds(67, 378, 86, 20);
		frmRandomWalkSetting.getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		 
	}
}
