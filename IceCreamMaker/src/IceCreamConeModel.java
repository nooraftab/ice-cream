/** This class creates the model for our IceCreamCone! It handles the logic of adding/removing scoops and
 * of the flavours of said scoops.
 * 
 * @author NoorAftab
 */

import java.util.Random;

public class IceCreamConeModel {

	//variable for a stack of integers (our flavor indices)
	private StackLL<Integer> flavorStack; 

	/** class constructor, which instantiates our stack **/
	public IceCreamConeModel () {

		flavorStack = new StackLL<>();

	}

	/** a getter method for our stack of flavor indices!
	 *
	 * @return our stack of flavors
	 */
	public StackLL<Integer> getFlavorStack () {

		return flavorStack;

	}

	/** this method adds the corresponding flavor index depending on
	 * the flavor string passed into the function
	 *
	 * @param flavor a flavor (string)
	 */
	public void addScoop (String flavor) {

		//for strawberry, adds 0 to the stack
		if (flavor.equals("strawberry")) {

			flavorStack.push(0);

		}

		//for mango, adds 1 to the stack
		else if (flavor.equals("mango")) {

			flavorStack.push(1);

		}

		//for chocolate, adds 2 to the stack
		else if (flavor.equals("chocolate")) {

			flavorStack.push(2);

		}

		//for pistachio, adds 3 to the stack
		else if (flavor.equals("pistachio")) {

			flavorStack.push(3);

		}

	}

	/** adds a random flavor index to the stack (using a random number generator **/
	public void addScoop () {  

		Random rand = new Random();

		flavorStack.push(rand.nextInt(4));

	}

	/** removes the index at the top of the stack **/
	public void popTopScoop () {

		//makes sure the stack isnt empty when popping!
		if (!flavorStack.isEmpty()) {

			flavorStack.pop();

		}

	}

}