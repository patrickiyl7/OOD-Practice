/**
 * GagaDoor product line extends DoorAndDrawer Class.
 */
public class GagaDoor extends DoorAndDrawer {

  /**
   * Constructor of the gagaDoor product line.
   *
   * @param height height
   * @param width width
   * @param depth depth
   * @param color color
   */
  public GagaDoor(Integer height, Integer width, Integer depth, String[] color) {
    super("GagaDoor", height, width, depth, color);
    if(height == 36)
    {
      this.productLine = "GagaDoor Half";
    }
    if(height == 18)
    {
      this.productLine = "GagaDoor Quarter";
    }
  }

  /**
   * doorHandleRequirement function.
   * @return doorHandleRequirement.
   */
  @Override
  Boolean doorHandleRequirement() {
    return true;
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
   * doorDrawerColorGeneration function.
   * @return doorDrawerColorGeneration.
   */
  @Override
  String[] doorDrawerColorGeneration() {
    return new String[]{"brown", "black", "bone", "oxblood"};
  }
}
