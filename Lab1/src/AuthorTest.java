import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Assert.*;
//import sun.jvm.hotspot.utilities.Assert;

public class AuthorTest {
  private Author jane;
  @org.junit.Before
  public void setUp() throws Exception {
    this.jane = new Author("Jane Doe", "j@a.com", "222 Main St, Seattle, WA, 98980");
  }
  @org.junit.Test
  public void getName() throws Exception {

    Assert.assertEquals("Jane Doe", this.jane.getName());
  }
  @org.junit.Test
  public void getEmail() throws Exception {
    Assert.assertEquals("j@a.com", this.jane.getEmail());
  }
  @org.junit.Test
  public void getAddress() throws Exception {
    Assert.assertEquals("222 Main St, Seattle, WA, 98980", this.jane.getAddress());
  }
}