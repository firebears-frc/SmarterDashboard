package SmarterDashboard.types.named;

import SmarterDashboard.gui.elements.*;
import SmarterDashboard.types.*;

/**
 *
 * @author Joe Grinstead
 */
public class GyroType extends NamedDataType {

    public static final String LABEL = "Gyro";

    private GyroType() {
        super(LABEL, Compass.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new GyroType();
        }
    }
}