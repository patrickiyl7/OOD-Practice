package assignment2;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RestaurantTest {

  private String restaurantName = "A";
  private Address address = new Address("C", "D", "E", "F", "G");
  private Menu menu = new Menu(Arrays.asList("a", "v", "n"), Arrays.asList("h", "b", "x"),
      Arrays.asList("p", "b", "v"), Arrays.asList("c", "j", "s"));
  private Boolean openOrClosed = true;
  private String expectedRestaurantName = "A";
  private Address expectedAddress = new Address("C", "D", "E", "F", "G");
  private Menu expectedMenu = new Menu(Arrays.asList("a", "v", "n"), Arrays.asList("h", "b", "x"),
      Arrays.asList("p", "b", "v"), Arrays.asList("c", "j", "s"));
  private Boolean expectedOpenOrClosed = true;
  private Restaurant restaurant;
  private final String notRestaurantClass = "This object belongs to String Class not Restaurant Class";

  @Before
  public void setUp() throws Exception {
    restaurant = new Restaurant(restaurantName, address, menu, openOrClosed);
  }

  @Test
  public void getRestaurantName() {
    Assert.assertEquals(restaurant.getRestaurantName(), expectedRestaurantName);
  }

  @Test
  public void setRestaurantName() {
    restaurant.setRestaurantName(restaurantName);
    Assert.assertEquals(restaurant.getRestaurantName(), expectedRestaurantName);
  }

  @Test
  public void getAddress() {
    Assert.assertEquals(restaurant.getAddress(), expectedAddress);
  }

  @Test
  public void setAddress() {
    restaurant.setAddress(address);
    Assert.assertEquals(restaurant.getAddress(), expectedAddress);
  }

  @Test
  public void getMenu() {
    Assert.assertEquals(restaurant.getMenu(), expectedMenu);
  }

  @Test
  public void setMenu() {
    restaurant.setMenu(menu);
    Assert.assertEquals(restaurant.getMenu(), expectedMenu);
  }

  @Test
  public void getOpenOrClosed() {
    Assert.assertEquals(restaurant.getOpenOrClosed(), expectedOpenOrClosed);
  }

  @Test
  public void setOpenOrClosed() {
    restaurant.setOpenOrClosed(openOrClosed);
    Assert.assertEquals(restaurant.getOpenOrClosed(), expectedOpenOrClosed);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(restaurant.equals(restaurant));
    Restaurant restaurantTest = new Restaurant("B", address, menu, openOrClosed);
    Assert.assertFalse(restaurant.equals(restaurantTest));
    Assert.assertEquals(
        new Restaurant(restaurantName, address, menu, openOrClosed),
        new Restaurant(restaurantName, address, menu, openOrClosed));
    Assert.assertFalse(restaurant.equals(null));
    Assert.assertFalse(restaurant.equals(notRestaurantClass));
  }

  @Test
  public void testHashCode() {
    assertEquals(restaurant.hashCode(),
        new Restaurant(restaurantName, address, menu, openOrClosed).hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "Restaurant{" +
        "restaurantName='" + restaurantName + '\'' +
        ", address=" + address +
        ", menu=" + menu +
        ", openOrClosed=" + openOrClosed +
        '}';
    Assert.assertEquals(restaurant.toString(), expectedString);
  }
}