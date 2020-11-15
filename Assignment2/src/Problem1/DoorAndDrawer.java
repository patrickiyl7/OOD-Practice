package Problem1;

/**
 *  abstract class DoorAndDrawer extends Furniture.
 */
public abstract class DoorAndDrawer extends Furniture {


  /**
   * @param productLine productLine of the DoorAndDrawer part.
   * @param height height of the DoorAndDrawer part.
   * @param width width of the DoorAndDrawer part.
   * @param depth depth of the DoorAndDrawer part.
   * @param color color of the DoorAndDrawer part.
   */
  public DoorAndDrawer(String productLine, Integer height, Integer width, Integer depth, String[] color) {
    super(productLine, height, width, depth, color);
    this.depth = 0;
  }

  abstract Boolean doorHandleRequirement();
  abstract Boolean drawerHandleRequirement();
  abstract String[] doorDrawerColorGeneration();
}
