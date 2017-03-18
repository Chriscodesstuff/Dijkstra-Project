package xyz.thelostlambda.util;

public class Barrier extends Point {
//variables
  private double w;
  private double h;

//constructors
  public Barrier (double x, double y, double w, double h) {
    super(x,y);
    this.w = w;
    this.h = h;
  }

//getters
  public double getW () {
    return this.w;
  }
  public double getH () {
    return this.h;
  }

//setters
  public void setW (double w) {
    this.w = w;
  }
  public void setH (double h) {
    this.h = h;
  }

//methods
  public boolean contains (Point p) {
    return ((p.getX() < (this.getX()+this.w))&&(p.getX() > (this.getX()))&&(p.getY() < (this.getY()+this.h))&&(p.getY() > (this.getY())));
  }
  public boolean isBetween (Point p1, Point p2) {
    Point leftP = (p1.getX() < p2.getX()) ? p1 : p2;
    Point rightP = (p1.getX() > p2.getX()) ? p1 : p2;

    Point tL = new Point(this.getX(), this.getY() + h);
    Point bL = new Point(this.getX(), this.getY());
    Point tR = new Point(this.getX() + w, this.getY() + h);
    Point bR = new Point(this.getX() + w, this.getY());
    Point[] corners = {tL, bL, tR, bR};

    boolean allBelow = true;
    boolean allAbove = true;

    if (p2.getX()-p1.getX() != 0) {
      double m = ( p2.getY() - p1.getY() ) / ( p2.getX() - p1.getX() );
      double b = ( p1.getY() - ( m * p1.getX() ) );
      for (Point corner : corners) {
        if ((corner.getX() > leftP.getX()) && (corner.getX() < rightP.getX())) {
          if (corner.getY() < (m * corner.getX()) + b) {
            allAbove = false;
          }
        }
      }
      for (Point corner : corners) {
        if ((corner.getX() > leftP.getX()) && (corner.getX() < rightP.getX())) {
          if (corner.getY() > (m * corner.getX()) + b) {
            allBelow = false;
          }
        }
      }

      return !(allBelow||allAbove);
    } else {
      return !((this.getX() < p1.getX()) || ((this.getX() + this.getW()) > p1.getX()));
    }
  }

  @Override
  public String toString () {
    return ("[" + this.getX() + ", " + this.getY() + ", " + w + ", " + h + "]");
  }
}
