package Problem1;

/**
 * Belacqua product line extends DoorAndDrawer Class.
 */
public class Belacqua extends DoorAndDrawer {

  /**
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

  @Override
  Boolean doorHandleRequirement() {
    return false;
  }

  @Override
  Boolean drawerHandleRequirement() {
    return false;
  }

  @Override
  String[] doorDrawerColorGeneration() {
    return new String[]{"brown", "black"};
  }
}
