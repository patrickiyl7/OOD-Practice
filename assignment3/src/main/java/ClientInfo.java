import java.util.Objects;

/**
 * A class to present the information of the client containing fields like firstName, lastName,
 * companyName, address, city, county, state, zip, phonePrimary, phoneSecondary, email, web.
 */
public class ClientInfo {

  private String firstName;
  private String lastName;
  private String companyName;
  private String address;
  private String city;
  private String county;
  private String state;
  private String zip;
  private String phonePrimary;
  private String phoneSecondary;
  private String email;
  private String web;

  /**
   * Constructor of client information class.
   *
   * @param firstName      firstName.
   * @param lastName       lastName.
   * @param companyName    companyName.
   * @param address        address.
   * @param city           city.
   * @param county         county.
   * @param state          state.
   * @param zip            zip.
   * @param phonePrimary   primary phone number.
   * @param phoneSecondary secondary phone number.
   * @param email          email.
   * @param web            web.
   */
  public ClientInfo(String firstName, String lastName, String companyName, String address,
      String city, String county, String state, String zip, String phonePrimary,
      String phoneSecondary, String email, String web) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.companyName = companyName;
    this.address = address;
    this.city = city;
    this.county = county;
    this.state = state;
    this.zip = zip;
    this.phonePrimary = phonePrimary;
    this.phoneSecondary = phoneSecondary;
    this.email = email;
    this.web = web;
  }

  /**
   * get the firstName of the client.
   *
   * @return firstName.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * set the firstName of the client.
   *
   * @param firstName firstName.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * get the lastName of the client.
   *
   * @return lastName.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * set the lastName of the client.
   *
   * @param lastName lastName.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * get the companyName of the client.
   *
   * @return companyName.
   */
  public String getCompanyName() {
    return companyName;
  }

  /**
   * set the companyName of the client.
   *
   * @param companyName companyName.
   */
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  /**
   * get the companyName of the client.
   *
   * @return address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * set the companyName of the client.
   *
   * @param address address.
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * get the city of the client.
   *
   * @return city.
   */
  public String getCity() {
    return city;
  }

  /**
   * set the city of the client.
   *
   * @param city city.
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * get the county of the client.
   *
   * @return county.
   */
  public String getCounty() {
    return county;
  }

  /**
   * set the county of the client.
   *
   * @param county county.
   */
  public void setCounty(String county) {
    this.county = county;
  }

  /**
   * get the state of the client.
   *
   * @return state.
   */
  public String getState() {
    return state;
  }

  /**
   * set the state of the client.
   *
   * @param state state.
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * get the zip of the client.
   *
   * @return zip.
   */
  public String getZip() {
    return zip;
  }

  /**
   * set the zip of the client.
   *
   * @param zip zip.
   */
  public void setZip(String zip) {
    this.zip = zip;
  }

  /**
   * get the phonePrimary of the client.
   *
   * @return phonePrimary.
   */
  public String getPhonePrimary() {
    return phonePrimary;
  }

  /**
   * set the phonePrimary of the client.
   *
   * @param phonePrimary phonePrimary.
   */
  public void setPhonePrimary(String phonePrimary) {
    this.phonePrimary = phonePrimary;
  }

  /**
   * get the phoneSecondary of the client.
   *
   * @return phoneSecondary.
   */
  public String getPhoneSecondary() {
    return phoneSecondary;
  }

  /**
   * set the phoneSecondary of the client.
   *
   * @param phoneSecondary phoneSecondary.
   */
  public void setPhoneSecondary(String phoneSecondary) {
    this.phoneSecondary = phoneSecondary;
  }

  /**
   * get the email of the client.
   *
   * @return email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * get the email of the client.
   *
   * @param email email.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * get the web of the client.
   *
   * @return web.
   */
  public String getWeb() {
    return web;
  }

  /**
   * set the web of the client.
   *
   * @param web website.
   */
  public void setWeb(String web) {
    this.web = web;
  }
}
