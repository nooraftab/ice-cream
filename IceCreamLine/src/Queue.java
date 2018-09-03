/** This interface contains the methods a queue should have! 
 *
 * @author NoorAftab
 * @param T a passed in data type for the elements of the queue
 */

public interface Queue<T> {

	/** adds an elements to the end of the queue
	 *
	 * @param data a given piece of data we want the element to have!
	 */
	public void enqueue (T data);

	/** removes an element from the front of the queue
	 * and returns it's data
	 *
	 * @return the  data of the removed element
	 */
	public T dequeue();

	/** gets the data of the elements at the front 
	 * of the queue
	 *
	 * @return the data of front element
	 */
	public T peek();

	/** checks if there are any elements in the queue
	 *
	 * @return returns true if queue is empty
	 */
	public boolean isEmpty();

	/** converts our queue into a string
	 *
	 * @return a string representation of our queue
	 */
	public String toString();

	
}