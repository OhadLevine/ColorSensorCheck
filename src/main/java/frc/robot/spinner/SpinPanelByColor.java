package frc.robot.spinner;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.FMSColor;

/**
 * This class runs the spin panel by by color when the fms sends a color.
 */
public class SpinPanelByColor extends ConditionalCommand {
  public SpinPanelByColor() {
    super(new SpinPanelByColorWithoutCondition(/**FMSColor.getFMSColor()*/), new InstantCommand(),
        () -> FMSColor.didFMSSendColor());
  }
}