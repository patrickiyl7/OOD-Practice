package Problem1;

/**
 * GagaDrawer product line extends DoorAndDrawer Class.
 */
public class GagaDrawer extends DoorAndDrawer {

  public GagaDrawer(Integer height, Integer width, Integer depth, String[] color) {
    super("GagaDrawer", height, width, depth, color);
    if(height == 36)
    {
      this.productLine = "GagaDrawer Half";
    }
    if(height == 18)
    {
      this.productLine = "GagaDrawer Quarter";
    }
  }

  @Override
  Boolean doorHandleRequirement() {
    return false;
  }

  @Override
  Boolean drawerHandleRequirement() {
    return true;
  }

  @Override
  String[] doorDrawerColorGeneration() {
    return new String[]{"brown", "black", "bone", "oxblood"};
  }
}

