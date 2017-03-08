package xyz.thelostlambda.util;

public class Barrier extends Point {
//variables
  protected double w;
  protected double h;

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
    return ((p.getX() < (this.x+this.w))&&(p.getX() > (this.x))&&(p.getY() < (this.y+this.h))&&(p.getY() > (this.y)));
  }
  public boolean isBetween (Point p1, Point p2) {
    if (p2.getX()-p1.getX() != 0) {
      double m = (p2.getY()-p1.getY())/(p2.getX()-p1.getX());
      double b = (p1.getY() - (m * p1.getX()));
      return (!(
      (this.getY() < ((m * this.getX()) + b)&&
      (this.getY() + this.getH()) < ((m * this.getX()) + b)&&
      this.getY() < ((m * (this.getX() + this.getW())) + b)&&
      (this.getY() + this.getH()) < ((m * (this.getX() + this.getW())) + b))||
      (this.getY() > ((m * this.getX()) + b)&&
      (this.getY() + this.getH()) > ((m * this.getX()) + b)&&
      this.getY() > ((m * (this.getX() + this.getW())) + b)&&
      (this.getY() + this.getH()) > ((m * (this.getX() + this.getW())) + b)))&&
      ((this.getX() > p1.getX() && this.getX() < p2.getX())||(this.getX() > p2.getX() && this.getX() < p1.getX()))
      );
    } else {
      return !((this.getX() < p1.getX()) || ((this.getX() + this.getW()) > p1.getX()));
    }
  }

  @Override
  public String toString () {
    return ("[" + x + ", " + y + ", " + w + ", " + h + "]");
  }
}
