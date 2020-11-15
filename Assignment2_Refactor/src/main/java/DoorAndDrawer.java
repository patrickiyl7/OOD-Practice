

/**
 *  abstract class DoorAndDrawer extends Furniture.
 */
public abstract class DoorAndDrawer extends Furniture {


  /**
   * Constructor of the Door and Drawer Class.
   *
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

  /**
   * doorHandleRequirement function.
   * @return doorHandleRequirement.
   */
  abstract Boolean doorHandleRequirement();

  /**
   * drawerHandleRequirement function.
   * @return drawerHandleRequirement.
   */
  abstract Boolean drawerHandleRequirement();

  /**
   * doorDrawerColorGeneration function.
   * @return doorDrawerColorGeneration.
   */
  abstract String[] doorDrawerColorGeneration();
}
