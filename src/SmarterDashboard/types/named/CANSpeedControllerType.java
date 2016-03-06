
package SmarterDashboard.types.named;

import SmarterDashboard.livewindow.elements.CANSpeedController;
import SmarterDashboard.types.NamedDataType;

/**
 *
 * @author Sam Carlberg
 */
public class CANSpeedControllerType extends NamedDataType {

    public static final String LABEL = "CANSpeedController";

    private CANSpeedControllerType() {
        super(LABEL, CANSpeedController.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new CANSpeedControllerType();
        }
    }

}
