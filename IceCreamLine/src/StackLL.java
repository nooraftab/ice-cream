/** This class creates a Stack using LinkedLists! It also defines how it's operations should
 * work, using the Stack interface!
 *
 * @author NoorAftab
 * @param T the data type of the stack!
 */

public class StackLL<T> implements Stack<T> {

	//variable to hold our linked list (which we'll use for this stack!)
	private LinkedList<T> list;

	/** constructor instantiates the linked list variable **/
	public StackLL () { 

		list = new LinkedList<>();

	}

	/** adds data to the head of our list
	 *
	 * @param data a passed in piece of data (maybe a string or int!)
	 */
	public void push (T data) {

		list.add(0, data);

	}

	/** returns and removes data from the top of the stack
	 * (or the head of the list)
	 *
	 * @return the removed data
	 */
	public T pop () {

		//gets data
		T indexData = list.get(0);

		//deletes that data!
		list.delete(0);
		
		return indexData;

	}

	/** allows us to see what data is at the top of the stack
	 *
	 * @return data at head of the list
	 */
	public T peek () {

		return list.get(0);

	}

	/** checks if there are any elements in our stack
	 * 
	 * @return true is list is empty
	 */
	public boolean isEmpty() {

		return list.isEmpty();

	}

	/** gives us our list as a string!
	 *
	 * @return string representation of our stack
	 */
	public String toString() {  

		return list.toString();  

	}

}
