/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.types.named;

import SmarterDashboard.livewindow.elements.ThreeAxisAccelerometer;
import SmarterDashboard.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class ThreeAxisAccelerometerType extends NamedDataType {

    public static final String LABEL = "3AxisAccelerometer";

    private ThreeAxisAccelerometerType() {
        super(LABEL, ThreeAxisAccelerometer.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new ThreeAxisAccelerometerType();
        }
    }

}
