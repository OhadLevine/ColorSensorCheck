package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.util.Color;

import static frc.robot.Robot.spinner;

/**
 * This class gets a string of the desired control panel color and converts it
 * to a Color.
 */
public final class FMSColor {

    private FMSColor() {
        throw new UnsupportedOperationException("This is a utility class!");
    }

    public static Color getFMSColor() {
        String gameData;
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        if (gameData.length() > 0) {
            switch (gameData.charAt(0)) {
            case 'B':
                return spinner.kBlue;
            case 'G':
                return spinner.kGreen;
            case 'R':
                return spinner.kRed;
            case 'Y':
                return spinner.kYellow;
            default:
                System.out.println("FMS COLOR DATA IS CORRUPT");
                return null;
            }
        } else {
            System.out.println("Did not get any fms data");
            return null;
        }
    }

    public static boolean didFMSSendColor() {
        return getFMSColor() != null;
    }
}
