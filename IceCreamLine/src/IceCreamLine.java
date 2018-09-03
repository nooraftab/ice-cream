/** This class represents the line at an ice-cream shop! It
 * generates random orders for ice-cream cones, using a queue
 * for the logic and the view of the cones!
 *
 * @author NoorAftab
 */

import java.util.Random;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import java.awt.Container;

public class IceCreamLine extends JPanel {

	//variable to hold a queue of ice-cream logics
	private QueueLL<IceCreamConeModel> orderLine;

	//variable to hold a queue of ice-cream graphics
	private QueueLL<IceCreamConeView> orderLineView;

	/** constructor sets a box layout in our panel,
	 * and instantiates our queues
	 */
	public IceCreamLine () {

		//sets a vertical box layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//instantiates variables
		orderLine = new QueueLL<>();
		orderLineView = new QueueLL<>();

	}

	/** 
	 * adds an ice-cream cone, with a randomized selection of
	 * ice-cream scoop flavors, to the line!
	 */
	public void addRandomOrder () {

		//local variable to hold a cone (will have scoops added to it!)
		IceCreamConeModel tempCone = new IceCreamConeModel();

		Random rand = new Random();

		//we don't want more than 3 scoops on our cones!
		int val = rand.nextInt(3); 

		//loops for as many number of times the generator decided and
		for (int i = 0; i <= val; i++) {

			//adds a random flavor scoop
			tempCone.addScoop();

		}

		//adds created ice-cream cone to model queue
		orderLine.enqueue(tempCone);

		//adds view of the cone to it's view queue
		IceCreamConeView view = new IceCreamConeView(tempCone);
		orderLineView.enqueue(view);

		//adds cone to the GUI
		add(view);
		validate();

	}

	/** removes cone at front of the queue (meaning it's been served)
	 * so that the next order can be served!
	 *
	 * @return returns the logic of the cone (essentially,
	 * the flavors it contains)
	 */
	public IceCreamConeModel serveNextOrder () {

		//safety check to make sure there are cones in the line to remove
		if (!orderLineView.isEmpty()) {  //only need to check one!

			IceCreamConeView view = orderLineView.dequeue();

			//removes GUI component
			remove(view);
			validate();

			//returns model by removing it at the same time!
			return orderLine.dequeue();

		}

		return null;

	}

}