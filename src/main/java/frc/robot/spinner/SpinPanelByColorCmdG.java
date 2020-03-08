package frc.robot.spinner;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

import static frc.robot.Robot.spinner;

public class SpinPanelByColorCmdG extends SequentialCommandGroup {
  private static final int minimumProximity = 1000;
  /**
   * spins the control panel by color only when it is close enough
   */
  public SpinPanelByColorCmdG() {
    super(
      //new SetSpinnerOpener(true), //TODO: add spinner opener here
      new WaitUntilCommand(() -> spinner.getProximity() > minimumProximity),
      new SpinPanelByColor()
    );
    addRequirements(spinner);
  }
}
