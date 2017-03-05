package xyz.thelostlambda.util;

public class Vector extends Tuple {
//constructors
  public Vector (double startX, double startY) {
    super(startX,startY);
  }

//methods
  public void add (Tuple toAdd) {
    this.x += toAdd.getX();
    this.y += toAdd.getY();
  }
  public void scale (double scale) { //hypotenuse of triangle = scale
    double angle = Math.atan2(this.y,this.x);
    this.x = (scale*Math.cos(angle));
    this.y = (scale*Math.sin(angle));
  }
}
