package assignment2;

import java.util.Objects;

public class Address {

  private String streetAndNumber;
  private String city;
  private String zipCode;
  private String state;
  private String country;

  public Address(String streetAndNumber, String city, String zipCode, String state,
      String country) {
    this.streetAndNumber = streetAndNumber;
    this.city = city;
    this.zipCode = zipCode;
    this.state = state;
    this.country = country;
  }

  public String getStreetAndNumber() {
    return streetAndNumber;
  }

  public void setStreetAndNumber(String streetAndNumber) {
    this.streetAndNumber = streetAndNumber;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Address)) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(getStreetAndNumber(), address.getStreetAndNumber()) &&
        Objects.equals(getCity(), address.getCity()) &&
        Objects.equals(getZipCode(), address.getZipCode()) &&
        Objects.equals(getState(), address.getState()) &&
        Objects.equals(getCountry(), address.getCountry());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getStreetAndNumber(), getCity(), getZipCode(), getState(), getCountry());
  }

  @Override
  public String toString() {
    return "Address{" +
        "streetAndNumber='" + streetAndNumber + '\'' +
        ", city='" + city + '\'' +
        ", zipCode='" + zipCode + '\'' +
        ", state='" + state + '\'' +
        ", country='" + country + '\'' +
        '}';
  }
}
