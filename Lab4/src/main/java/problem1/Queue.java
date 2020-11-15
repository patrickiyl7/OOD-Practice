package problem1;

/**
 * Describes an immutable problem1.Queue ADT.
 * @param <E> The data type to store in the ADT.
 */
public interface Queue<E> {

  /**
   * Adds an element to the queue.
   * @param element The element to add.
   * @return A new problem1.Queue with the element added.
   */
  Queue enqueue(E element);


  /**
   * Removes the least recently added element.
   * @return A new problem1.Queue with element removed.
   */
  Queue<E> dequeue();


  /**
   * Returns but does not remove the least recently added element.
   * @return The element at the front of the problem1.Queue.
   */
  E front();
}