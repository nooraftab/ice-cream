/** This class handles the view of our ice cream cone - it creates the graphics for the cone and the
 * paints the flavor scoops depending on what information is passed into it from the controller!
 *
 * @author NoorAftab
 */

import javax.swing.JComponent;
import java.awt.Graphics;

import java.awt.Color;

public class IceCreamConeView extends JComponent {

	//constants for the dimensions of our cone
	public static final int CONE_WIDTH = 40;
	public static final int CONE_HEIGHT = 80;

	//constants for the overlap and dimensions of our scoop
	public static final int SCOOP_OVERLAP = 15;
	public static final int SCOOP_DIAMETER = 60;

	//variable to hold our model (logic of the program)
	private IceCreamConeModel model;

	/** our constructor for IceCreamConeView
	 *
	 * @param model a passed in IceCreamConeModel that instantiates
	 *        our instance variable model
	 */
	public IceCreamConeView (IceCreamConeModel model) {

		this.model = model;

	}

	/** paints our cone and our ice-cream scoops!
	 *
	 * @param g allows graphics to be drawn
	 */
	public void paint (Graphics g) {

		paintCone(g);

		paintFlavorScoops(g);

	}

	/** paints our ice cream cone! **/
	private void paintCone (Graphics g) {   

		//sets the cone to have a lovely beige tone
		g.setColor (new Color(238, 207, 161));

		//x and y variables to help determine the coordinaates of the triangle
		int baseX = getWidth()/2;
		int baseY = getHeight();

		//array of x coordinates of the triangle
		int[] xVals = {baseX, baseX - CONE_WIDTH/2, baseX + CONE_WIDTH/2 };

		//array of y coordinates of the triangle
		int[] yVals = {baseY, baseY - CONE_HEIGHT, baseY - CONE_HEIGHT};

		//creates a 3-sided polygon using the above coordinate arrays!
		g.fillPolygon (xVals, yVals, 3);


	}

	/** paints our flavored ice-cream scoops! **/
	private void paintFlavorScoops (Graphics g) {

		//variable to hold the model's stack of flavors
		StackLL<Integer> flavorStack = model.getFlavorStack();

		//temporary stack (to hold an inversed flavorStack)
		StackLL<Integer> tempStack = new StackLL<>();

		//transfers values from flavorStack to tempStack (in reverse order)
		while (!flavorStack.isEmpty()) {

			int index = flavorStack.pop(); //gets top index from flavorStack

			tempStack.push(index); //pushes that index into tempStack

		}

		//x-coordinate for our scoops (doesn't change)
		int x = getWidth()/2 - SCOOP_DIAMETER/2;

		//y-coordinate for our scoops (is incremented)
		int y = getHeight() - CONE_HEIGHT - SCOOP_DIAMETER + SCOOP_OVERLAP;

		//displays all the flavor scoops in the proper order
		while (!tempStack.isEmpty()) {

			int index = tempStack.pop();

			//for strawberry, a lovely pink color
			if (index == 0) {

				g.setColor(new Color (255, 181, 197));

			}

			//for mango, a dazzling yellow-orange
			else if (index == 1) {

				g.setColor (new Color (255, 165, 0));

			}

			//for chocolate, a cozy brown
			else if (index == 2) {

				g.setColor (new Color (139, 69, 19));

			}

			//for pistachio, a calming green 
			else if (index == 3) {

				g.setColor (new Color (180, 238, 180));

			}

			//creates the circle of the scoop
			g.fillOval(x, y, SCOOP_DIAMETER, SCOOP_DIAMETER);

			//pushes stolen flavor indices back to flavorStack
			flavorStack.push(index);

			//increments y-value for the next ice-cream scoop!
			y = y - SCOOP_DIAMETER + SCOOP_OVERLAP;

		}

	}

}