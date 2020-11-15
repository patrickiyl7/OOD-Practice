import java.util.ArrayList;
import java.util.List;

public class FurnitureDatabase {

  List<Cabinet> cabinetProducts;
  List<DoorAndDrawer> drawerFrontProducts;
  List<DoorAndDrawer> doorProducts;

  public FurnitureDatabase() throws Exception {
    cabinetProducts = new ArrayList<>();
    drawerFrontProducts = new ArrayList<>();
    doorProducts = new ArrayList<>();
    Yossarian yossarianWardrobe = new Yossarian(72, 36, 16);
    Yossarian yossarianHalf = new Yossarian(36, 36, 16);
    Yossarian yossarianQuarter = new Yossarian(18, 36, 16);
    Luthien luthienHalf = new Luthien(36, 36, 18);
    Luthien luthienQuarter = new Luthien(18, 36, 18);
    Atreides atreidesHalf = new Atreides(36, 36, 16);
    Atreides atreidesQuarter = new Atreides(18, 36, 16);
    cabinetProducts.add(yossarianWardrobe);
    cabinetProducts.add(yossarianHalf);
    cabinetProducts.add(yossarianQuarter);
    cabinetProducts.add(luthienHalf);
    cabinetProducts.add(luthienQuarter);
    cabinetProducts.add(atreidesHalf);
    cabinetProducts.add(atreidesQuarter);

    Slothrop slothropWardrobe = new Slothrop(72, 36, 0, new String[]{"brown", "black"});
    Slothrop slothropHalf = new Slothrop(36, 36, 0, new String[]{"brown", "black"});
    Belacqua belacquaWardrobe = new Belacqua(72, 36, 0, new String[]{"bone", "oxblood"});
    Belacqua belacquaHalf = new Belacqua(36, 36, 0, new String[]{"bone", "oxblood"});
    Belacqua belacquaQuater = new Belacqua(18, 36, 0, new String[]{"bone", "oxblood"});
    GagaDoor gagaDoorQuater = new GagaDoor(18, 38, 0,
        new String[]{"brown", "black", "bone", "oxblood"});
    doorProducts.add(slothropWardrobe);
    doorProducts.add(slothropHalf);
    doorProducts.add(belacquaWardrobe);
    doorProducts.add(belacquaHalf);
    doorProducts.add(belacquaQuater);
    doorProducts.add(gagaDoorQuater);
  }

  public List<Cabinet> getCabinetProducts() {
    return cabinetProducts;
  }

  public List<DoorAndDrawer> getDrawerFrontProducts() {
    return drawerFrontProducts;
  }

  public List<DoorAndDrawer> getDoorProducts() {
    return doorProducts;
  }
}
