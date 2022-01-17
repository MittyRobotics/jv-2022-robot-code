package com.github.mittyrobotics.autonomous.pathfollowing;

public class Angle {
    private double radians;

    public Angle() {
        this(0);
    }

    public Angle(double x, double y) {
        this(Math.atan2(y, x));
    }

    public Angle(double radians) {
        this.radians = standardize(radians);
    }

    public Angle(Point2D point) {
        this(point.getX(), point.getY());
    }

    public double tan() {
        if(Math.cos(radians) == 0) {
            return (Math.sin(radians) > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY);
        }
        return Math.tan(radians);
    }

    public void add(double radians) {
        this.radians = standardize(this.radians + radians);
    }

    public double sin() {
        return Math.sin(radians);
    }

    public double cos() {
        return Math.cos(radians);
    }

    public double getRadians() {
        return radians;
    }

    public String toString() {
        return radians * 180 / Math.PI + "°";
    }

    public String toStringMetric() {
        return radians + "";
    }

    public double getAngleBetween(Angle other) {
        double phi = Math.abs(this.radians - other.radians) % (2*Math.PI);
        return phi > Math.PI ? 2*Math.PI - phi : phi;
    }

    public static double standardize(double radians) {
        if(radians > 0) return radians - (2*Math.PI) * (int)(radians / (2*Math.PI));
        else return radians + (2*Math.PI) * ((int)(radians / (2*Math.PI))+1);
    }

}
