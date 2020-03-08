package frc.robot.spinner;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Spinner extends SubsystemBase {
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch colorMatcher = new ColorMatch();
  public final Color kBlue = ColorMatch.makeColor(0.122, 0.428, 0.448);
  public final Color kGreen = ColorMatch.makeColor(0.162, 0.587, 0.249);
  public final Color kRed = ColorMatch.makeColor(0.530, 0.340, 0.128); 
  public final Color kYellow = ColorMatch.makeColor(0.317, 0.564, 0.116);
  

  /**
   * This class holds all the methods for the spinner, instead of motors we put in
   * the dashboard.
   */
  public Spinner() {
    createColors();
  }
  
  /**
   * @return an enum of the color, including unknown if the minimum threshold is
   *         not met.
   */
  public Color getColor() {
    return colorSensor.getColor();
  }

  /**
   * @return Proximity measurement value, ranging from 0 - far, to 2047 - close.
   */
  public int getProximity() {
    return colorSensor.getProximity();
  }

  public boolean isOnColor(Color color) {
    return compareColors(colorSensor.getColor(), color);
  }

  public boolean compareColors(Color color, Color colorToCompare) {
    ColorMatchResult match = colorMatcher.matchClosestColor(color);
    return match.color == colorToCompare;
  }

  public int calculateSpinDirection(Color currentColor, Color desiredColor) {
    Color[] colors = { kBlue, kYellow, kGreen, kRed, kBlue };
    int currentColorIndex = 0;
    int desiredColorIndex = 0;
    for (int i = 0; i < colors.length - 1; i++) {
      if (compareColors(currentColor, colors[i]))
        currentColorIndex = i;
      if (compareColors(desiredColor, colors[i]))
        desiredColorIndex = i;
    }
    if (compareColors(colors[currentColorIndex + 1], colors[desiredColorIndex]))
      return 1;
    else
      return -1;
  }

  private void createColors() {
    colorMatcher.addColorMatch(kBlue);
    colorMatcher.addColorMatch(kGreen);
    colorMatcher.addColorMatch(kRed);
    colorMatcher.addColorMatch(kYellow);
    colorMatcher.setConfidenceThreshold(0.9);
  }

  public String ColorToString(Color color) {
    if (compareColors(color, kBlue)) {
      return "Blue";
    } else if (compareColors(color, kRed)) {
      return "Red";
    } else if (compareColors(color, kGreen)) {
      return "Green";
    } else if (compareColors(color, kYellow)) {
      return "Yellow";
    } else {
      return "Unknown";
    }
  }
}
