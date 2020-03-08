package frc.robot.spinner;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;

import static frc.robot.Robot.spinner;

public class SpinPanelByRotation extends CommandBase {
    private final double kCloseToTargetSpeed = 0.3;
    private final double kDefaultSpeed = 0.8;
    private Color startingColor;
    private int timesOnColor;
    private double timesToSeeColor;
    private boolean seenColor;

    /**
     * Spins the Control Panel three and a half times.
     */
    public SpinPanelByRotation() {
        this(3.5);
    }

    /**
     * Spins the Control Panel for a specified amount of times.
     */
    public SpinPanelByRotation(double amountOfSpins) {
        addRequirements(spinner);
        timesToSeeColor = amountOfSpins * 2;
    }

    @Override
    public void initialize() {
        seenColor = false;
        startingColor = spinner.getColor();
        timesOnColor = 0;
        SmartDashboard.putString("starting color", spinner.colorToString(startingColor));
        SmartDashboard.putNumber("times to see color", timesToSeeColor);
    }

    @Override
    public void execute() {
        if (spinner.isOnColor(startingColor) && seenColor)
            timesOnColor++;
        seenColor = !spinner.isOnColor(startingColor);

        if ((timesToSeeColor - timesOnColor) <= 1)
            SmartDashboard.putNumber("Rotation Power", kCloseToTargetSpeed);
        else
            SmartDashboard.putNumber("Rotation Power", kDefaultSpeed);

        SmartDashboard.putNumber("Times on color", timesOnColor);
        SmartDashboard.putBoolean("Is on color", spinner.isOnColor(startingColor));
        SmartDashboard.putBoolean("Seen color", seenColor);
    }

    @Override
    public boolean isFinished() {
        return timesOnColor >= timesToSeeColor;
    }

    @Override
    public void end(boolean interrupted) {
        SmartDashboard.putNumber("Rotation Power", 0);
    }
}