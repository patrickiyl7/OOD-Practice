package assignment2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MenuTest {

  private List<String> meals = Arrays.asList("a", "b", "c");
  private List<String> desserts = Arrays.asList("e", "d", "c");
  private List<String> beverages = Arrays.asList("z", "k", "c");
  private List<String> drinks = Arrays.asList("s", "v", "c");
  private List<String> expectedMeals = Arrays.asList("a", "b", "c");
  private List<String> expectedDesserts = Arrays.asList("e", "d", "c");
  private List<String> expectedBeverages = Arrays.asList("z", "k", "c");
  private List<String> expectedDrinks = Arrays.asList("s", "v", "c");
  private Menu menu;
  private final String notMenuClass = "This object belongs to String Class not Menu Class";

  @Before
  public void setUp() throws Exception {
    menu = new Menu(meals, desserts, beverages, drinks);
  }

  @Test
  public void getMeals() {
    Assert.assertEquals(menu.getMeals(), expectedMeals);
  }

  @Test
  public void setMeals() {
    menu.setMeals(meals);
    Assert.assertEquals(menu.getMeals(), expectedMeals);
  }

  @Test
  public void getDesserts() {
    Assert.assertEquals(menu.getDesserts(), expectedDesserts);
  }

  @Test
  public void setDesserts() {
    menu.setDesserts(desserts);
    Assert.assertEquals(menu.getDesserts(), expectedDesserts);
  }

  @Test
  public void getBeverages() {
    Assert.assertEquals(menu.getBeverages(), expectedBeverages);
  }

  @Test
  public void setBeverages() {
    menu.setBeverages(beverages);
    Assert.assertEquals(menu.getBeverages(), expectedBeverages);
  }

  @Test
  public void getDrinks() {
    Assert.assertEquals(menu.getDrinks(), expectedDrinks);
  }

  @Test
  public void setDrinks() {
    menu.setDrinks(drinks);
    Assert.assertEquals(menu.getDrinks(), expectedDrinks);
  }

  @Test
  public void testToString() {
    String expectedString = "Menu{" +
        "meals=" + meals +
        ", desserts=" + desserts +
        ", beverages=" + beverages +
        ", drinks=" + drinks +
        '}';
    Assert.assertEquals(menu.toString(), expectedString);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(menu.equals(menu));
    Menu menuTest = new Menu(Arrays.asList("s", "b", "c"), desserts, beverages, drinks);
    Assert.assertFalse(menu.equals(menuTest));
    Assert.assertEquals(
        new Menu(meals, desserts, beverages, drinks),
        new Menu(meals, desserts, beverages, drinks));
    Assert.assertFalse(menu.equals(null));
    Assert.assertFalse(menu.equals(notMenuClass));
  }

  @Test
  public void testHashCode() {
    assertEquals(menu.hashCode(),
        new Menu(meals, desserts, beverages, drinks).hashCode());
  }
}