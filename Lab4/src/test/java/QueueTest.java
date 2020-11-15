import org.junit.Assert;
import org.junit.Test;
import problem1.Queue;

public class QueueTest {
  private Queue queue;
  @Test
  public void enqueue() {
    if(queue == null)
    {
      return;
    }
    this.queue = this.queue.enqueue(1);
    Assert.assertEquals(queue.front(), 1);
    this.queue = this.queue.enqueue(2);
    Assert.assertEquals(queue.front(), 2);
  }

  @Test
  public void dequeue() {
    if(queue == null)
    {
      return;
    }
    this.queue = this.queue.enqueue(1);
    this.queue = this.queue.enqueue(2);
    Assert.assertEquals(queue.front(), 1);
    this.queue = this.queue.dequeue();
    Assert.assertEquals(queue.front(), 2);
  }

  @Test
  public void front() {
    this.queue = this.queue.enqueue(1);
    this.queue = this.queue.enqueue(2);
    Assert.assertEquals(queue.front(), 1);
  }
}