/** This class creates the GUI for our ice-cream shop, as well as some of
 * the logic needed for the program!
 *
 * Help was taken to make a multiline JLabel from:
 * https://stackoverflow.com/questions/685521/multiline-text-in-jlabel
 *
 * @author NoorAftab
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IceCreamShop extends JFrame implements ActionListener {

	//variable declaration for our ice-cream line and maker
	private IceCreamLine iceCreamLine;
	private IceCreamMaker iceCreamMaker;

	//variables for our needed JButtons
	private JButton serveButton, addConeButton;

	//variables for scoring 
	private JLabel scoreLabel;
	private int scoreCount;

	/**
	 * constructor instantiates our ice-cream line and maker 
	 * and creates the GUI view of the shop
	 */
	public IceCreamShop() {

		iceCreamLine = new IceCreamLine();
		iceCreamMaker = new IceCreamMaker();

		createShopView();

	}

	/**
	 * this method creates the GUI view of the shop
	 */
	private void createShopView () {

		//panel contains score labels and the serve order button
		addServePanel();

		//adds an addCone button to the ice-cream line panel
		addConeButton = new JButton("Add New Order!");
		addConeButton.addActionListener(this);
		iceCreamLine.add(addConeButton);

		//adds our ice-cream line and ice-cream maker to the frame
		add(iceCreamLine, BorderLayout.WEST);
		add(iceCreamMaker, BorderLayout.CENTER);

		//sets up our frame to be seen and used
		setSize(600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	/** 
	 * creates a panel containing scores and a serve
	 * next order button. adds the panel to the north
	 * of the frame
	 */
	private void addServePanel() {

		//sets up our panel to have a grid layout
		JPanel servePanel = new JPanel();
		servePanel.setLayout(new GridLayout (3, 1));

		//strings to help us make our instructions JLabel
		String line1 = new String("Create cones that match the earliest order (at the top of the line)!");
		String line2 = new String ("Use the flavor buttons to add ice-cream scoops~");
		String line3 = new String ("Correctly matching the orders gives you 10 points! :D");
		String line4 = new String ("Giving the wrong order results in 5 points off and an unhappy customer!");

		//creates a label for instructions and adds it to our panel (adapted from internet)
		JLabel instructions = new JLabel("<html>"+line1 + "<br>" + line2 + "<br>" + line3 + "<br>" + line4 + "<html>");
		servePanel.add(instructions);

		//creates our score label and adds it to the panel
		scoreLabel = new JLabel("Score: " + scoreCount);
		servePanel.add(scoreLabel);

		//creates and sets up our serve button, adds it to our panel
		serveButton = new JButton("Serve the Next Order!");
		servePanel.add(serveButton);
		serveButton.addActionListener(this);

		//finally, adds our panel to the north of the frame
		add(servePanel, BorderLayout.NORTH);


	}

	/** this method is called when the serve button is clicked.
	 * it increments/decrements the score depending if the user
	 * created a matching cone, and then resets the maker
	 */
	private void serveToCustomer() {

		//gets the model of the cone in the line
		IceCreamConeModel customersCone = iceCreamLine.serveNextOrder();

		//gets the model of the cone currently made by the user
		IceCreamConeModel createdCone = iceCreamMaker.getCurrentCone();

		//safety check to make sure neither cone is null
		if (customersCone != null && createdCone != null) {

			//increases score if the two cones are identical
			if (conesMatch(customersCone, createdCone)) {

				scoreCount += 10;
			
			}

			//decreases score if the user created a cone that doesn't match
			else {

				scoreCount -= 5;

			}

			//updates the text of the score label to show changes in the score
			scoreLabel.setText("Score: " + scoreCount); 

		}

		//resets the maker to an ice-cream cone with no scoops on top of it
		iceCreamMaker.resetMaker();

	}

	/** 
	 * checks if the stacks of two passed-in cones are
	 * equal (returns true if they are!)
	 */
	private boolean conesMatch (IceCreamConeModel lineCone, IceCreamConeModel createdCone) {

		//gets the stack of integers of the two cone models
		StackLL<Integer> lineConeStack = lineCone.getFlavorStack();
		StackLL<Integer> createdConeStack = createdCone.getFlavorStack();

		//converts the two stacks to strings
		String lineConeString = lineConeStack.toString();
		String createdConeString = createdConeStack.toString();

		//checks if the strings of the two stacks are equal
		if (lineConeString.equals(createdConeString)) {

			return true;

		} 

		return false;

	}

	/** this method sets up code to be executed when certain buttons are
	 * clicked
	 *
	 * @param ae an action event (here, a button being pressed)
	 */
	public void actionPerformed (ActionEvent ae) {

		//serves the customer their ice-cream cone 
		if (ae.getSource() == serveButton) {

			serveToCustomer();

		}

		//adds another random order to the ice-creamline 
		else if (ae.getSource() == addConeButton) {

			iceCreamLine.addRandomOrder();

		}

		//updates the GUI view
		repaint();

	}

}