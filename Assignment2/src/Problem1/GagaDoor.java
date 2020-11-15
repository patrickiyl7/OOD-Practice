package Problem1;

/**
 * GagaDoor product line extends DoorAndDrawer Class.
 */
public class GagaDoor extends DoorAndDrawer {

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

  @Override
  Boolean doorHandleRequirement() {
    return true;
  }

  @Override
  Boolean drawerHandleRequirement() {
    return false;
  }

  @Override
  String[] doorDrawerColorGeneration() {
    return new String[]{"brown", "black", "bone", "oxblood"};
  }
}
