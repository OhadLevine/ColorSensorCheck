package frc.robot.spinner;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

import static frc.robot.Robot.spinner;

public class SpinPanelByColorCmd extends SequentialCommandGroup {
  private static final int minimumProximity = 1500;
  /**
   * spins the control panel by color only when it is close enough
   */
  public SpinPanelByColorCmd() {
    super(
      //new SetIntakeOpener(true),
      new WaitUntilCommand(() -> spinner.getProximity() > minimumProximity),
      new SpinPanelByColor()
    );
    addRequirements(spinner);
  }
}
