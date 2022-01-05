package ro.utcluj.model;

public abstract class Product implements DescriptionAware {

  private Double price;

  public void describeYourself() {
    System.out.println("Hello. I am " + getDescription());
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
