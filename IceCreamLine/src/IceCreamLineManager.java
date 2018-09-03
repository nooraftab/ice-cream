/** This class creates a GUI to manipulate our IceCreamLine! 
 * We can add orders to the line, as well as remove them. :)
 *
 * @author NoorAftab
 */

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IceCreamLineManager extends JFrame implements ActionListener {

	//variable to hold an ice-cream line
	private IceCreamLine line;

	//variables for our adding/removing buttons
	private JButton addButton, serveButton;

	/** constructor instantiates our ice-cream line and
	 * creates the GUI view of the line
	 */
	public IceCreamLineManager() {

		line = new IceCreamLine();

		createLineView();

	}

	/** 
	 * creates the GUI view of a line of ice-cream cones
	 */
	private void createLineView() {

		//creates and adds our add/remove buttons to the jframe
		createButtons();

		//adds our ice-cream line to the center of the frame
		add(line, BorderLayout.CENTER);

		//sets up our jframe
		setSize(400, 500);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * creates our JButtons and adds them to a JPanel
	 * to the north of the JFrame
	 */
	private void createButtons () {

		//instantiates a subpanel and gives it a grid layout
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new GridLayout(2, 1));

		//creates our add and serve buttons
		addButton = new JButton ("Add a Random Order");
		serveButton = new JButton("Serve the Next Order");

		//adds action listeners to the buttons so that when we click them, stuff happens
		addButton.addActionListener(this);
		serveButton.addActionListener(this);

		//adds our buttons to the subpanel
		subPanel.add(addButton);
		subPanel.add(serveButton);

		//adds our panel of buttons to the north of the frame
		add(subPanel, BorderLayout.NORTH);

	}

	/** sets up code to be executed when a button is
	 * is clicked
	 *
	 * @param ae an action event e.g. a button being pressed
	 */
	public void actionPerformed (ActionEvent ae) {

		//adds a randomized ice-cream cone to the line
		if (ae.getSource() == addButton) {

			line.addRandomOrder();

		}

		//removes or 'serves' the first ice-cream cone from the line
		else if (ae.getSource() == serveButton) {

			line.serveNextOrder();

		}

		//updates the view of the line
		repaint();

	}

}