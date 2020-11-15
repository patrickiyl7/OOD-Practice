/**
 * Belacqua product line extends DoorAndDrawer Class.
 */
public class Belacqua extends DoorAndDrawer {

  /**
   * Constructor of Belacqua Product Line.
   *
   * @param height height of the Belacqua Class.
   * @param width width of the Belacqua Class.
   * @param depth depth of the Belacqua Class.
   * @param color color of the Belacqua Class.
   */
  public Belacqua(Integer height, Integer width, Integer depth, String[] color) {
    super("Belacqua", height, width, depth, color);
    if(height == 72)
    {
      this.productLine = "Belacqua Wardrobe";
    }
    if(height == 36)
    {
      this.productLine = "Belacqua Half";
    }
    if(height == 18)
    {
      this.productLine = "Belacqua Quarter";
    }
  }

  /**
   * doorHandleRequirement function.
   * @return doorHandleRequirement.
   */
  @Override
  Boolean doorHandleRequirement() {
    return false;
  }

  /**
   * drawerHandleRequirement function.
   * @return drawerHandleRequirement.
   */
  @Override
  Boolean drawerHandleRequirement() {
    return false;
  }

  /**
   * color generation of current door or drawer.
   * @return String array included color generated.
   */
  @Override
  String[] doorDrawerColorGeneration() {
    return new String[]{"brown", "black"};
  }
}
