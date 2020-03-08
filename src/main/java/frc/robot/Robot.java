package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.spinner.SpinPanelByColor;
import frc.robot.spinner.SpinPanelByColorCmdG;
import frc.robot.spinner.SpinPanelByColorWithoutCondition;
import frc.robot.spinner.SpinPanelByRotation;
import frc.robot.spinner.Spinner;

public class Robot extends TimedRobot {
  public static Spinner spinner;

  @Override
  public void robotInit() {
    spinner = new Spinner();
    SmartDashboard.putData("Spin Panel by color without condition",
        new SpinPanelByColorWithoutCondition(() -> spinner.kBlue));
    SmartDashboard.putData("Spin Panel by color with condition", new SpinPanelByColor());
    SmartDashboard.putData("Spin Panel by color cmdg", new SpinPanelByColorCmdG(true));
    SmartDashboard.putNumber("Spin Panel amount of spins", 3.5);
    SmartDashboard.putData("Spin Panel by rotation",
        new SpinPanelByRotation(SmartDashboard.getNumber("Spin Panel amount of spins", 3.5)));
    SmartDashboard.putData("Spin Panel by rotation cmdg", new SpinPanelByColorCmdG(false));
    SmartDashboard.putString("Setpoint", "not yet");
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("Red", spinner.getColor().red);
    SmartDashboard.putNumber("Green", spinner.getColor().green);
    SmartDashboard.putNumber("Blue", spinner.getColor().blue);
    SmartDashboard.putNumber("Proximity", spinner.getProximity());
    SmartDashboard.putString("Detected Color", spinner.colorToString(spinner.getColor()));
  }
}