/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.src.types.named;

import SmarterDashboard.src.livewindow.elements.ThreeAxisAccelerometer;
import SmarterDashboard.src.types.NamedDataType;

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
