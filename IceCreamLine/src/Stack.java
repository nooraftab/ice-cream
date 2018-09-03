/** This is the Stack interface that specifies operations a stack should have! 
 *
 * @author NoorAftab
 * @param T the data type of the stack
 */

public interface Stack<T> {

	/**
	 * 'pushes' an element to the top of the stack.
	 * @param data the data of the element
	 */
	public void push( T data );
 
	/**
	 * removes the top of the stack and returns the data.
	 * @return the popped data
	 */
	public T pop();
 
	/** 
	 * getter method for the element at the top of the stack
	 * @return the peeked data
	 */
	public T peek();
 
	/** 
	 * checks if there's nothing in the stack
	 * @return true if the stack is empty
	 */
	public boolean isEmpty();
 
	/** 
	 * converts the stack into a string representation 
	 * @return stack as String
	 */
	public String toString();
	
}