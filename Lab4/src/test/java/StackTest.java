import org.junit.Assert;
import org.junit.Test;
import problem1.Stack;

public class StackTest {

  private Stack stack;

  @Test
  public void push() {
    this.stack = this.stack.push(1);
    Assert.assertEquals(stack.top(), 1);
  }

  @Test
  public void remove() {
    this.stack = this.stack.push(1);
    this.stack = this.stack.push(2);
    this.stack = this.stack.remove();
    Assert.assertEquals(stack.top(), 1);
  }

  @Test
  public void top() {
    this.stack = this.stack.push(1);
    Assert.assertEquals(stack.top(), 1);
  }
}