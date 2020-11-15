import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientInfoTest {

  private ClientInfo clientInfo;
  private final String firstName = "James";
  private final String lastName = "Butt";
  private final String companyName = "Benton, John B Jr";
  private final String address = "6649 N Blue Gum St";
  private final String city = "New Orleans";
  private final String county = "Orleans";
  private final String state = "LA";
  private final String zip = "70116";
  private final String phonePrimary = "504-621-8927";
  private final String phoneSecondary = "504-845-1427";
  private final String email = "jbutt@gmail.com";
  private final String web = "http://www.bentonjohnbjr.com";
  private final String expectedFirstName = "James";
  private final String expectedLastName = "Butt";
  private final String expectedCompanyName = "Benton, John B Jr";
  private final String expectedAddress = "6649 N Blue Gum St";
  private final String expectedCity = "New Orleans";
  private final String expectedCounty = "Orleans";
  private final String expectedState = "LA";
  private final String expectedZip = "70116";
  private final String expectedPhonePrimary = "504-621-8927";
  private final String expectedPhoneSecondary = "504-845-1427";
  private final String expectedEmail = "jbutt@gmail.com";
  private final String expectedWeb = "http://www.bentonjohnbjr.com";


  @Before
  public void setUp() throws Exception {
    clientInfo = new ClientInfo(firstName, lastName, companyName, address, city, county, state, zip, phonePrimary, phoneSecondary, email, web);
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals(clientInfo.getFirstName(), expectedFirstName);
  }

  @Test
  public void setFirstName() {
    clientInfo.setFirstName(firstName);
    Assert.assertEquals(clientInfo.getFirstName(), expectedFirstName);
  }

  @Test
  public void getLastName() {
    Assert.assertEquals(clientInfo.getLastName(), expectedLastName);
  }

  @Test
  public void setLastName() {
    clientInfo.setFirstName(lastName);
    Assert.assertEquals(clientInfo.getLastName(), expectedLastName);
  }

  @Test
  public void getCompanyName() {
    Assert.assertEquals(clientInfo.getCompanyName(), expectedCompanyName);
  }

  @Test
  public void setCompanyName() {
    clientInfo.setCompanyName(companyName);
    Assert.assertEquals(clientInfo.getCompanyName(), expectedCompanyName);
  }

  @Test
  public void getAddress() {
    Assert.assertEquals(clientInfo.getAddress(), expectedAddress);
  }

  @Test
  public void setAddress() {
    clientInfo.setAddress(address);
    Assert.assertEquals(clientInfo.getAddress(), expectedAddress);
  }

  @Test
  public void getCity() {
    Assert.assertEquals(clientInfo.getCity(), expectedCity);
  }

  @Test
  public void setCity() {
    clientInfo.setCity(city);
    Assert.assertEquals(clientInfo.getCity(), expectedCity);
  }

  @Test
  public void getCounty() {
    Assert.assertEquals(clientInfo.getCounty(), expectedCounty);
  }

  @Test
  public void setCounty() {
    clientInfo.setCounty(county);
    Assert.assertEquals(clientInfo.getCounty(), expectedCounty);
  }

  @Test
  public void getState() {
    Assert.assertEquals(clientInfo.getState(), expectedState);
  }

  @Test
  public void setState() {
    clientInfo.setState(state);
    Assert.assertEquals(clientInfo.getState(), expectedState);
  }

  @Test
  public void getZip() {
    Assert.assertEquals(clientInfo.getZip(), expectedZip);
  }

  @Test
  public void setZip() {
    clientInfo.setZip(zip);
    Assert.assertEquals(clientInfo.getZip(), expectedZip);
  }

  @Test
  public void getPhonePrimary() {
    Assert.assertEquals(clientInfo.getPhonePrimary(), expectedPhonePrimary);
  }

  @Test
  public void setPhonePrimary() {
    clientInfo.setPhonePrimary(phonePrimary);
    Assert.assertEquals(clientInfo.getPhonePrimary(), expectedPhonePrimary);
  }

  @Test
  public void getPhoneSecondary() {
    Assert.assertEquals(clientInfo.getPhoneSecondary(), expectedPhoneSecondary);
  }

  @Test
  public void setPhoneSecondary() {
    clientInfo.setPhoneSecondary(phoneSecondary);
    Assert.assertEquals(clientInfo.getPhoneSecondary(), expectedPhoneSecondary);
  }

  @Test
  public void getEmail() {
    Assert.assertEquals(clientInfo.getEmail(), expectedEmail);
  }

  @Test
  public void setEmail() {
    clientInfo.setEmail(email);
    Assert.assertEquals(clientInfo.getEmail(), expectedEmail);
  }

  @Test
  public void getWeb() {
    Assert.assertEquals(clientInfo.getWeb(), expectedWeb);
  }

  @Test
  public void setWeb() {
    clientInfo.setWeb(web);
    Assert.assertEquals(clientInfo.getWeb(), expectedWeb);
  }
}