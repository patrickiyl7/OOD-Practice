package Problem1;

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
   * @param productLine
   * @param height
   * @param width
   * @param depth
   * @param color       Constructor of the Furniture Class.
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
   * @return the height of the furniture.
   */
  public Integer getHeight() {
    return height;
  }

  /**
   * @param height
   */
  public void setHeight(Integer height) {
    this.height = height;
  }

  /**
   * @return the width of the Furniture.
   */
  public Integer getWidth() {
    return width;
  }

  /**
   * @param width
   */
  public void setWidth(Integer width) {
    this.width = width;
  }

  /**
   * @return the depth of the Furniture.
   */
  public Integer getDepth() {
    return depth;
  }

  /**
   * @param depth
   */
  public void setDepth(Integer depth) {
    this.depth = depth;
  }

  /**
   * @return the color of the Furniture.
   */
  public String[] getColor() {
    return color;
  }

  /**
   * @param color
   */
  public void setColor(String[] color) {
    this.color = color;
  }

  /**
   * @return the brand with the size spec of the furniture.
   */
  public String getProductLine() {
    return productLine;
  }

  /**
   * @param productLine
   */
  public void setProductLine(String productLine) {
    this.productLine = productLine;
  }
}
