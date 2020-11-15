package assignment1.problem1;

import static org.junit.Assert.*;

import javax.smartcardio.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardOwnerTest {

  private CardOwner jane;

  @Before
  public void setUp() throws Exception {
    this.jane = new CardOwner("Jane", "Doe", "j@a.com", "222 Main St, Seattle, WA, 98980");
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals("Jane", this.jane.getFirstName());

  }

  @Test
  public void setFirstName() {
  }

  @Test
  public void getLastName() {
    Assert.assertEquals("Doe", this.jane.getLastName());
  }

  @Test
  public void setLastName() {
  }

  @Test
  public void getEmail() {
    Assert.assertEquals("j@a.com", this.jane.getEmail());
  }

  @Test
  public void setEmail() {
  }

  @Test
  public void getAddress() {
    Assert.assertEquals("222 Main St, Seattle, WA, 98980", this.jane.getAddress());
  }

  @Test
  public void setAddress() {
  }
}