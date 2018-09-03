/** **/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class IceCreamMaker extends JPanel implements ActionListener {

	//variables for our model and view
	private IceCreamConeModel model;
	private IceCreamConeView view;

	//JButton array for our 4 flavor buttons
	private JButton[] flavorButton;

	//variable for trash button
	private JButton trashButton;

	/** constructor instantiates model and view, and creates the GUI! **/
	public IceCreamMaker () {

		//instantiates model and view
		model = new IceCreamConeModel();
		view = new IceCreamConeView(model);

		//creates te GUI
		createConeMaker();

	}

	/** adds our flavor subpanel to the main panel, which is added to a jframe**/
	private void createConeMaker () {

		//sets a border layout
		setLayout(new BorderLayout());

		//puts our flavor panels to the north of the panel
		add(createFlavorButtonPanel(), BorderLayout.NORTH);

		//adds the JComponent ice-cream cone to the center 
		add(view, BorderLayout.CENTER);

		//creates a jfame and adds this jpanel to it
		//JFrame makerFrame = new JFrame();
		//makerFrame.setSize(500, 600);
		//makerFrame.add(this);

		//makes the program close when the frame is closed
		//makerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//allows frame to be seen
		//makerFrame.setVisible(true);

	}

	/** returns a panel contains our flavor and trash buttons **/
	private JPanel createFlavorButtonPanel () {

		//creates buttons for our 4 flavors
		createFlavorButtons();

		//creates a JPanel
		JPanel flavorPanel = new JPanel();

		//sets the subpanel to have a gridlayout w/ 4 columns
		flavorPanel.setLayout(new GridLayout(1,4));

		//loops through buttons to add to the subpanel
		for (int i = 0; i < flavorButton.length; i++) {

			flavorPanel.add(flavorButton[i]);

		}

		//creates a panel to encompass the flavor and trash buttons
		JPanel workerOptionsPanel = new JPanel();

		//sets it to have a gridlayout
		workerOptionsPanel.setLayout(new GridLayout(2, 0));

		//adds the flavor and trash buttons to it
		workerOptionsPanel.add(flavorPanel);
		workerOptionsPanel.add(createTrashButton());

		return workerOptionsPanel;

	}

	/** creates 4 JButtons for our 4 flavors **/
	private void createFlavorButtons () {

		//instantiates JButton array to make space for 4 buttons
		flavorButton = new JButton[4];

		//loops through the 4 buttons to instantiate them and do other actions
		for (int i = 0; i < flavorButton.length; i++) {

			flavorButton[i] = new JButton();

			//adds an action listener 
			flavorButton[i].addActionListener(this);

			//allows buttons to be given color
			flavorButton[i].setOpaque(true);
			flavorButton[i].setBorderPainted(false);

		}

		//personalizes strawberry button
		flavorButton[0].setText("strawberry");
		flavorButton[0].setBackground (new Color (255, 181, 197)); 

		//personalizes the mango button
		flavorButton[1].setText("mango");
		flavorButton[1].setBackground(new Color (255, 165, 0));	

		//personalizes the chocolate button
		flavorButton[2].setText("chocolate");
		flavorButton[2].setBackground(new Color (139, 69, 19));

		//personalizes the pistachio button
		flavorButton[3].setText("pistachio");
		flavorButton[3].setBackground(new Color(180, 238, 180));

	}

	/** creates and returns our trash button (in a seperate method for
	 * ease of implementing the subpanels
	 */
	private JButton createTrashButton () {

		//instantiates and sets the text
		trashButton = new JButton ("Boo! Trash the top scoop! >:(");

		//sets action listener and functions to allow colors
		trashButton.addActionListener(this);
		trashButton.setOpaque(true);
		trashButton.setBorderPainted(false);

		//sets color
		trashButton.setBackground(new Color (113, 113, 198));

		return trashButton;

	}

	public IceCreamConeModel getCurrentCone() {

		return model;

	}

	public void resetMaker() {

		remove(view);
		validate(); //needed?

		model = new IceCreamConeModel();
		view = new IceCreamConeView(model);

		add(view, BorderLayout.CENTER);
		validate(); //needed?
	}

	/** this method deals with when buttons are pressed, executing
	 * code if they are
	 * 
	 * @param e an action event (here, a button being clicked)
	 */
	public void actionPerformed (ActionEvent e) {

		//local variabel for ease of implementation
		JButton button = (JButton) e.getSource();

		//if flavor button clicked
		if (button != trashButton) {

			//adds a scoop of ice-cream of the flavor (from the text!)
			model.addScoop(button.getText());

		}

		//if the trash button is clicked
		else {

			//removes the latest scoop of ice-cream 
			model.popTopScoop();

		}

		//refreshes the view
		repaint();

	}

}