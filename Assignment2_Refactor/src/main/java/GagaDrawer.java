/**
 * GagaDrawer product line extends DoorAndDrawer Class.
 */
public class GagaDrawer extends DoorAndDrawer {

  /**
   * Constructor of the GagaDrawer product line.
   *
   * @param height height
   * @param width width
   * @param depth depth
   * @param color color
   */
  public GagaDrawer(Integer height, Integer width, Integer depth, String[] color) {
    super("GagaDrawer", height, width, depth, color);
    if(height == 18)
    {
      this.productLine = "GagaDrawer Quarter";
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
    return true;
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

