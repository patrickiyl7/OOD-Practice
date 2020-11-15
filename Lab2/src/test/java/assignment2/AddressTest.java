package assignment2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {

  private String streetAndNumber = "A";
  private String city = "B";
  private String zipCode = "C";
  private String state = "D";
  private String country = "E";
  private String expectedStreetAndNumber = "A";
  private String expectedCity = "B";
  private String expectedZipCode = "C";
  private String expectedState = "D";
  private String expectedCountry = "E";
  private Address address;
  private final String notAddressClass = "This object belongs to String Class not Address Class";

  @Before
  public void setUp() throws Exception {
    address = new Address(streetAndNumber, city, zipCode, state, country);
  }

  @Test
  public void getStreetAndNumber() {
    Assert.assertEquals(address.getStreetAndNumber(), expectedStreetAndNumber);
  }

  @Test
  public void setStreetAndNumber() {
    address.setStreetAndNumber(streetAndNumber);
    Assert.assertEquals(address.getStreetAndNumber(), expectedStreetAndNumber);
  }

  @Test
  public void getCity() {
    Assert.assertEquals(address.getCity(), expectedCity);
  }

  @Test
  public void setCity() {
    address.setCity(city);
    Assert.assertEquals(address.getCity(), expectedCity);
  }

  @Test
  public void getZipCode() {
    Assert.assertEquals(address.getZipCode(), expectedZipCode);
  }

  @Test
  public void setZipCode() {
    address.setZipCode(zipCode);
    Assert.assertEquals(address.getZipCode(), expectedZipCode);
  }

  @Test
  public void getState() {
    Assert.assertEquals(address.getState(), expectedState);
  }

  @Test
  public void setState() {
    address.setState(state);
    Assert.assertEquals(address.getState(), expectedState);
  }

  @Test
  public void getCountry() {
    Assert.assertEquals(address.getCountry(), expectedCountry);
  }

  @Test
  public void setCountry() {
    address.setCountry(country);
    Assert.assertEquals(address.getCountry(), expectedCountry);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(address.equals(address));
    Assert.assertEquals(
        new Address(streetAndNumber, city, zipCode, state, country),
        new Address(streetAndNumber, city, zipCode, state, country));
    Assert.assertFalse(address.equals(null));
    Assert.assertFalse(address.equals(notAddressClass));
  }

  @Test
  public void testHashCode() {
    assertEquals(address.hashCode(),
        new Address(streetAndNumber, city, zipCode, state, country).hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "Address{" +
        "streetAndNumber='" + streetAndNumber + '\'' +
        ", city='" + city + '\'' +
        ", zipCode='" + zipCode + '\'' +
        ", state='" + state + '\'' +
        ", country='" + country + '\'' +
        '}';
    Assert.assertEquals(address.toString(), expectedString);
  }
}