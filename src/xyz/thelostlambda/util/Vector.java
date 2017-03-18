package xyz.thelostlambda.util;

public class Vector extends Tuple {
//constructors
  public Vector (double startX, double startY) {
    super(startX,startY);
  }

//methods
  public void add (Tuple toAdd) {
    this.setX(this.getX() + toAdd.getX());
    this.setY(this.getY() + toAdd.getY());
  }
  public void scale (double scale) { //hypotenuse of triangle = scale
    double angle = Math.atan2(this.getY(), this.getX());
    this.setX(scale*Math.cos(angle));
    this.setY(scale*Math.sin(angle));
  }
}
