/** This class creates a queue (and it's associated methods) using a LinkedList!
 *
 * @author NoorAftab
 * @param T a passed in data type the elements in the queue should have
 */


public class QueueLL<T> implements Queue<T> {

	//variable to hold our linked list
	private LinkedList<T> list;

	/**
	 * constructor instantiates our list
	 */
	public QueueLL () {

		list = new LinkedList<>();

	}

	/** adds an element to the back of the queue
	 *
	 * @param data the data we want our added element to have
	 */
	public void enqueue (T data) {

		list.add(list.size(), data);

	}

	/** removes the element at the front of the queue
	 *
	 * @return returns data of the removed element
	 */ 
	public T dequeue () {

		T data = list.get(0);

		list.delete(0);

		return data;
		

	}

	/** lets us look at the data of the element at the 
	 * front of the queue without removing it!
	 *
	 * @return data of the element at the front
	 */
	public T peek () {

		return list.get(0);

	}

	/** checks if there are no elements in the queue
	 *
	 * @return true if the queue is empty
	 */
	public boolean isEmpty() {

		return list.isEmpty();

	}

	/** converts our queue to a string 
	 *
	 * @return a string representation of our queue
	 */
	public String toString() {

		return list.toString();

	}

}