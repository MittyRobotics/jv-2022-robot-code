package com.github.mittyrobotics.autonomous;

import com.github.mittyrobotics.autonomous.pathfollowing.PurePursuitPath;
import com.github.mittyrobotics.autonomous.pathfollowing.Point2D;

public class BallPositionConstants {
    //All balls labeled clockwise, starting from the blue ball at the acute corner of red alliance
    //reference: https://cad.onshape.com/documents/e491d0b03d0534894c2f50ee/w/746eeb7ee6910a6cbe50eb65/e/6f25d3aee97d55ef18af9901

    //desmos field: https://www.desmos.com/calculator/xksceznwio

    //RED ALLIANCE
    public final Point2D RED_1 = new Point2D(25.910, 150.790);
    public final Point2D RED_2 = new Point2D(124.946, 88.303);
    public final Point2D RED_TERMINAL = new Point2D(282.080, 117.725);

    public final Point2D RED_3 = new Point2D(129.396, -81.643);

    public final Point2D BLUE_1 = new Point2D(-33.767, 149.227);
    public final Point2D BLUE_2 = new Point2D(149.227, 33.767);
    public final Point2D BLUE_3 = new Point2D(88.303, -124.946);



    //BLUE ALLIANCE
    public final Point2D BLUE_4 = new Point2D(-25.910, -150.790);
    public final Point2D BLUE_5 = new Point2D(-124.946, -88.303);
    public final Point2D BLUE_TERMINAL = new Point2D(-282.080, -117.725);

    public final Point2D BLUE_6 = new Point2D(-129.396, 81.643);



    public final Point2D RED_4 = new Point2D(33.767, -149.227);
    public final Point2D RED_5 = new Point2D(-149.227, -33.767);
    public final Point2D RED_6 = new Point2D(-88.303, 124.946);





    //RED ALLIANCE METRIC
    public final Point2D RED_1_METRIC = RED_1.multiply(PurePursuitPath.TO_METERS);
    public final Point2D RED_2_METRIC = RED_2.multiply(PurePursuitPath.TO_METERS);
    public final Point2D RED_TERMINAL_METRIC = RED_TERMINAL.multiply(PurePursuitPath.TO_METERS);

    public final Point2D RED_3_METRIC = RED_3.multiply(PurePursuitPath.TO_METERS);

    public final Point2D BLUE_1_METRIC = BLUE_1.multiply(PurePursuitPath.TO_METERS);
    public final Point2D BLUE_2_METRIC = BLUE_2.multiply(PurePursuitPath.TO_METERS);
    public final Point2D BLUE_3_METRIC = BLUE_3.multiply(PurePursuitPath.TO_METERS);



    //BLUE ALLIANCE METRIC
    public final Point2D BLUE_4_METRIC = BLUE_4.multiply(PurePursuitPath.TO_METERS);
    public final Point2D BLUE_5_METRIC = BLUE_5.multiply(PurePursuitPath.TO_METERS);
    public final Point2D BLUE_TERMINAL_METRIC = BLUE_TERMINAL.multiply(PurePursuitPath.TO_METERS);

    public final Point2D BLUE_6_METRIC = BLUE_6.multiply(PurePursuitPath.TO_METERS);



    public final Point2D RED_4_METRIC = RED_4.multiply(PurePursuitPath.TO_METERS);
    public final Point2D RED_5_METRIC = RED_5.multiply(PurePursuitPath.TO_METERS);
    public final Point2D RED_6_METRIC = RED_6.multiply(PurePursuitPath.TO_METERS);
}
