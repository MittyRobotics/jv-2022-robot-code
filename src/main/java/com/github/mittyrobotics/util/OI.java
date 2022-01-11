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

package com.github.mittyrobotics.util;

import com.github.mittyrobotics.drivetrain.DrivetrainSubsystem;
import com.github.mittyrobotics.drivetrain.commands.ManualTankDriveCommand;
import edu.wpi.first.wpilibj.XboxController;

/**
 * OI Class to manage all controllers and input
 */
public class OI {
    /**
     * {@link OI} instance
     */
    private static OI instance;

    /**
     * OI {@link XboxController}
     */
    private XboxController xboxController;
    private XboxController xboxController2;

    /**
     * Variable to store if the robot is in auto shoot mode
     */
    private boolean inAutoShootMode = false;

    /**
     * Returns an {@link OI} instance
     *
     * @return {@link OI} instance
     */
    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        return instance;
    }

    /**
     * Returns the {@link XboxController} instance
     *
     * @return {@link XboxController} instance
     */
    public XboxController getXboxController() {
        if (xboxController == null) {
            xboxController = new XboxController(OIConstants.XBOX_CONTROLLER_ID);
        }
        return xboxController;
    }

    public XboxController getXboxController2() {
        if (xboxController2 == null) {
            xboxController2 = new XboxController(OIConstants.XBOX_CONTROLLER_2_ID);
        }
        return xboxController2;
    }

    public void testSetupControls() {

    }

        /**
     * Setup controls
     */
    public void setupControls() {
        // DRIVER CONTROLS
        DrivetrainSubsystem.getInstance().setDefaultCommand(new ManualTankDriveCommand());

        // OPERATOR CONTROLS
        // --------------------------


    }
}