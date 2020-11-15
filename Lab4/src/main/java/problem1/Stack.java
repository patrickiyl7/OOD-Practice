package problem1;

/**
 * Describes an immutable problem1.Stack ADT.
 * @param <E> The data type to store in the problem1.Stack.
 */
public interface Stack<E> {

  /**
   * Pushes an element on to the problem1.Stack
   * @param element The element to add to the problem1.Stack.
   * @return A new problem1.Stack with the new element added.
   */
  Stack push(E element);


  /**
   * Removes the most recently added element.
   * @return A new problem1.Stack without the most recently added element.
   */
  Stack remove();


  /**
   * Returns, but does not remove, the most recently added element.
   * @return The most recently added element.
   */
  E top();
}
