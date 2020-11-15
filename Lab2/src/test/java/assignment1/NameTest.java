package assignment1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NameTest {

  private String firstName = "A";
  private String midName = "B";
  private String lastName = "C";
  private String expectedFirstName = "A";
  private String expectedMidName = "B";
  private String expectedLastName = "C";
  private Name name;
  private final String notNameClass = "This object belongs to String Class not Name Class";

  @Before
  public void setUp() throws Exception {
    name = new Name(firstName, midName, lastName);
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals(name.getFirstName(), expectedFirstName);
  }

  @Test
  public void setFirstName() {
    name.setFirstName(firstName);
    Assert.assertEquals(name.getFirstName(), expectedFirstName);
  }

  @Test
  public void getMidName() {
    Assert.assertEquals(name.getMidName(), expectedMidName);
  }

  @Test
  public void setMidName() {
    name.setMidName(midName);
    Assert.assertEquals(name.getMidName(), expectedMidName);
  }

  @Test
  public void getLastName() {
    Assert.assertEquals(name.getLastName(), expectedLastName);
  }

  @Test
  public void setLastName() {
    name.setLastName(lastName);
    Assert.assertEquals(name.getLastName(), expectedLastName);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(name.equals(name));
    Assert.assertEquals(new Name(firstName, midName, lastName),
        new Name(firstName, midName, lastName));
    Assert.assertFalse(name.equals(null));
    Assert.assertFalse(name.equals(notNameClass));
  }

  @Test
  public void testHashCode() {
    assertEquals(name.hashCode(), new Name(firstName, midName, lastName).hashCode());

  }

  @Test
  public void testToString() {
    String expectedString = "Name{" +
        "firstName='" + firstName + '\'' +
        ", midName='" + midName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
    Assert.assertEquals(name.toString(), expectedString);
  }
}