package assignment2;

import java.util.Objects;

public class Restaurant {

  private String restaurantName;
  private Address address;
  private Menu menu;
  private Boolean openOrClosed;

  public Restaurant(String restaurantName, Address address, Menu menu, Boolean openOrClosed) {
    this.restaurantName = restaurantName;
    this.address = address;
    this.menu = menu;
    this.openOrClosed = openOrClosed;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public Boolean getOpenOrClosed() {
    return openOrClosed;
  }

  public void setOpenOrClosed(Boolean openOrClosed) {
    this.openOrClosed = openOrClosed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Restaurant)) {
      return false;
    }
    Restaurant that = (Restaurant) o;
    return Objects.equals(getRestaurantName(), that.getRestaurantName()) &&
        Objects.equals(getAddress(), that.getAddress()) &&
        Objects.equals(getMenu(), that.getMenu()) &&
        Objects.equals(getOpenOrClosed(), that.getOpenOrClosed());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getRestaurantName(), getAddress(), getMenu(), getOpenOrClosed());
  }

  @Override
  public String toString() {
    return "Restaurant{" +
        "restaurantName='" + restaurantName + '\'' +
        ", address=" + address +
        ", menu=" + menu +
        ", openOrClosed=" + openOrClosed +
        '}';
  }
}