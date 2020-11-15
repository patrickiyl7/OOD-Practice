package Problem1;

/**
 * Slothrop product line extends DoorAndDrawer Class.
 */
public class Slothrop extends DoorAndDrawer {

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
