/**
 * Abstract class of Furniture with details:productLine, height, width, depth, color.
 */
public abstract class Furniture {

  String productLine;
  Integer height;
  Integer width;
  Integer depth;
  String[] color;


  /**
   * Constructor of the Furniture Class.
   *
   * @param productLine productLine.
   * @param height height.
   * @param width width.
   * @param depth depth.
   * @param color color.
   */
  public Furniture(String productLine, Integer height, Integer width, Integer depth,
      String[] color) {
    this.productLine = productLine;
    this.height = height;
    this.width = width;
    this.depth = depth;
    this.color = color;
  }

  /**
   * height getter.
   *
   * @return the height of the furniture.
   */
  public Integer getHeight() {
    return height;
  }

  /**
   * height setter.
   *
   * @param height height.
   */
  public void setHeight(Integer height) {
    this.height = height;
  }

  /**
   * width getter.
   *
   * @return the width of the Furniture.
   */
  public Integer getWidth() {
    return width;
  }

  /**
   * width setter.
   *
   * @param width width.
   */
  public void setWidth(Integer width) {
    this.width = width;
  }

  /**
   * depth getter.
   *
   * @return the depth of the Furniture.
   */
  public Integer getDepth() {
    return depth;
  }

  /**
   * depth setter.
   *
   * @param depth depth.
   */
  public void setDepth(Integer depth) {
    this.depth = depth;
  }

  /**
   * color getter.
   *
   * @return the color of the Furniture.
   */
  public String[] getColor() {
    return color;
  }

  /**
   * color setter.
   *
   * @param color color.
   */
  public void setColor(String[] color) {
    this.color = color;
  }

  /**
   * productLine getter.
   *
   * @return the brand with the size spec of the furniture.
   */
  public String getProductLine() {
    return productLine;
  }

  /**
   * productLine setter.
   *
   * @param productLine productLine.
   */
  public void setProductLine(String productLine) {
    this.productLine = productLine;
  }
}

