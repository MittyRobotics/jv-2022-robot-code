package com.github.mittyrobotics.autonomous.pathfollowing;

public class Circle {
    private double radius;
    private Point2D center;

    public Circle() {
        this(0, new Point2D());
    }

    public Circle(double radius, Point2D center) {
        this.radius = radius;
        this.center = center;
    }

    public int orientationOfPoseAndPoint(Pose2D pose, Point2D point3) {
        Point2D point1 = pose.getPosition();
        Point2D point2 = new Point2D(point1.getX() + pose.getAngle().cos(), point1.getY() + pose.getAngle().sin());

        double test = (point2.getY() - point1.getY()) * (point3.getX() - point2.getX()) -
                   (point2.getX() - point1.getX()) * (point3.getY() - point2.getY());

        if(Math.abs(test) < 2e-9) return 0;

        return (test > 0) ? 1 : 2;
    }

    public void updateFromPoseAndPoint(Pose2D pose, Point2D other) {
        Angle angleOfRadius = new Angle(pose.getAngle().getRadians() - Math.PI/2);
        Line radius1 = new Line(pose.getPosition(), angleOfRadius);

        Line lineThroughPoints = new Line(pose.getPosition(), other);

        if(Math.abs(lineThroughPoints.getSlope() - pose.getAngle().tan()) < 2e-9) {
            this.radius = Double.POSITIVE_INFINITY;
        } else {
            Point2D midpoint = new Point2D((pose.getPosition().getX() + other.getX()) / 2, (pose.getPosition().getY() + other.getY()) / 2);
            Line radius2 = lineThroughPoints.getTangentAtPoint(midpoint);

            this.center = radius1.getIntersection(radius2);
            this.radius = center.distance(other);
        }
    }

    public double getRadius() {
        return radius;
    }

    public Point2D getCenter() {
        return center;
    }

    public String toString() {
        return "radius = " + radius * Path.TO_INCHES + ", " + "center = " + center.toString();
    }

    public String toStringMetric() {
        return "radius = " + radius + ", " + "center = " + center.toStringMetric();
    }
}
