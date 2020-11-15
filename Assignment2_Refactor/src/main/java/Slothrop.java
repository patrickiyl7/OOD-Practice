
/**
 * Slothrop product line extends DoorAndDrawer Class.
 */
public class Slothrop extends DoorAndDrawer {

  /**
   * Constructor of the Slothrop product line.
   *
   * @param height height
   * @param width width
   * @param depth depth
   * @param color color
   */
  public Slothrop(Integer height, Integer width, Integer depth, String[] color) {
    super("Slothrop", height, width, depth, color);
    if(height == 72)
    {
      this.productLine = "Slothrop Wardrobe";
    }
    if(height == 36)
    {
      this.productLine = "Slothrop Half";
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
   * doorDrawerColorGeneration function.
   * @return doorDrawerColorGeneration.
   */
  @Override
  String[] doorDrawerColorGeneration() {
    return new String[]{"brown", "black"};
  }
}
