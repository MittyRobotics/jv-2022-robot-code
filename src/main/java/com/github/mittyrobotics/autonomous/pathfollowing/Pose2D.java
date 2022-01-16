package com.github.mittyrobotics.autonomous.pathfollowing;

public class Pose2D {
    private Point2D position;
    private Angle angle;

    public Pose2D() {
        this(new Point2D(), new Angle());
    }

    public Pose2D(Vector2D position, Angle angle) {
        this.angle = angle;
        this.position = new Point2D(position);
    }

    public Pose2D(Point2D position, Angle angle) {
        this.angle = angle;
        this.position = position;
    }

    public Pose2D(double x, double y, double angle) {
        this.position = new Point2D(x, y);
        this.angle = new Angle(angle);
    }

    public double distance(Pose2D other) {
        return other.getPosition().distance(this.position);
    }

    public Point2D getPosition() {
        return position;
    }

    public Angle getAngle() {
        return angle;
    }

    public String toString() {
        return position.toString() + ", " + angle.toString();
    }

    public String toStringMetric() {
        return position.toStringMetric() + ", " + angle.toStringMetric();
    }
}
