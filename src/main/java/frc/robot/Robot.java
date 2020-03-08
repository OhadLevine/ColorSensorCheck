package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.spinner.SpinPanelByColor;
import frc.robot.spinner.SpinPanelByColorCmd;
import frc.robot.spinner.SpinPanelByColorWithoutCondition;
import frc.robot.spinner.Spinner;

public class Robot extends TimedRobot {
  public static Spinner spinner;

  @Override
  public void robotInit() {
    spinner = new Spinner();
    SmartDashboard.putData("Spin Panel by color without condition",
    new SpinPanelByColorWithoutCondition(/** spinner.kBlue */
    ));
    // SmartDashboard.putString("Setpoint", "not yet");
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Red", spinner.getColor().red);
    SmartDashboard.putNumber("Green", spinner.getColor().green);
    SmartDashboard.putNumber("Blue", spinner.getColor().blue);
    SmartDashboard.putNumber("Proximity", spinner.getProximity());
    SmartDashboard.putString("Detected Color", spinner.ColorToString(spinner.getColor()));
  }
}