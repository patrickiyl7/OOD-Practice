package assignment2;

import java.util.List;
import java.util.Objects;

public class Menu {

  private List<String> meals;
  private List<String> desserts;
  private List<String> beverages;
  private List<String> drinks;

  public Menu(List<String> meals, List<String> desserts, List<String> beverages,
      List<String> drinks) {
    this.meals = meals;
    this.desserts = desserts;
    this.beverages = beverages;
    this.drinks = drinks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Menu)) {
      return false;
    }
    Menu menu = (Menu) o;
    return Objects.equals(meals, menu.meals) &&
        Objects.equals(desserts, menu.desserts) &&
        Objects.equals(beverages, menu.beverages) &&
        Objects.equals(drinks, menu.drinks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meals, desserts, beverages, drinks);
  }

  public List<String> getMeals() {
    return meals;
  }

  public void setMeals(List<String> meals) {
    this.meals = meals;
  }

  public List<String> getDesserts() {
    return desserts;
  }

  public void setDesserts(List<String> desserts) {
    this.desserts = desserts;
  }

  public List<String> getBeverages() {
    return beverages;
  }

  public void setBeverages(List<String> beverages) {
    this.beverages = beverages;
  }

  public List<String> getDrinks() {
    return drinks;
  }

  public void setDrinks(List<String> drinks) {
    this.drinks = drinks;
  }

  @Override
  public String toString() {
    return "Menu{" +
        "meals=" + meals +
        ", desserts=" + desserts +
        ", beverages=" + beverages +
        ", drinks=" + drinks +
        '}';
  }
}
