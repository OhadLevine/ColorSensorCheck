package frc.robot.spinner;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;

import static frc.robot.Robot.spinner;

public class SpinPanelByColorWithoutCondition extends CommandBase {
  // private Color setpoint;
  // private Color startingColor;
  // private int spinDirection;

  /**
   * Spins the Control Panel to a specified color for stage three.
   */
  public SpinPanelByColorWithoutCondition(/**Color setpoint*/) {
    // this.setpoint = setpoint;
    // SmartDashboard.putNumber("Spin Panel By Color Power", 0);
    // SmartDashboard.putString("Starting Color", "Command Didn't Start");
    // SmartDashboard.putBoolean("Is on color", false);
    // SmartDashboard.putNumber("Spin Direction", 0);
    SmartDashboard.putString("Command", "Constructed");
  }

  @Override
  public void initialize() {
    SmartDashboard.putString("Command", "Initialized");
    // startingColor = spinner.getColor();
    // spinDirection = spinner.calculateSpinDirection(startingColor, setpoint);
    // SmartDashboard.putString("Starting Color", spinner.ColorToString(startingColor));
    // SmartDashboard.putNumber("Spin Direction", spinDirection);
    // SmartDashboard.putString("Setpoint", spinner.ColorToString(setpoint));
  }

  @Override
  public void execute() {
    System.out.println("hi");
    SmartDashboard.putString("Command", "Execute");
    // SmartDashboard.putNumber("Spin Panel By Color Power", 0.5 * spinDirection);
    // SmartDashboard.putBoolean("Is on color", spinner.isOnColor(setpoint));
  }

  @Override
  public boolean isFinished() {
    // return spinner.isOnColor(setpoint.get());
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    // SmartDashboard.putNumber("Spin Panel By Color Power", 0);
    SmartDashboard.putString("Command", "Finished");
  }
}