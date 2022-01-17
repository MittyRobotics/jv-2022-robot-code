/*
 * MIT License
 *
 * Copyright (c) 2020 Mitty Robotics (Team 1351)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.mittyrobotics.drivetrain;

import com.github.mittyrobotics.autonomous.pathfollowing.Path;

/**
 * Constants for the {@link DrivetrainSubsystem}
 */
public class DriveConstants {

    // regular tank drive
    public static final double DRIVE_THRESHOLD = 0.02;
    public static final double DRIVE_TRIGGER_THRESHOLD = 0.1;

    // tankish drive
    public static final double DRIVE_BOOST = 1.4;
    public static final double TURN_RATIO = 1;
    public static final double FINAL_MULTIPLIER = 0.25;

    // drive settings
    public static final double TICKS_PER_INCH = 15359.0/24.0;
    public static final double TICKS_PER_METER = Path.TO_INCHES * 15359.0/24.0;

    public static final int LEFT_FALCON_1 = 10;
    public static final int LEFT_FALCON_2 = 11;
    public static final int RIGHT_FALCON_1 = 12;
    public static final int RIGHT_FALCON_2 = 13;

    public static final boolean LEFT_FALCON_1_INVERT = false;
    public static final boolean LEFT_FALCON_2_INVERT = false;
    public static final boolean RIGHT_FALCON_1_INVERT = true;
    public static final boolean RIGHT_FALCON_2_INVERT = true;
    public static final boolean LEFT_ENCODER_INVERSION = true;
    public static final boolean RIGHT_ENCODER_INVERSION = true;

    public static final double DRIVE_FALCON_FF = (.4*12.0)/122.1;
    public static final double DRIVE_FALCON_P = 0.05;

}
