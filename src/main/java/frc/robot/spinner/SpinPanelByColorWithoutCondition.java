package frc.robot.spinner;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;

import static frc.robot.Robot.spinner;

import java.util.function.Supplier;

public class SpinPanelByColorWithoutCondition extends CommandBase {
  private Supplier<Color> setpoint;
  private Color startingColor;
  private int spinDirection;

  /**
   * Spins the Control Panel to a specified color for stage three.
   */
  public SpinPanelByColorWithoutCondition(Supplier<Color> setpoint) {
    this.setpoint = setpoint;
    SmartDashboard.putNumber("Spin Panel By Color Power", 0);
    SmartDashboard.putString("Starting Color", "Command Didn't Start");
    SmartDashboard.putBoolean("Is on color", false);
    SmartDashboard.putNumber("Spin Direction", 0);
  }

  @Override
  public void initialize() {
    startingColor = spinner.getColor();
    spinDirection = spinner.calculateSpinDirection(startingColor, setpoint.get());
    SmartDashboard.putString("Starting Color", spinner.colorToString(startingColor));
    SmartDashboard.putNumber("Spin Direction", spinDirection);
    SmartDashboard.putString("Setpoint", spinner.colorToString(setpoint.get()));
  }

  @Override
  public void execute() {
    SmartDashboard.putNumber("Spin Panel By Color Power", 0.5 * spinDirection);
    SmartDashboard.putBoolean("Is on color", spinner.isOnColor(setpoint.get()));
  }

  @Override
  public boolean isFinished() {
    return spinner.isOnColor(setpoint.get());
  }

  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putNumber("Spin Panel By Color Power", 0);
  }
}